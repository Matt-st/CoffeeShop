package coffeeshop.app.command.domain;

import java.util.Date;

public class EventBuilder {

	private String id;
	private String operation = "";
	private String description = "";
	private Date date;
	private String operatorId = "";
	
	
	 public EventBuilder(String id, String operation, String description, Date date,
	            String operatorId) {
	        this.id = id;
	        this.operation = operation;
	        this.description = description;
	        this.date = date;
	        this.operatorId = operatorId;
	    }
	
	 public EventBuilder() {
		// TODO Auto-generated constructor stub
	}

	public EventBuilder setId(String id) {
			this.id = id;
			return this;
		}
	 
	public EventBuilder setOperation(String operation) {
		this.operation = operation;
		return this;
	}
	
	public EventBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public EventBuilder setDate(Date date) {
		this.date = new Date(date.getTime());
		return this;
	}
	
	public EventBuilder setOperatorId(String operatorId) {
		this.operatorId = operatorId;
		return this;
	}
	
	 public Event build() {
	        return new Event(id, operation, description, date, operatorId);
	    }
	
}
