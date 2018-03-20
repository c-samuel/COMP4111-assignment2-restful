package comp4111.restful.topic;

import comp4111.restful.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by SC on 20/3/2018.
 */
@Entity
public class Topic extends BaseEntity {

    private String topicName;
    private int questionCount;

    protected Topic() {
        super();
    }

    public Topic(String topicName, int questionCount) {
        this();
        this.topicName = topicName;
        this.questionCount = questionCount;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}