package com.sivanov.kstaskhash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.security.NoSuchAlgorithmException;

@RestControllerAdvice
public class HashExceptionHandler {

//    private final static String INTERNAL_SERVER_ERROR_MESSAGE = "internal error";
    private final static String BAD_REQUEST_MESSAGE = "Error in request data";
    private final static String NO_SUCH_ALGORITHM_MESSAGE = "Error in algorithm";

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity<String> handleMethodArgumentNotValidException(WebRequest request) {
        return new ResponseEntity<>(BAD_REQUEST_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NoSuchAlgorithmException.class})
    public ResponseEntity<String> handleNoSuchAlgorithmException(WebRequest request) {
        return new ResponseEntity<>(NO_SUCH_ALGORITHM_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {HashException.class})
    public ResponseEntity<String> handleHashException(WebRequest request, Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleException(WebRequest request) {
        return new ResponseEntity<>(NO_SUCH_ALGORITHM_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
