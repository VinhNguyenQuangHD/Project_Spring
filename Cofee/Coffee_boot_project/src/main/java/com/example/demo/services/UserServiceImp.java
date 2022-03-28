package com.example.demo.services;


import com.example.demo.model.Roles;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnable("VERIFIED");
        Roles userRole = roleRepository.findByRole("SITE_USER");
        user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public boolean isUserAlreadyExists(User user) {
        return false;
    }
}
