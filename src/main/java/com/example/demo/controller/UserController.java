package com.example.demo.controller;




import com.example.demo.dtos.UserCreateRequest;
import com.example.demo.repositories.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    ResponseEntity<List<User>> all() {
       return  ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/add")
    ResponseEntity<User> addUser(@RequestBody UserCreateRequest userCreateRequest){
        return ResponseEntity.ok(userService.addUser(userCreateRequest));
    }



}
