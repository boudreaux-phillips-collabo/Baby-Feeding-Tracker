package com.tracker.feeding.security.google2fa;

import com.tracker.feeding.models.User;
import com.tracker.feeding.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.jboss.aerogear.security.otp.Totp;

public class AuthProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserRepository userDao;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        final User user = userDao.findByEmail(auth.getName());
        if ((user == null)) {
            throw new BadCredentialsException("Invalid username or password.");
        }

        if (user.isUsing2FA()) {
            final String verificationCode = ((AuthDetails) auth.getDetails()).getVerificationCode();
            final Totp totp = new Totp(user.getSecret());
            if (!isValidLong(verificationCode) || !totp.verify(verificationCode)) {
                throw new BadCredentialsException("Invalid code. Please try again.");
            }
        }
        final Authentication result = super.authenticate(auth);
        return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());
    }

    private boolean isValidLong(String code) {
        try {
            Long.parseLong(code);
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
