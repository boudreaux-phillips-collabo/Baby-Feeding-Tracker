package com.tracker.feeding.validation;

import com.tracker.feeding.dto.UserDto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean support(final Class<?> supportClass) {
        return UserDto.class.isAssignableFrom(supportClass);
    }

    @Override
    public void validate(final Object object, final Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","message.firstName","First name is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","message.lastName","Last name is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","message.password","Password is required.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","message.username","Username is required.");
    }
}