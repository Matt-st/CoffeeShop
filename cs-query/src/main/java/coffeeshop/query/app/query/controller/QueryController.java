package coffeeshop.query.app.query.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import coffeeshop.query.app.domain.MenuItem;
import coffeeshop.query.app.query.service.QueryService;

@RestController
@Api(value="retrieveMenuItems", description="Operations pertaining to menu items for the Coffeeshop.")
public class QueryController {
	
	private final QueryService queryService;
	
	private Logger logger = LoggerFactory.getLogger(QueryController.class);
	 

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
		logger.info("Retrieving Menu Items...");
		return queryService.retrieveMenuItems();
	}
	
}
