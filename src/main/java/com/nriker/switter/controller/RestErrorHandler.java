package com.nriker.switter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nriker.switter.model.SwitterLike;

@RestControllerAdvice
public class RestErrorHandler {
    

    public static class InvalidLikeException extends RuntimeException {
    }

    @ExceptionHandler(InvalidLikeException.class)
    public ResponseEntity<SwitterLike> handleInvalidLike(InvalidLikeException ex){
        return ResponseEntity.badRequest().build();
    }
}
