package com.tracker.feeding.util.errors;

import org.springframework.security.core.AuthenticationException;

public class UnusualLocationException extends AuthenticationException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UnusualLocationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnusualLocationException(final String message) {
        super(message);
    }

}
