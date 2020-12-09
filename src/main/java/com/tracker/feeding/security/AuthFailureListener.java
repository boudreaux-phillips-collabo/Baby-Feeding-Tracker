package com.tracker.feeding.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoginAttempt loginAttempt;

    @Override
    public void onApplicationEvent(final AuthenticationFailureBadCredentialsEvent e) {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            loginAttempt.loginFailed(request.getRemoteAddr());
        } else {
            loginAttempt.loginFailed(xfHeader.split(",")[0]);
        }
    }
}