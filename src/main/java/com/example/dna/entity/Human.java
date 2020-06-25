package com.example.dna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="humans")
public class Human {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mutation")
	private boolean mutation;
	
	
	@Column(name = "created_on")
	private String createdOn;
	
	public Human() {
		super();
	}

	public Human(String name, boolean mutation, String createdOn) {
		super();
		this.name = name;
		this.mutation = mutation;
		this.createdOn = createdOn;
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

	public boolean isMutation() {
		return mutation;
	}

	public void setMutation(boolean mutation) {
		this.mutation = mutation;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


}
