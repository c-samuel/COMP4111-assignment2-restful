package comp4111.restful.book;

/**
 * Created by SC on 20/3/2018.
 */
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BookRepository extends CrudRepository<Book, Long>{

    // Select a from Book where a.topicname = :topicname
    Collection<Book> findByTitle(String bookName);
}