package com.example.demo.exception;

public class NotEnoughProductException extends RuntimeException {
    public NotEnoughProductException(Long inStock, Long amount) {
        super("There are only " + inStock + " products, requested " + amount);
    }
}
