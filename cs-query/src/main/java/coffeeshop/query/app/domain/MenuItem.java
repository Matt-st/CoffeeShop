package coffeeshop.query.app.domain;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("MenuItem")
public class MenuItem implements Serializable {

	private static final long serialVersionUID = 1L;

	public String name;

	public String description;

	private String id;

	private String category;

	public MenuItem() {
	}

	public MenuItem(String name, String description, String category, String id) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
