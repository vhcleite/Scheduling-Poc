package com.example.schedulingtasks.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schedulingtasks.models.Person;
import com.example.schedulingtasks.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public Person save(Person person) {
		return repository.save(person);
	}

	public List<Person> getAll() {
		return (List<Person>) repository.findAll();
	}

	public void saveAll(List<Person> people) {
		repository.saveAll(people);
		
	}
	
	@Transactional
	public List<Person> getPeople(int timeout, String name) {
		List<Person> people = getAll();
		people = people.stream().filter(p -> p.getLastCheck() == null || p.getLastCheck().isAfter(LocalDateTime.now().minus(5000, ChronoUnit.MILLIS))).collect(Collectors.toList());
		people.forEach(p -> p.setLastCheck(LocalDateTime.now()));
		saveAll(people);
		System.out.println(name + " lock off");
		return people;
	}

}
