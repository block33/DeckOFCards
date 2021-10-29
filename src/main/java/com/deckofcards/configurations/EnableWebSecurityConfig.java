package com.deckofcards.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Slf4j
@EnableWebSecurity
@Configuration
@Profile("!disableSecurity")
public class EnableWebSecurityConfig {

}
