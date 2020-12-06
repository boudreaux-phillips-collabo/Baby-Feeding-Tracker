package com.tracker.feeding.services.validation;

@SuppressWarnings("serial")
public class EmailException extends Throwable {

    public EmailException(final String message) {
        super(message);
    }
}
