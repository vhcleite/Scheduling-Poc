package com.example.schedulingtasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schedulingtasks.models.Person;
import com.example.schedulingtasks.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping
	public Person post(@RequestBody Person person) {
		return service.save(person);
	}
	
	@GetMapping
	public List<Person> getAll() {
		return service.getAll();
	}
}
