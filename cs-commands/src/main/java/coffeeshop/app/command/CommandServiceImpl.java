package coffeeshop.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value(value = "${message.topic.name}")
    private String topicName;
	 
	public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
	
	public void updateMenuItem() {
		// TODO Auto-generated method stub
		sendMessage("Update menu item.");
	}

	public void deleteMenuItem() {
		// TODO Auto-generated method stub
		sendMessage("Delete menu item.");
	}

	public void createMenuItem() {
		// TODO Auto-generated method stub
		sendMessage("Create menu item.");
	}

}
