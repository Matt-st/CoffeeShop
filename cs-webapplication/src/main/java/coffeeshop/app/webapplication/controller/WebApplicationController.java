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

	private Logger logger = LoggerFactory
			.getLogger(WebApplicationController.class);

	@Autowired
	MenuService menuService;

	@GetMapping("/menu")
	public String menu(Model model) {
		logger.info("Menu request sent to api gateway.");
		List<MenuItem> items = menuService.getMenuItems();
		
		items.forEach(t -> System.out.println(t.toString()));

		model.addAttribute("items", items);
		return "menu/index";
	}

	@GetMapping("/")
	public String root() {
		return "index";
	}

	@GetMapping("/user")
	public String userIndex() {
		return "user/index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/access-denied";
	}

}
