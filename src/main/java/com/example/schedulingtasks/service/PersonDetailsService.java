package com.example.schedulingtasks.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.schedulingtasks.models.PersonDetails;
import com.example.schedulingtasks.repository.PersonDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService {

    @Autowired
	private PersonDetailsRepository repository;

	public PersonDetails save(PersonDetails person) {
		person.setNextCheck(LocalDateTime.now().plus(1000, ChronoUnit.MILLIS));
		return repository.save(person);
	}

	public List<PersonDetails> getAll() {
		return repository.findAll();
	}
       
}