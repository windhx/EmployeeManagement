package com.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId")
	private int id;

	@Column(name = "name", length = 45)
	private String name;

	@Column(name = "email", length = 45)
	private String email;

	@Column(name = "designation", length = 45)
	private String designation;


	public Employee(int id, String name, String email, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.designation = designation;
	}

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


}
