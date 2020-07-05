package com.example.schedulingtasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")Integer id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
