package com.example.demo.services;

import com.example.demo.JWT.JwtIssuer;
import com.example.demo.models.LoginResponse;
import com.example.demo.security.UserPrinciple;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;


    private final AuthenticationManager authenticationManager;



    public LoginResponse login(String email, String password){
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principle = (UserPrinciple) authentication.getPrincipal();
        var roles = principle.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        return LoginResponse.builder()
                .accessToken(jwtIssuer.issue(principle.getUserId(), principle.getEmail(),roles))
                .build();
    }
}
