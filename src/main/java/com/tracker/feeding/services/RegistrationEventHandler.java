package com.tracker.feeding.services;


import com.tracker.feeding.models.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@SuppressWarnings("serial")
public class RegistrationEventHandler extends ApplicationEvent {

    private final User user;
    private final Locale locale;
    private final String appUrl;

    public RegistrationEventHandler(final User user, final Locale locale, final String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() { return locale; }

    public User getUser() {
        return user;
    }
}
