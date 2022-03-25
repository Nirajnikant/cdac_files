package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepository;
import com.app.pojos.User;
import com.app.pojos.userType;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        newUser.setType(userType.CUSTOMER);
//        System.out.println("New user: " + newUser.toString());

        for (User user : users) {
//            System.out.println("Registered user: " + newUser.toString());
            System.out.println("USER OLD"+ user.toString());
            System.out.println("New user: " + newUser.toString());
            if (user.getUsername().equals(newUser.getUsername()) && user.getPassword().equals(newUser.getPassword())) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    // original
//    @PostMapping("/users/login")
//    public Status loginUser(@RequestBody User user) {
//        List<User> users = userRepository.findAll();
//
//        for (User other : users) {
//            if (other.equals(user)) {
//                user.setLoggedIn(true);
//                userRepository.save(user);
//                return Status.SUCCESS;
//            }
//        }
//
//        return Status.FAILURE;
//    }
    
    // editing
    @PostMapping("/users/login")
    public String loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.getUsername().equals(user.getUsername()) && other.getPassword().equals(user.getPassword())) {
                other.setLoggedIn(true);
//                userRepository.save(user);
                System.out.println(user.toString());
                System.out.println(other.toString());
                if(other.getType().equals(userType.ADMIN))
                	return "ADMIN";
                if(other.getType().equals(1))
                	return "OWNER";
                if(other.getType().equals(userType.CUSTOMER))
                	return "CUSTOMER";
            }
        }

        return "FAILURE";
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
}