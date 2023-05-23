package com.ale.pet.aitho.api;

import com.ale.pet.aitho.dao.exceptions.InvalidRequestException;
import com.ale.pet.aitho.dao.exceptions.NoNamesFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler  {
    @ExceptionHandler(value = InvalidRequestException.class)
    ResponseEntity<Object> handleRichiestaInvalida(RuntimeException ex, WebRequest request){
        String responseBody = "Input non valido";
        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    };
    @ExceptionHandler(value = NoNamesFoundException.class)
    ResponseEntity<Object> handleNoName(RuntimeException ex, WebRequest request){
        String responseBody = "Nessun nome";
        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    };
}
