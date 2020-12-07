package com.tracker.feeding.security.location;

import com.tracker.feeding.models.NewLocationToken;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@SuppressWarnings("serial")
public class DifferentLocationLoginHandler extends ApplicationEvent {

    private final Locale local;
    private final String username;
    private final String ip;
    private final NewLocationToken token;
    private final String appUrl;

    public DifferentLocationLoginHandler(Locale local, String username, String ip, NewLocationToken token, String appUrl) {
        this.local = local;
        this.username = username;
        this.ip = ip;
        this.token = token;
        this.appUrl = appUrl;
    }


    public Locale getLocal() {
        return local;
    }

    public String getUsername() {
        return username;
    }

    public String getIp() {
        return ip;
    }

    public NewLocationToken getToken() {
        return token;
    }

    public String getAppUrl() {
        return appUrl;
    }
}