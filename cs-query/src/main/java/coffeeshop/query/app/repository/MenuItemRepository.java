package coffeeshop.query.app.repository;

import org.springframework.data.repository.CrudRepository;

import coffeeshop.query.app.domain.MenuItem;



public interface MenuItemRepository extends CrudRepository<MenuItem, String>{

}

