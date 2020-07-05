package com.example.schedulingtasks.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private LocalDateTime nextCheck;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private PersonDetails details;
	
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
	
	public LocalDateTime getNextCheck() {
		return nextCheck;
	}

	public void setNextCheck(LocalDateTime lastCheck) {
		this.nextCheck = lastCheck;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	
}
