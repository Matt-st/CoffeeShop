package coffeeshop.query.app.query.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import coffeeshop.query.app.domain.MenuItem;
import coffeeshop.query.app.repository.MenuItemRepository;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class QueryServiceImpl implements QueryService {

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

	@HystrixCommand(fallbackMethod = "retrieveFallback", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public List<MenuItem> retrieveMenuItems() {
		List<MenuItem> l = retrieve();
		
		publishKafkaEvent();

		return l;
	}

	private void publishKafkaEvent() {
		logger.info("Sending event data to kafka topic.");
		kafkaTemplate.send(topicName, "Retrieve menu items!");
	}

	private List<MenuItem> retrieve() {
		logger.info("Retrieveing data from cassandra table.");
		
		return (List<MenuItem>) repo.findAll();
	}

	public List<MenuItem> retrieveFallback() {
		List<MenuItem> item = new ArrayList<MenuItem>();
		item.add(new MenuItem("default", "default", "default", "default"));
		return item;

	}

}
