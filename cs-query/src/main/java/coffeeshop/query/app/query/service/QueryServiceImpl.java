package coffeeshop.query.app.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import coffeeshop.query.app.domain.MenuItem;
import coffeeshop.query.app.repository.MenuItemRepository;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@Service
public class QueryServiceImpl implements QueryService{

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private MenuItemRepository repo;
	
	@Value(value = "${message.topic.name}")
    private String topicName;
	 
	public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
	
	public List<MenuItem> retrieveMenuItems() {
		List<MenuItem> l = retrieve();
		
		
		publishKafkaEvent();
		
		return l;
	}
	
	
	@HystrixCommand(fallbackMethod = "publishKafkaEventFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
		})
	private void publishKafkaEvent() {
		kafkaTemplate.send(topicName, "Retrieve menu items!");
	}

	@HystrixCommand(fallbackMethod = "retrieveFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
		})
	private List<MenuItem> retrieve(){
		return (List<MenuItem>) repo.findAll();
	}
	
	public String retrieveFallback() {
	    return "Cloud Native Java (O'Reilly)";
	  }

}