package coffeeshop.app.command.domain;

import java.util.Date;

public class Event {

	private String id;
	private String operation = "";
	private String description = "";
	private Date date;
	private String operatorId = "";

	 public Event(String id) {
	        this.id = id;
	    }
	
	public Event(String id, String operation, String description, Date date,
			String operatorId) {
		this.id = id;
		this.operation = operation;
		this.description = description;
		this.date = date;
		this.operatorId = operatorId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

}
