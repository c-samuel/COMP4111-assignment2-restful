package comp4111.restful;

import javax.persistence.Entity;

/**
 * Created by SC on 20/3/2018.
 */
@Entity
public class Topic extends BaseEntity {

    private String name;
    private int questionCount;

    protected Topic() {
        super();
    }

    public Topic(String name, int questionCount) {
        this();
        this.name = name;
        this.questionCount = questionCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}