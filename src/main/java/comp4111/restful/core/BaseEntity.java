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
    private final Integer id;

    protected BaseEntity() {
        this.id = null;
    }

    public Integer getId() {
        return id;
    }
}