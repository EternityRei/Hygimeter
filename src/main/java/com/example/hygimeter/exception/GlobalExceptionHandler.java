package com.example.hygimeter.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<EntityNotFoundException> notFoundException(BaseException ex){
        log.error("The error occur with message = {}", ex.getMessage());
        return new ResponseEntity<>(new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND.name(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
