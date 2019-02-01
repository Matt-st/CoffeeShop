package coffeeshop.app.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebApplicationController {

	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greetings";
	}
	
	@GetMapping("/")
	public String menu(Model model) {
		
		model.addAttribute("items", items);
		return "index";
	}
}
