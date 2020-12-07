package com.tracker.feeding.util.errors;

public final class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

}