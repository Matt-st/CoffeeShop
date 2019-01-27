package coffeeshop.app.command.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import coffeeshop.app.command.domain.MenuItem;
import coffeeshop.app.repository.MenuItemRepository;

@Service
public class CommandServiceImpl implements CommandService {

	Logger logger = LoggerFactory.getLogger(CommandServiceImpl.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private MenuItemRepository repo;

	@Value(value = "${message.topic.name}")
	private String topicName;
	
	@HystrixCommand(fallbackMethod = "kafkaPublishFallback", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public void sendMessage(String msg) {
		logger.info("Publishing kafka event.");
		kafkaTemplate.send(topicName, msg);
	}

	@HystrixCommand(fallbackMethod = "itemFallback", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") })
	public void updateMenuItem(MenuItem item) {
		sendMessage("Update menu item.");
		logger.info("Updating menu items");
		repo.save(item);
	}

	@HystrixCommand(fallbackMethod = "itemFallback", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") })
	public void deleteMenuItem(String id) {
		sendMessage("Delete menu item.");
		logger.info("Deleteing menu items");
		repo.deleteById(id);
	}

	@HystrixCommand(fallbackMethod = "itemFallback", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") })
	public void createMenuItem(MenuItem item) {
		sendMessage("Create menu item.");
		logger.info("Creating menu items");
		repo.save(item);
	}
	
	public void itemFallback(MenuItem item){
		logger.info("Item failed.");
	}
	
	public void itemFallback(String item){
		logger.info("Item failed.");
	}
	
	public void kafkaPublishFallback(String msg){
		logger.info("publishing event to kafka failed." + msg);
	}
	
	

}
