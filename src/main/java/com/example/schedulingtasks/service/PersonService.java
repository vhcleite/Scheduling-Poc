package com.example.schedulingtasks.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schedulingtasks.models.Person;
import com.example.schedulingtasks.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private EntityManagerFactory emf;

	private static final Integer TIMEOUT = 5000;

	@Transactional
	public List<Person> getPeople() {
		LocalDateTime now = LocalDateTime.now();
		List<Person> people = repository.findTop2ByNextCheckBeforeOrderByNextCheckAsc(now);
		System.out.println(people);
		people.forEach(p -> p.setNextCheck(now.plus(TIMEOUT, ChronoUnit.MILLIS)));
		repository.saveAll(people);

		return people;
	}

	public List<Person> getPeopleOldWay() {
		LocalDateTime now = LocalDateTime.now();

		// EntityManagerFactory emf = Persistence.createEntityManagerFactory("Person");
		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.lock.timeout", 3000);
		EntityManager em = emf.createEntityManager(properties);
		em.getTransaction().begin();

		TypedQuery<Person> query = em.createQuery("select p from Person p where p.nextCheck < :now ORDER BY p.nextCheck ASC", Person.class)//
				.setParameter("now", now)//
				.setMaxResults(2)//
				.setLockMode(LockModeType.PESSIMISTIC_WRITE)
				.setHint("javax.persistence.query.timeout", 5000)
				.setHint("javax.persistence.lock.timeout", 3000);
		List<Person> people = query.getResultList();
		people.forEach(p -> p.setNextCheck(now.plus(TIMEOUT, ChronoUnit.MILLIS)));
		System.out.println(people);

		em.getTransaction().commit();
		em.close();
		return people;
	}

	public Person save(Person person) {
		person.setNextCheck(LocalDateTime.now().plus(1000, ChronoUnit.MILLIS));
		return repository.save(person);
	}

	public List<Person> getAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
