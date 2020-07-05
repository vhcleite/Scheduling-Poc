package com.example.schedulingtasks.controller;

import java.util.List;

import com.example.schedulingtasks.models.PersonDetails;
import com.example.schedulingtasks.service.PersonDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persondetails")
public class PersonDetailsController {
    @Autowired
	private PersonDetailsService service;
	
	@PostMapping
	public PersonDetails post(@RequestBody PersonDetails details) {
		return service.save(details);
	}
	
	@GetMapping
	public List<PersonDetails> getAll() {
		return service.getAll();
	}
}