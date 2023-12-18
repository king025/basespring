package com.example.demo.constraint;

import com.example.demo.constraint.validator.DataTypeConstraintValidator;
import com.example.demo.constraint.validator.SampValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DataTypeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataTypeConstraint {
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	Class<?> value() default String.class;
}
