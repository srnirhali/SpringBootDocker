package com.example.demo.controller;
import com.example.demo.security.UserPrinciple;
import com.example.demo.security.UserPrincipleAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Arrays;

public class WithMockUserContextFactory implements WithSecurityContextFactory<WithMockUser>{

    @Override
    public SecurityContext createSecurityContext(WithMockUser annotation) {
        var authorities = Arrays.stream(annotation.authorities())
                .map(SimpleGrantedAuthority::new).toList();
        var principle = UserPrinciple.builder()
                .userId(annotation.userId())
                .email("facke@email.com")
                .authorities(authorities)
                .build();
        var context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(new UserPrincipleAuthenticationToken(principle));
        return context;
    }
}
