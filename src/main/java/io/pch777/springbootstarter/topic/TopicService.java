package io.pch777.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("java","Core Java","Core Java Description"),
			new Topic("javascript","JavaScript","JavaScript Description"),
			new Topic("hibernate","Hibernate JPA","Hibernate Description")
			));
	
	public List<Topic> getAllTopics(){		
		return topics;
	}
	
	public Topic getTopic(String topicId) {
        return topics.stream().filter(t -> t.getTopicId().equals(topicId)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(String topicId, Topic topic) {
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i); 
			if(t.getTopicId().equals(topicId)) {
				topics.set(i, topic);
				return;
			}		
		}		
	}

	public void deleteTopic(String topicId) {
		topics.removeIf(t -> t.getTopicId().equals(topicId));
	}
}
