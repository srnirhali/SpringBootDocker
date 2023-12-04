package com.example.demo.services;

import com.example.demo.dtos.UserCreateRequest;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserCreateRequest userCreateRequest){
        User u = new User();
        u.setEmail(userCreateRequest.getEmail());
        u.setPassword(userCreateRequest.getPassword());
        u.setUsername(userCreateRequest.getUsername());
        return  userRepository.save(u);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
