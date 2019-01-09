package coffeeshop.app.command;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
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
@Api(value="commandMenuItems", description="Operations pertaining to menu items for the Coffeeshop.")
public class CommandController {

	private final CommandService commandService;

	@Autowired
	public CommandController(CommandService commandService){
		this.commandService = commandService;
	}

	@PostMapping("/menu")
	@ApiOperation(value = "Add a menu item",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added a menu item"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	public void createMenuItem(@RequestBody MenuItem item) {
		item.setId(UUID.randomUUID().toString()	);
		commandService.createMenuItem(item);
	}
	
	@PutMapping("/menu/{id}")
	@ApiOperation(value = "Update a menu item",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated a menu item"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	public void updateMenuItem(@RequestBody MenuItem item) {	
		commandService.updateMenuItem(item);
	}
	
	@DeleteMapping("/menu/{id}")
	@ApiOperation(value = "View a list of menu items",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a menu item"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	public void deleteMenuItem(@PathVariable("id") String id) {	
		commandService.deleteMenuItem(id);
	}
	
	
}
