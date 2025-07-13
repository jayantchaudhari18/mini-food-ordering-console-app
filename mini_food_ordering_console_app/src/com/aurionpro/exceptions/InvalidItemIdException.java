package com.aurionpro.exceptions;

public class InvalidItemIdException extends RuntimeException {
    public InvalidItemIdException(String message) {
        super(message);
    }
}
