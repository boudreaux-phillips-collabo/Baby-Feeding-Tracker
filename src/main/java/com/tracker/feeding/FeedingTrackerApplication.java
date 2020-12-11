package com.tracker.feeding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class FeedingTrackerApplication {
    public static void main(String[] args) { SpringApplication.run(FeedingTrackerApplication.class, args); }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
