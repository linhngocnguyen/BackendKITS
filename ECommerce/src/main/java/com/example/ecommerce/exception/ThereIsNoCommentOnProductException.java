package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ThereIsNoCommentOnProductException extends RuntimeException {
    public ThereIsNoCommentOnProductException(String message) {
        super(message);
    }
}
