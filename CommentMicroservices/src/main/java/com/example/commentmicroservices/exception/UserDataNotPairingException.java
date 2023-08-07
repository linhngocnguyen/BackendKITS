package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDataNotPairingException extends RuntimeException {
    public UserDataNotPairingException(String message) {
        super(message);
    }
}
