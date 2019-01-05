package coffeeshop.app.query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import coffeeshop.app.query.domain.MenuItem;


@Service
public class QueryServiceImpl implements QueryService{

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value(value = "${message.topic.name}")
    private String topicName;
	 
	public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
	
	public List<MenuItem> retrieveMenuItems() {
		List<MenuItem> l = new ArrayList<MenuItem>();
		l.add(new MenuItem("Bread", "Loaves of bread.", "Breakfast", UUID.randomUUID()));
		l.add(new MenuItem("sandwich", "BLT", "Lunch", UUID.randomUUID()));
		l.add(new MenuItem("soup", "tomato soup", "Dinner", UUID.randomUUID()));
		
		kafkaTemplate.send(topicName, "Retrieve menu items!");
		
		
		return l;
	}

}
