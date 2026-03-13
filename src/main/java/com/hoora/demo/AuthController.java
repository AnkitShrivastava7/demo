package com.hoora.demo.controller;

import com.hoora.demo.entity.User;
import com.hoora.demo.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        Optional<User> userOptional = userRepository.findByEmail(loginUser.getEmail());

        if(userOptional.isPresent()) {

            User user = userOptional.get();

            if(user.getPassword().equals(loginUser.getPassword())) {
                return "success";
            }
        }

        return "fail";
    }
}