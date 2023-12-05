package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.SignUpRequest;
import com.example.demo.models.UserRole;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User createUser(SignUpRequest signUpRequest){
        User u = new User();
        u.setEmail(signUpRequest.getEmail());
        u.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        u.setUsername(signUpRequest.getUsername());
        u.setRole(UserRole.ROLE_USER);
        return  userRepository.save(u);
    }

    public boolean existsUsersByEmail(String email) {
        return userRepository.existsUsersByEmail(email);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User changeRole(String email, UserRole userRole) {
        User user = userRepository.findByEmail(email).orElseThrow();
        user.setRole(userRole);
        userRepository.save(user);
        return user;
    }
}
