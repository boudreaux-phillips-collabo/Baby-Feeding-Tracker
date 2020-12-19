package com.tracker.feeding.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(String token);
}