package coffeeshop.query.app.query.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coffeeshop.query.app.domain.MenuItem;
import coffeeshop.query.app.repository.MenuItemRepository;

@Service
public class QueryServiceImpl implements QueryService {

	Logger logger = LoggerFactory.getLogger(QueryServiceImpl.class);

	@Autowired
	private MenuItemRepository repo;

	public List<MenuItem> retrieveMenuItems() {
		logger.info("Retrieveing items.");
		return (List<MenuItem>) repo.findAll();
	}
	
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
