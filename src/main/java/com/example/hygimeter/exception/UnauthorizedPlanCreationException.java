package com.example.hygimeter.exception;

import static com.example.hygimeter.exception.StatusCodes.FORBIDDEN;

public class UnauthorizedPlanCreationException extends BaseException {
    public UnauthorizedPlanCreationException(String message) {
        super(FORBIDDEN.name(), message);
    }
}