package com.luv2code.springsecurity.demo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.TYPE,
	ElementType.FIELD,
	ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidEmail {
	String message() default "Invalid email";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
