package com.example.demo.controller;





import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    ResponseEntity<List<User>> all() {
       return  ResponseEntity.ok(userService.getAllUser());
    }



}
