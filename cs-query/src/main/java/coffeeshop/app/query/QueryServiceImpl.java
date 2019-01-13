package coffeeshop.app.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import coffeeshop.app.query.domain.MenuItem;
import coffeeshop.app.repository.MenuItemRepository;


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
		List<MenuItem> l = (List<MenuItem>) repo.findAll();
		
		//kafkaTemplate.send(topicName, "Retrieve menu items!");
		
		
		return l;
	}

}
