package coffeeshop.app.command.domain;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;


@Table("items")
public class MenuItem {
	
	@PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
	private String description;
	private String name;
	private String category;
	

	public UUID getId() {
		return id;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public MenuItem(String name, String description, String category){
		this.name = name;
		this.description = description;
		this.id = UUID.randomUUID();
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

