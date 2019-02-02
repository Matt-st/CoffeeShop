package coffeeshop.app.webapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import coffeeshop.app.webapplication.domain.MenuItem;
import coffeeshop.app.webapplication.service.MenuService;



@Controller
public class WebApplicationController {
	
	private Logger logger = LoggerFactory.getLogger(WebApplicationController.class);

	@Autowired
	MenuService menuService;
	
	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greetings";
	}
	
	@GetMapping("/menu")
	public String menu(Model model) {
		logger.info("Root mapping controller.");
		List<MenuItem> items = menuService.getMenuItems();
		
		model.addAttribute("items", items);
		return "menu";
	}
}
