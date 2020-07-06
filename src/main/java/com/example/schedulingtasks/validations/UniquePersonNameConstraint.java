package com.example.schedulingtasks.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PersonValidator.class)
@Target( { ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePersonNameConstraint {
    String message() default "Usuário já existe.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}