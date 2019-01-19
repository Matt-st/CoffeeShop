package coffeeshop.app.repository;

import org.springframework.data.repository.CrudRepository;

import coffeeshop.app.query.domain.MenuItem;



public interface MenuItemRepository extends CrudRepository<MenuItem, String>{

}

