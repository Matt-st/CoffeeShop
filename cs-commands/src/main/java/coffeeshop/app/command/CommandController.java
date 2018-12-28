package coffeeshop.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

	private final CommandService commandService;

	@Autowired
	public CommandController(CommandService commandService){
		this.commandService = commandService;
	}

	@PostMapping("/menu")
	public void createMenuItem() {	
		commandService.createMenuItem();;
	}
	
	@PutMapping("/menu/{id}")
	public void updateMenuItem() {	
		commandService.updateMenuItem();;
	}
	
	@DeleteMapping("/menu/{id}")
	public void deleteMenuItem() {	
		commandService.deleteMenuItem();;
	}
	
	
}
