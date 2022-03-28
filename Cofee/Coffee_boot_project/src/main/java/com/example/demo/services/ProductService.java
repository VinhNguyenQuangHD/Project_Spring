package com.example.demo.services;

import com.example.demo.model.Production;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Production> listAll(){
        return (List<Production>) repository.findAll();
    }

    public void save(Production product) {
        repository.save(product);
    }

    public Production get(Integer id) throws UserNotFoundException {
        Optional<Production> ids = repository.findById(id);
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
