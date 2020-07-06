package com.example.schedulingtasks.models.dto;

import javax.validation.constraints.NotBlank;

import com.example.schedulingtasks.validations.UniquePersonNameConstraint;

import org.hibernate.validator.constraints.Length;

public class PersonPostDto {

    @NotBlank(message = "O nome da pessoa nao deve estar vazio")
	@Length(min = 3, message = "O campo nome deve ter no mínimo 3 caracteres.")
	@UniquePersonNameConstraint
    String name;

    public PersonPostDto() {
    }

    public PersonPostDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}