package coffeeshop.app.repository;



import org.springframework.data.repository.CrudRepository;

import coffeeshop.app.command.domain.MenuItem;

public interface MenuItemRepository  extends CrudRepository<MenuItem, String>{

}
