package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.models.UserRole;
import com.example.demo.models.UserRoleChangeRequest;
import com.example.demo.security.UserPrinciple;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping("/details")
    public ResponseEntity<UserPrinciple> login(@AuthenticationPrincipal UserPrinciple userPrinciple)
    {
        return ResponseEntity.ok(userPrinciple);
    }

    @PostMapping("/change-role")
    public ResponseEntity<User> changeRole(@RequestBody UserRoleChangeRequest userRoleChangeRequest){
        return ResponseEntity.ok(userService
                .changeRole(userRoleChangeRequest.getEmail(),
                        UserRole.valueOf(userRoleChangeRequest.getRole())));
    }
}
