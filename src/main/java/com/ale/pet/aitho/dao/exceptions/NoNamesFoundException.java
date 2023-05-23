package com.ale.pet.aitho.dao.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class NoNamesFoundException extends RuntimeException{

    public NoNamesFoundException(String errorMessage) {
        super(errorMessage);
    }
}
