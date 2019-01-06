package coffeeshop.app.command;

import java.util.UUID;

import coffeeshop.app.command.domain.MenuItem;

public interface CommandService {
	
	public void updateMenuItem(MenuItem item);
	
	public void deleteMenuItem(String id);
	
	public void createMenuItem(MenuItem item);

}
