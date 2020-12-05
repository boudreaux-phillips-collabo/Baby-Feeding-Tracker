package com.tracker.feeding.util.errors;

public final class UserAlreadyExistsException extends RuntimeException {

    public static final long serialVersionUID = 5861310537366287163L;//research more

    public UserAlreadyExistsException() {
        super();
    }

    public UserAlreadyExistsException(final String message) {
        super(message);
    }

    public UserAlreadyExistsException(final Throwable cause) {
        super(cause);
    }

    public UserAlreadyExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
