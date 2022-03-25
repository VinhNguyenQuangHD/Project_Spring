package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listAll(){
        return (List<User>) repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> ids = repository.findById(id);
        if(ids.isPresent()){
            return ids.get();
        }throw new UserNotFoundException("Couldn't find any user !!!");
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repository.countById(id);
        if(count == 0 || count == null){
            throw new UserNotFoundException("Couldn't find any user !!!");
        }
        repository.deleteById(id);
    }
}
