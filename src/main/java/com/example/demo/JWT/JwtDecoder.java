package com.example.demo.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.configs.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtDecoder {
    private final JwtProperties jwtProperties;
    public DecodedJWT decode(String token){
        return JWT.require(Algorithm.HMAC512(jwtProperties.getKey()))
                .build().verify(token);
    }
}
