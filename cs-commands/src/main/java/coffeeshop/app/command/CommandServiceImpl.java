package coffeeshop.app.command;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import coffeeshop.app.command.domain.MenuItem;
import coffeeshop.app.repository.MenuItemRepository;

@Service
public class CommandServiceImpl implements CommandService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private MenuItemRepository repo;
	
	@Value(value = "${message.topic.name}")
    private String topicName;
	 
	public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
	
	public void updateMenuItem(MenuItem item) {
		// TODO Auto-generated method stub
		sendMessage("Update menu item.");
		repo.save(item);
		
	}

	public void deleteMenuItem(UUID id) {
		// TODO Auto-generated method stub
		sendMessage("Delete menu item.");
		repo.deleteById(id);
	}

	public void createMenuItem(MenuItem item) {
		// TODO Auto-generated method stub
		sendMessage("Create menu item.");
		repo.save(item);
	}

}
