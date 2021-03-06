package com.deckofcards.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Slf4j
@EnableWebSecurity
@Configuration
@Profile("disableSecurity")
public class DisableWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) {
        log.warn("Security deactivated!");
        webSecurity.ignoring().anyRequest();
    }
}
