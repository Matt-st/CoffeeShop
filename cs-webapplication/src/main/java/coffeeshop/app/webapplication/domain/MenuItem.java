package coffeeshop.app.webapplication.domain;

import java.util.UUID;

public class MenuItem {
	
	public String id;
	
	public String name;
	
	public String description;
	
	private String category;
	
	public MenuItem(){	}
	
	public MenuItem(String name, String description, String category, String id){
		this.name = name;
		this.description = description;
		if(id == null){
			this.id = UUID.randomUUID().toString();			
		}
		else{
			this.id = id;
		}
		this.category = category;
	}

	public String getId() {
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

	public void setId(String id) {
		this.id = id;
		
	}
	
}
