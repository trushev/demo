package com.example.demo.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Could not find entity by id: " + id);
    }
}
