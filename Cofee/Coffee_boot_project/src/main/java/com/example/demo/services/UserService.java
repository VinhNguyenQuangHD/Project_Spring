package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public User getCurrentLogginUser(Authentication authentication){
        if(authentication == null){
            return null;
        }

        User user = null;
        Object principal = authentication.getPrincipal();

        if(principal instanceof CustomUserDetail){
            user = ((CustomUserDetail)principal).getUser();
        }

        return user;
    }
}
