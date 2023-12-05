package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.models.LoginRequest;
import com.example.demo.models.LoginResponse;
import com.example.demo.models.SignUpRequest;
import com.example.demo.services.AuthService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)  {

        return ResponseEntity.ok(authService.login(loginRequest.getEmail(),loginRequest.getPassword()));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest) {
        if(userService.existsUsersByEmail(signUpRequest.getEmail())) return ResponseEntity.badRequest().build();
        User u =userService.createUser(signUpRequest);
        return ResponseEntity.ok(u);
    }



}
