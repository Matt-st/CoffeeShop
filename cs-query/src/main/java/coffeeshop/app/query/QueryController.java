package coffeeshop.app.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeeshop.app.query.objects.MenuItem;

@RestController
public class QueryController {
	
	private final QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService){
		this.queryService = queryService;
	}

	@GetMapping("/menu")
	public List<MenuItem> retrieveMenuItems() {	
		return queryService.retrieveMenuItems();
	}
	
}
