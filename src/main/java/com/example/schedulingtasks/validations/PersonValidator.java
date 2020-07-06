package com.example.schedulingtasks.validations;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.schedulingtasks.models.Person;
import com.example.schedulingtasks.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonValidator implements ConstraintValidator<UniquePersonNameConstraint, String> {

    private PersonRepository repo;

    public PersonValidator(PersonRepository repo) {
        this.repo = repo;
    }

    @Override
    public void initialize(UniquePersonNameConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String personName, ConstraintValidatorContext context) {
        List<Person> people = repo.findByName(personName);
        return people.isEmpty();
    }



}
