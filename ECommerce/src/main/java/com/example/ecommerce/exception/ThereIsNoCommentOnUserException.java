package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ThereIsNoCommentOnUserException extends RuntimeException {
    public ThereIsNoCommentOnUserException(String message) {
        super(message);
    }
}
