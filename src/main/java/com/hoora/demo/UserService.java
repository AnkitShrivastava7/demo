package com.hoora.demo;

import com.hoora.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user){
        return userRepository.save(user);
    }

    public boolean login(String email, String password){

        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isPresent()){

            User user = userOptional.get();

            if(user.getPassword().equals(password)){
                return true;
            }

        }

        return false;
    }

}