package coffeeshop.app.webapplication.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import coffeeshop.app.webapplication.domain.MenuItem;

@FeignClient("menu")
public interface MenuService {
	
	 @RequestMapping(method = RequestMethod.GET, value = "/menu")
	 List<MenuItem> getMenuItems();

}
