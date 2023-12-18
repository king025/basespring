package com.example.demo.constraint.validator;

import com.example.demo.constraint.SampConstraint;
import com.example.demo.dto.api.SampRequest;
import com.example.demo.exception.BasicException;
import com.example.demo.exception.SampException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;

public class SampValidator implements ConstraintValidator<SampConstraint, SampRequest> {

	@Override
	public boolean isValid(SampRequest sampRequest, ConstraintValidatorContext constraintValidatorContext) {
		if (ObjectUtils.allNull(sampRequest.countryIso())) {
			throw new BasicException("not valid");
		}
		return true;
	}
}
