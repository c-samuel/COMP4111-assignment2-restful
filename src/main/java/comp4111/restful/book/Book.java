package comp4111.restful.book;

import comp4111.restful.core.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by SC on 20/3/2018.
 */
@Entity
public class Book extends BaseEntity {

    private String title;
    private String author;
    private String publisher;
    private Integer year;

    private Boolean available;

    public Book(String title, String author, String publisher, Integer year, Boolean available) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.available = available;
    }

    protected Book() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}