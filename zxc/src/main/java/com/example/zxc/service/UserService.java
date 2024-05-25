package com.example.zxc.service;

import com.example.zxc.models.User;
import com.example.zxc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String password, String email) {
        if(username == null || password == null) {
            return null;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user).block();
        }
    }

    public User authenticate(String Username, String Password) {
        return userRepository.findByUsernameAndPassword(Username, Password).block();
    }
}
