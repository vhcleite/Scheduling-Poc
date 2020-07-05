package com.example.schedulingtasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.Thread.State;
import java.util.List;

import com.example.schedulingtasks.models.Person;
import com.example.schedulingtasks.service.PersonService;

@Component
public class ScheduledTasks {
	
	@Autowired PersonService service;
	
	@Scheduled(fixedDelay = 2000)
	// @Async
	public void reportCurrentTime() {
		long startTime = System.currentTimeMillis();
		List<Person> people2 = service.getPeopleOldWay();
		System.out.println("Execution time: " + (System.currentTimeMillis() - startTime));
	}




}
