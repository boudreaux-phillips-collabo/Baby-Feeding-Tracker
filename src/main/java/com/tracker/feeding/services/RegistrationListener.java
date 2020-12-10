package com.tracker.feeding.services;

import com.tracker.feeding.models.User;
import com.tracker.feeding.services.IUserService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<RegistrationEventHandler> {
    @Autowired
    private IUserService service;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    @Override
    public void onApplicationEvent(final RegistrationEventHandler event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final RegistrationEventHandler event) {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createUserVerificationToken(user, token);
        final SimpleMailMessage email = constructEmailMessage(event, user, token);
    }

    private SimpleMailMessage constructEmailMessage(final RegistrationEventHandler event, final User user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Baby Feeding Tracker Account Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/confirmRegistration.html?token=" + token;
        final String message = messages.getMessage("message.regSuccLink", null, "Welcome to Baby Feeding Tracker. To complete registration, please follow the link.", event.getLocale());
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        //email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
