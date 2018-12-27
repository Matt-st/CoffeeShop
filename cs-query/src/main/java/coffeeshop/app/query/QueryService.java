package coffeeshop.app.query;

import java.util.List;

import coffeeshop.app.query.objects.MenuItem;

public interface QueryService {
	public List<MenuItem> retrieveMenuItems();

}
