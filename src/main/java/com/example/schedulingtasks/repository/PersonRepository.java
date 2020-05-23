package com.example.schedulingtasks.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import com.example.schedulingtasks.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Override
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public List<Person> findAll();
	
}
