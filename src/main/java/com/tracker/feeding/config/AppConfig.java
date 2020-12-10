package com.tracker.feeding.config;

import com.tracker.feeding.security.ActiveUserStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ActiveUserStore aus() {
        return new ActiveUserStore();
    }

}