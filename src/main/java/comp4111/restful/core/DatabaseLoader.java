package comp4111.restful.core;

import comp4111.restful.book.Book;
import comp4111.restful.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by SC on 20/3/2018.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {

    private BookRepository books;

    @Autowired
    public DatabaseLoader(BookRepository books) {
        this.books = books;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}