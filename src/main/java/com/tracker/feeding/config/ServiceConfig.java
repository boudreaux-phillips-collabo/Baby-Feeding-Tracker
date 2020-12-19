package com.tracker.feeding.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( { "com.tracker.feeding.services"} )
public class ServiceConfig {}