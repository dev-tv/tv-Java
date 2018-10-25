package com.sample.validate;

import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sample.dto.http.response.DataResponse;
import com.sample.dto.http.response.RestResponse;
import com.sample.dto.http.response.StatusCode;

public class Validations {

	public RestResponse validate(Object requestDto, String[] array) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Object>> violations = null;

		violations = validator.validate(requestDto);

		for (ConstraintViolation<Object> violation : violations) {
			if (Arrays.asList(array).indexOf(violation.getPropertyPath().toString()) != -1) {
				if(violation.getMessage().toString() != null) {
					return new DataResponse(StatusCode.ID_CAN_NOT_NULL, violation.getMessage(), requestDto);
				}
			}
		}
		return null;
	}

}

