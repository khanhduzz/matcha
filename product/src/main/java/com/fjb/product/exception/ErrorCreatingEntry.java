package com.fjb.product.exception;

public class ErrorCreatingEntry extends RuntimeException {
    public ErrorCreatingEntry(String message) {
        super(message);
    }
}