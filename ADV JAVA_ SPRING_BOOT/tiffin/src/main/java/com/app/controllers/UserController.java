package com.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.services.UserService;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public void addUser(final User user) {
        userService.addUser(user);
    }

    @PostMapping(value = "/user/delete")
    public void deleteUser(final String userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(value = "/user/update")
    public void updateUser(final User user) {
        userService.updateUser(user);
    }

    @GetMapping(value = "/user/{userId}")
    public User getUser(final String userId) {
        return userService.getUser(userId);
    }
}
