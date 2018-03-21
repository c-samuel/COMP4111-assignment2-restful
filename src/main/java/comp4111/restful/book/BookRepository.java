package comp4111.restful.book;

/**
 * Created by SC on 20/3/2018.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor {
    // Select a from Book where a.topicname = :topicname
    List<Book> findByTitle(String bookName);
    List<Book> findByTitleAndAuthorAndPublisherAndYear(String title, String author, String publisher, Integer year);

    Collection<Book> findByAuthor(String author);
    Collection<Book> findByPublisher(String Publisher);
    Collection<Book> findByYear(Integer year);
}