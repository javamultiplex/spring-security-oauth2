package com.javamultiplex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Rohit Agarwal on 28/01/21 2:02 pm
 * @copyright www.javamultiplex.com
 */
@Configuration
public class UserManagementConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("Rohit")
                .password(passwordEncoder.encode("test123"))
                .authorities("read")
                .build();
        userDetailsManager.createUser(userDetails);
        return userDetailsManager;
    }
}
