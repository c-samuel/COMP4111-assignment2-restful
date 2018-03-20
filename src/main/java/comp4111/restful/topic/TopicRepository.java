package comp4111.restful.topic;

/**
 * Created by SC on 20/3/2018.
 */
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TopicRepository extends CrudRepository<Topic, Long>{

    // Select a from Topic where a.topicname = :topicname
    Collection<Topic> findByTopicName(String topicName);
}