package com.example.demo.constraint.validator;

import com.example.demo.constraint.DataTypeConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class DataTypeConstraintValidator implements ConstraintValidator<DataTypeConstraint, Object> {
	private Class<?> dataType;

	@Override
	public void initialize(DataTypeConstraint constraint) {
		this.dataType = constraint.value();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		if (null == object) {
			return true;
		}
		if (!dataType.isInstance(object)) {
			context.disableDefaultConstraintViolation();
			constraintViolationBuilder(context, object);
			return false;
		}
		return true;
	}

	private void constraintViolationBuilder(ConstraintValidatorContext context, Object object) {
		String[] split = StringUtils.split(object.getClass().getName(), ".");
		String dataTypeName = split[split.length - 1];
		context.buildConstraintViolationWithTemplate(String.format("Invalid Type '$s'.", dataTypeName)).addConstraintViolation();
	}
}
