package com.example.schedulingtasks.repository;

import java.util.List;

import javax.persistence.LockModeType;

import com.example.schedulingtasks.models.PersonDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface PersonDetailsRepository extends JpaRepository<PersonDetails, Integer>{

	@Override
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public List<PersonDetails> findAll();
}
