package com.dtr.oas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="strategy")
public class Strategy {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String type;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getString() {
		return String.format("Strategy - Id: [%s]  Type: [%s]  Name: [%s]", this.id, this.type, this.name);
	}
}
