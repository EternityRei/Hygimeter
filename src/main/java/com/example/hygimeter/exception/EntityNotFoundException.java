package com.example.hygimeter.exception;

public class EntityNotFoundException extends BaseException{
    public EntityNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
