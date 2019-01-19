package coffeeshop.app.query;

import java.util.List;

import coffeeshop.app.query.domain.MenuItem;

public interface QueryService {
	public List<MenuItem> retrieveMenuItems();

}
