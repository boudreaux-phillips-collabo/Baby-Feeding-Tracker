package com.tracker.feeding.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tracker.feeding.dto.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(final Object object, final ConstraintValidatorContext context) {
        final UserDto user = (UserDto) object;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}