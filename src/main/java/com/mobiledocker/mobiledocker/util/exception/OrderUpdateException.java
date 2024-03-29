package com.mobiledocker.mobiledocker.util.exception;

public class OrderUpdateException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366163L;

    public OrderUpdateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public OrderUpdateException(final String message) {
        super(message);
    }

    public OrderUpdateException(final Throwable cause) {
        super(cause);
    }
}
