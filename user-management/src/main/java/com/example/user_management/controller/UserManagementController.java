package com.example.user_management.controller;

import com.example.user_management.entity.User;
import com.example.user_management.repository.UserRelationshipRepository;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping("/")
    public List<User> getAllUser(){
        return userManagementService.getAllUsers();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userManagementService.createUser(user);
    }

}
