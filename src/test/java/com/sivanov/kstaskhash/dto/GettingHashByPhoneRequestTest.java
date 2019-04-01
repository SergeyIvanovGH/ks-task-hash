package com.sivanov.kstaskhash.dto;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class GettingHashByPhoneRequestTest {

    @Test
    public void regexpPhone() {
        GettingHashByPhoneRequest request = new GettingHashByPhoneRequest();
        request.setPhone("0675204125");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<GettingHashByPhoneRequest>> constraintViolations = validator.validate(request);

        //Show errors
        if (constraintViolations.size() > 0) {
            System.out.println("Errors:");
            for (ConstraintViolation<GettingHashByPhoneRequest> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }
}