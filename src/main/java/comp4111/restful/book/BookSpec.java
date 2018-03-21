package comp4111.restful.book;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpec implements Specification<Book>{

    private final Book example;

    public BookSpec(Book example) {
        this.example = example;
    }

    @Override
    public Specification<Book> and(Specification<Book> other) {
        return null;
    }

    @Override
    public Specification<Book> or(Specification<Book> other) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (example.getId() != null) {
            predicates.add(cb.equal(root.get(Book_.id), example.getId()));
        }

        if (example.getAuthor() != null && !example.getAuthor().isEmpty()) {
            final Predicate predicate = cb.like(cb.lower(root.get(Book_.author)), "%" + example.getAuthor() + "%");
            predicates.add(predicate);
        }

        if (example.getTitle() != null && !example.getTitle().isEmpty()) {
            final Predicate predicate = cb.like(cb.lower(root.get(Book_.title)), "%" + example.getTitle() + "%");
            predicates.add(predicate);
        }

        return andTogether(predicates, cb);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }

}
