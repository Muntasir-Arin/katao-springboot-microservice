package com.katao.salon_service.exception;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class SalonNotFoundException extends RuntimeException {
    public SalonNotFoundException(String message) {
        super(message);
    }
}