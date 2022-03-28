package com.example.demo.services;

import com.example.demo.model.User;

public interface UserService {
    public void saveUser(User user);
    public boolean isUserAlreadyExists(User user);

}
