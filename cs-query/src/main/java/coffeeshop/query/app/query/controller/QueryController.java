package coffeeshop.query.app.query.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coffeeshop.query.app.domain.MenuItem;
import coffeeshop.query.app.query.service.QueryService;

@RestController
public class QueryController {
	
	private final QueryService queryService;
	
	private Logger logger = LoggerFactory.getLogger(QueryController.class);
	 

	@Autowired
	public QueryController(QueryService queryService){
		this.queryService = queryService;
	}

	
	@GetMapping(path = "/menu", produces = "application/json")
	public List<MenuItem> retrieveMenuItems() {	
		logger.info("Retrieving Menu Items...");
		return queryService.retrieveMenuItems();
	}
	
	@PostMapping(path = "/menu", produces = "application/json")
	public void createMenuItem(@RequestBody MenuItem item) {
		item.setId(UUID.randomUUID().toString()	);
		queryService.createMenuItem(item);
	}
	
	@PutMapping(path = "/menu/{id}", produces = "application/json")
	public void updateMenuItem(@RequestBody MenuItem item) {	
		queryService.updateMenuItem(item);
	}
	
	@DeleteMapping(path = "/menu/{id}", produces = "application/json")
	public void deleteMenuItem(@PathVariable("id") String id) {	
		queryService.deleteMenuItem(id);
	}
	
}
