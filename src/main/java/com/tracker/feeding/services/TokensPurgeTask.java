package com.tracker.feeding.services;

import com.tracker.feeding.repositories.PasswordResetTokenRepository;
import com.tracker.feeding.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Service
@Transactional
public class TokensPurgeTask {

    @Autowired
    VerificationTokenRepository tokenDao;

    @Autowired
    PasswordResetTokenRepository passwordTokenDao;

    @Scheduled(cron = "${purge.cron.expression}")
    public void purgeExpired() {

        Date now = Date.from(Instant.now());

        passwordTokenDao.deleteAllExpiredSince(now);
        tokenDao.deleteAllExpiredSince(now);
    }
}
