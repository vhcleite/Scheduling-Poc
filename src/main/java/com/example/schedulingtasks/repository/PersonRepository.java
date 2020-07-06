package com.example.schedulingtasks.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.schedulingtasks.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Override
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public List<Person> findAll();


	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public List<Person> findTop2ByNextCheckBeforeOrderByNextCheckAsc(LocalDateTime now);


	public boolean existsByNameContaining(String name);


	public List<Person> findByName(String personName);
	
}
