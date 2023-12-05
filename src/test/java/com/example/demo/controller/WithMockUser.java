package com.example.demo.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.security.test.context.support.WithSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockUserContextFactory.class)
public @interface WithMockUser {
    long userId() default 1L;

    String [] authorities() default "ROLE_USER";
}
