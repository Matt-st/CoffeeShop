package coffeeshop.app.command.domain;

public class MenuItem {
	
	public Long id;
	
	public String name;
	
	public String description;
	
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

