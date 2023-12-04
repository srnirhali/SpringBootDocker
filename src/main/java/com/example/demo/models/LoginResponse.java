package com.example.demo.models;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class LoginResponse {
    private String accessToken;
}
