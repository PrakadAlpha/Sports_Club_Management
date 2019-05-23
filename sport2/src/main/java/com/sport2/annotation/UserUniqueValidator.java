package com.sport2.annotation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport2.dao.UserDaoI;

public class UserUniqueValidator implements ConstraintValidator<Unique,Date>{

	  @Autowired
	    private UserDaoI repo;
	
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		if (repo == null) {
            return true;
        }
        return repo.findByDate(value) == null;
    }	
	
}

