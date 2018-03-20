package comp4111.restful.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by SC on 20/3/2018.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    protected BaseEntity() {
        this.id = null;
    }

    public Long getId() {
        return id;
    }
}