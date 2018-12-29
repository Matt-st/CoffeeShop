package coffeeshop.app.query.domain;

public class MenuItem {
	
	public String name;
	
	public String description;
	
	private Long id;
	
	public MenuItem(String name, String description){
		this.name = name;
		this.description = description;
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
