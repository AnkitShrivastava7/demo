package com.hoora.demo.controller;

import com.hoora.demo.entity.User;
import com.hoora.demo.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam String email) {

        List<User> users = userRepository.findAll();

        // remove logged-in user
        return users.stream()
                .filter(user -> !user.getEmail().equals(email))
                .collect(Collectors.toList());
    }
}