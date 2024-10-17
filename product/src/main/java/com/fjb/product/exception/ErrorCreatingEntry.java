package com.fjb.product.exception;

import com.fjb.product.utils.MessagesUtils;

public class ErrorCreatingEntry extends RuntimeException {
    private final String message;

    public ErrorCreatingEntry(String errorCode, Object... var2) {
        this.message = MessagesUtils.getMessage(errorCode, var2);
    }

    @Override
    public String getMessage() {
        return message;
    }
}