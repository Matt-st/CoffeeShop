package coffeeshop.app.command;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coffeeshop.app.command.domain.MenuItem;

@RestController
public class CommandController {

	private final CommandService commandService;

	@Autowired
	public CommandController(CommandService commandService){
		this.commandService = commandService;
	}

	@PostMapping("/menu")
	public void createMenuItem(@RequestBody MenuItem item) {
		item.setId(UUID.randomUUID().toString()	);
		commandService.createMenuItem(item);
	}
	
	@PutMapping("/menu/{id}")
	public void updateMenuItem(@RequestBody MenuItem item) {	
		commandService.updateMenuItem(item);
	}
	
	@DeleteMapping("/menu/{id}")
	public void deleteMenuItem(@PathVariable("id") String id) {	
		commandService.deleteMenuItem(id);
	}
	
	
}
