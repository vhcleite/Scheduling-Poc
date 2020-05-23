package com.example.schedulingtasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.schedulingtasks.service.PersonService;

@Component
public class ScheduledTasks {
	
	@Autowired PersonService service;
	
	@Scheduled(fixedRate = 1000)
	@Async
	public void reportCurrentTime() {
		System.out.println("start task 0");
		service.getPeople(0, "task 0");
		System.out.println("end task 0");
	}


	

}
