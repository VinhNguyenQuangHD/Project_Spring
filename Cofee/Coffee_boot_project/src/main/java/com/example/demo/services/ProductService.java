package com.example.demo.services;

import com.example.demo.model.Production;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.*;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Production> listAll() {
        return (List<Production>) productRepository.findAll();
    }

    public void save(Production production) {
        productRepository.save(production);
    }

    public Production findProductionId(Integer id) throws UserNotFoundException {
        Optional<Production> production = productRepository.findById(id);
        if(production.isPresent()){
            return production.get();
        }
        throw new UserNotFoundException("User not found !!!");
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
