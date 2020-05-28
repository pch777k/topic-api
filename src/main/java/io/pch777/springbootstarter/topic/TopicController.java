package io.pch777.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable String topicId) {
		return topicService.getTopic(topicId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);  
	}
	
	@PutMapping("/topics/{topicId}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String topicId ) {
		topicService.updateTopic(topicId, topic);  
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
	public void deleteTopic(@PathVariable String topicId) {
		topicService.deleteTopic(topicId);
	}
}
