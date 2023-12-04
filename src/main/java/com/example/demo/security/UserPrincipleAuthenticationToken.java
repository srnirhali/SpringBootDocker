package com.example.demo.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;


public class UserPrincipleAuthenticationToken extends AbstractAuthenticationToken {
    private final UserPrinciple userPrinciple;
    public UserPrincipleAuthenticationToken(UserPrinciple principle) {
        super(principle.getAuthorities());
        this.userPrinciple = principle;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrinciple getPrincipal() {
        return this.userPrinciple;
    }
}
