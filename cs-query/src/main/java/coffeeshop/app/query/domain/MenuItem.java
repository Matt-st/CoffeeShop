package coffeeshop.app.query.domain;

import java.util.UUID;

public class MenuItem {
	
	public String name;
	
	public String description;
	
	private UUID id;
	
	private String category;
	

	
	public MenuItem(String name, String description, String category, UUID id){
		this.name = name;
		this.description = description;
		this.category = category;
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
