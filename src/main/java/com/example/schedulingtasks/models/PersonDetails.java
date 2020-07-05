package com.example.schedulingtasks.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PersonDetails {
    
    @Id
    private Integer id;

    String street;

    private LocalDateTime nextCheck;

    @OneToOne(mappedBy = "details", cascade = CascadeType.DETACH,
              fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Person person;

    public PersonDetails() {
		
	}

    public PersonDetails(Integer id, String street, LocalDateTime nextCheck) {
        this.id = id;
        this.street = street;
        this.nextCheck = nextCheck;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public LocalDateTime getNextCheck() {
        return nextCheck;
    }

    public void setNextCheck(LocalDateTime nextCheck) {
        this.nextCheck = nextCheck;
    }

    

    
}