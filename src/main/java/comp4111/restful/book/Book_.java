package comp4111.restful.book;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Book.class)
public class Book_ {
    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, String> publisher;
    public static volatile SingularAttribute<Book, Integer> year;
    public static volatile SingularAttribute<Book, Boolean> available;
}