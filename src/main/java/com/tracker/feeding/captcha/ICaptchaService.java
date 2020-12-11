package com.tracker.feeding.captcha;

import com.tracker.feeding.util.errors.ReCaptchaInvalidException;

public interface ICaptchaService {

    default void processResponse(final String response) throws ReCaptchaInvalidException {}

    default void processResponse(final String response, String action) throws ReCaptchaInvalidException {}

    String getReCaptchaSite();

    String getReCaptchaSecret();

}