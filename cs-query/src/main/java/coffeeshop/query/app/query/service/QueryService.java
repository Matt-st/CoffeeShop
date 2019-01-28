package coffeeshop.query.app.query.service;

import java.util.List;

import coffeeshop.query.app.domain.MenuItem;

public interface QueryService {
	public List<MenuItem> retrieveMenuItems();

	public void updateMenuItem(MenuItem item);

	public void deleteMenuItem(String id);

	public void createMenuItem(MenuItem item);

}
