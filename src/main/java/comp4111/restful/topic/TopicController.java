package comp4111.restful.topic;

import com.google.common.collect.Lists;
import comp4111.restful.core.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by SC on 20/3/2018.
 */
@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping(method = RequestMethod.GET)
    Collection<Topic> getAllTopics() {
        return Lists.newArrayList(topicRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "topicName/{topicName}")
    public Collection<Topic> getTopicByTopicName(@PathVariable String topicName) {
        return topicRepository.findByTopicName(topicName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "topicId/{topicId}")
    public Topic getTopicById(@PathVariable Long topicId) {
        return topicRepository.findOne(topicId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addTopic(@RequestBody Topic topic) {
        if (topicRepository.save(new Topic(topic.getTopicName(), topic.getQuestionCount())) != null) {
            return Util.createResponseEntity("Successful creation of a resource", HttpStatus.CREATED);
        }
        return Util.createResponseEntity("Error creating resource", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "topicId/{topicId}")
    public ResponseEntity<?> updateTopic(@RequestBody Topic topic, @PathVariable long topicId) {
        Topic newTopic = topicRepository.findOne(topicId);
        if (newTopic != null) {
            newTopic.setTopicName(topic.getTopicName());
            newTopic.setQuestionCount(topic.getQuestionCount());
            if (topicRepository.save(newTopic).getId().equals(topicId)) {
                return Util.createResponseEntity("Data updated successfully", HttpStatus.OK);
            }
        }
        return Util.createResponseEntity("Error updating data", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topicId/{topicId}")
    ResponseEntity<?> deleteTopic(@PathVariable long topicId) {
        try {
            topicRepository.delete(topicId);
            return Util.createResponseEntity("Data deleted successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return Util.createResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
        }
    }

}