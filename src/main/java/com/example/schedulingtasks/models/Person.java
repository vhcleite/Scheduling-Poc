package com.example.schedulingtasks.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private LocalDateTime lastCheck;
	
	public Person() {
		
	}
	
	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getLastCheck() {
		return lastCheck;
	}

	public void setLastCheck(LocalDateTime lastCheck) {
		this.lastCheck = lastCheck;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastCheck=" + lastCheck + "]";
	}
}
