package comp4111.restful.book;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import comp4111.restful.core.Util;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.List;

/**
 * Created by SC on 20/3/2018.
 */
@RestController
@RequestMapping("/BookManagementService/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;


    // TODO:
    @RequestMapping(method = RequestMethod.GET)
    Collection<Book> getAllBooks() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "title/{title}")
    public Collection<Book> getBookByTitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }

    @RequestMapping(method = RequestMethod.GET, value = "bookId/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookRepository.getOne(bookId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        List<Book> books = bookRepository.findByTitleAndAuthorAndPublisherAndYear(
                book.getTitle(), book.getAuthor(), book.getPublisher(), book.getYear());

        if (books.size() > 0) {
            return new ResponseEntity<>("Duplicate record: /BookManagementService/books/" + books.get(0).getId(), HttpStatus.CONFLICT);
        } else {
            Book savedBook = bookRepository.save(new Book(book.getTitle(), book.getAuthor(), book.getPublisher(), book.getYear(), true));
            if (savedBook != null) {
                return Util.createResponseEntity("Location: /BookManagementService/books/" + savedBook.getId(), HttpStatus.CREATED);
            }
            return Util.createResponseEntity("Error creating resource", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateBook(@RequestBody String request, @PathVariable Long id) {

        try {
            Book newBook = bookRepository.getOne(id);

            JSONObject json = new JSONObject(request);
            Boolean available = json.getBoolean("Available");

            if (newBook.getAvailable() && !available || (!newBook.getAvailable() && available)) {
                newBook.setAvailable(available);
                if (bookRepository.save(newBook).getId().equals(id)) {
                    return Util.createResponseEntity("", HttpStatus.OK);
                }
            } else {
                return Util.createResponseEntity("", HttpStatus.BAD_REQUEST);
            }
        } catch (EntityNotFoundException e) {
            return Util.createResponseEntity("No book record", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return Util.createResponseEntity("", HttpStatus.BAD_REQUEST);
        }

        return Util.createResponseEntity("", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    ResponseEntity<?> deleteBook(@PathVariable long bookId) {
        try {
            bookRepository.deleteById(bookId);
            return Util.createResponseEntity("", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return Util.createResponseEntity("No book record", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return Util.createResponseEntity("", HttpStatus.BAD_REQUEST);
        }
    }

}