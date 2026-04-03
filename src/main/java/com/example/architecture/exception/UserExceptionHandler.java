package com.example.architecture.exception;

import com.example.architecture.dto.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleUserException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
