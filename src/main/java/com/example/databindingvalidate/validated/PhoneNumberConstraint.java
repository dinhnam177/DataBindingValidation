package com.example.databindingvalidate.validated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberConstraint {
    String message() default "Phone number must be between 8 - 11 numbers";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
