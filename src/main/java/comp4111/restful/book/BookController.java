package comp4111.restful.book;

import com.google.common.collect.Lists;
import comp4111.restful.core.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by SC on 20/3/2018.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

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
        return bookRepository.findOne(bookId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        if (bookRepository.save(new Book(book.getTitle(), book.getAuthor(), book.getPublisher(),
                book.getYear(), book.getAvailable())) != null)
        {
            return Util.createResponseEntity("Successful creation of a resource", HttpStatus.CREATED);
        }
        return Util.createResponseEntity("Error creating resource", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "bookId/{bookId}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable long bookId) {
        Book newBook = bookRepository.findOne(bookId);
        if (newBook != null) {
            newBook.setTitle(book.getTitle());
            newBook.setAuthor(book.getAuthor());
            newBook.setPublisher(book.getPublisher());
            newBook.setYear(book.getYear());
            newBook.setAvailable(book.getAvailable());
            if (bookRepository.save(newBook).getId().equals(bookId)) {
                return Util.createResponseEntity("Data updated successfully", HttpStatus.OK);
            }
        }
        return Util.createResponseEntity("Error updating data", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "bookId/{bookId}")
    ResponseEntity<?> deleteBook(@PathVariable long bookId) {
        try {
            bookRepository.delete(bookId);
            return Util.createResponseEntity("Data deleted successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return Util.createResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
        }
    }

}