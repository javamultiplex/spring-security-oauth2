package com.javamultiplex.config;

import feign.RequestInterceptor;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Rohit Agarwal on 21/01/21 9:50 pm
 * @copyright www.javamultiplex.com
 */
public class ClientConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            KeycloakSecurityContext keycloakSecurityContext = getKeycloakSecurityContext();
            requestTemplate.header("Authorization", "Bearer " + keycloakSecurityContext.getTokenString());
        };
    }

    protected KeycloakSecurityContext getKeycloakSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Cannot set authorization header because there is no authenticated principal");
        } else if (!KeycloakAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            throw new IllegalStateException(String.format("Cannot set authorization header because Authentication is of type %s but %s is required", authentication.getClass(), KeycloakAuthenticationToken.class));
        } else {
            KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) authentication;
            KeycloakSecurityContext context = token.getAccount().getKeycloakSecurityContext();
            return context;
        }
    }
}
