package coffeeshop.app.query.domain;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Table("items")
@ApiModel(description = "This model represents the menu item object with a name, description, and category.  The id is a unique id to represent each item.")
public class MenuItem {
	@ApiModelProperty(value = "Name of the menu item like bannana or apple.")
	public String name;
	@ApiModelProperty(value = "Description provides information about item.")
	public String description;
	
	@PrimaryKey
    @CassandraType(type = DataType.Name.TEXT)
	@ApiModelProperty(value = "Unique identifier used to identify", allowableValues = "available,pending,sold")
	private String id;
	@ApiModelProperty(value = "Category is a value to represent where on the menu the items belong.", allowableValues = "Breakfast, Brunch, Lunch, Dinner")
	private String category;
	
	public MenuItem(String name, String description, String category, String id){
		this.name = name;
		this.description = description;
		this.category = category;
		this.id = id;
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
	
}
