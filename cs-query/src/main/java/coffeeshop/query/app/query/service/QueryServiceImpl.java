package coffeeshop.query.app.query.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import coffeeshop.query.app.domain.MenuItem;
import coffeeshop.query.app.repository.MenuItemRepository;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class QueryServiceImpl implements QueryService{

	Logger logger = LoggerFactory.getLogger(QueryServiceImpl.class);
	
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
	
	public  List<MenuItem> retrieveFallback() {
		List<MenuItem> item = new ArrayList<MenuItem>();
	     item.add(new MenuItem("default","default", "default", "default"));
	     return item;
	  }

	public String publishKafkaEventFallback() {
	     logger.info("kafka is down");
	     return "Kafka is down";
	     
	  }
	
}
