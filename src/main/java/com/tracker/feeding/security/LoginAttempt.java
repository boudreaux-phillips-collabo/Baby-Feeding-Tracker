package com.tracker.feeding.security;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class LoginAttempt {

    private final int MAX_ATTEMPT = 5;
    private LoadingCache<String, Integer> attemptsCache;

    public LoginAttempt() {

        super();
        attemptsCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Integer>() {
            @Override
            public Integer load(final String key) {
                return 0;
            }
        });
    }

    public void loginSuccess(final String key) {
        attemptsCache.invalidate(key);
    }

    public void loginFailed(final String key) {
        int attempts = 0;
        try {
        attempts = attemptsCache.get(key);
        } catch (final ExecutionException e) {
        attempts = 0;
        }
    }

    public boolean isBlocked(final String key) {
        try {
            return attemptsCache.get(key) >= MAX_ATTEMPT;
        } catch (final ExecutionException e) {
            return false;
        }
    }
}
