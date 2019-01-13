package coffeeshop.app.command.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;


@Table("items")
public class MenuItem {
	
	@PrimaryKey
    @CassandraType(type = DataType.Name.TEXT)
	@ApiModelProperty(value = "Unique identifier used to identify")
	public String id;
	
	@ApiModelProperty(value = "Name of the menu item like bannana or apple.")
	public String name;
	
	@ApiModelProperty(value = "Description provides information about item.")
	public String description;
	
	@ApiModelProperty(value = "Category is a value to represent where on the menu the items belong.", allowableValues = "Breakfast, Brunch, Lunch, Dinner")
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

