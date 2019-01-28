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
	private MenuItemRepository repo;

	public void updateMenuItem(MenuItem item) {

		logger.info("Updating menu items");
		repo.save(item);
	}

	public void deleteMenuItem(String id) {

		logger.info("Deleteing menu items");
		repo.deleteById(id);
	}

	public void createMenuItem(MenuItem item) {

		logger.info("Creating menu items");
		repo.save(item);
	}

}
