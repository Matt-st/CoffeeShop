package coffeeshop.app.query;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeeshop.app.query.domain.MenuItem;

@RestController
@Api(value="retrieveMenuItems", description="Operations pertaining to menu items for the Coffeeshop.")
public class QueryController {
	
	private final QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService){
		this.queryService = queryService;
	}

	@ApiOperation(value = "View a list of menu items",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	
	@GetMapping(path = "/menu", produces = "application/json")
	public List<MenuItem> retrieveMenuItems() {	
		return queryService.retrieveMenuItems();
	}
	
}
