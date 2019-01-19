package coffeeshop.query.app.service;

import java.util.List;

import coffeeshop.query.app.domain.MenuItem;

public interface QueryService {
	public List<MenuItem> retrieveMenuItems();

}
