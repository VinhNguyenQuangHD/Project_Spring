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
        return productRepository.findAll();
    }

    public void save(Production production, MultipartFile file) {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
            production.setProduct_image(Base64.getEncoder().encodeToString(filename.getBytes()));
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

    public void SaveImageToDataBase(MultipartFile file, String product_name, String product_price, String product_type) throws IOException {
        Production production = new Production();
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        if(filename.contains("..")){
            System.out.print("Invalid file !!!");
        }
        else{
            production.setProduct_image(Base64.getEncoder().encodeToString(file.getBytes()));
            production.setProduct_name(product_name);
            production.setProduct_type(product_type);
            production.setProduct_price(Integer.valueOf(product_price));

            productRepository.save(production);
        }
    }

    public void changeProductName(Integer id,String name){
        Production production = new Production();
        production = productRepository.findById(id).get();
        production.setProduct_name(name);
        productRepository.save(production);
    }

    public void changeProductPrice(Integer id,String price){
        Production production = new Production();
        production = productRepository.findById(id).get();
        production.setProduct_name(price);
        productRepository.save(production);
    }

}
