package com.example.demo.services;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;


    public List<Cart> show_all_cart(){
        return repository.findAll();
    }

    public void save_cart(String name, String price, String count, String image){
        Cart cart = new Cart();
        cart.setProduction_name(name);
        cart.setProduction_price(price);
        cart.setProduction_count(count);
        cart.setProduction_image(image);
        int total = Integer.valueOf(price) * Integer.valueOf(count);
        cart.setTotal(String.valueOf(total));
        repository.save(cart);
    }

    public Cart update_cart(Integer id) throws UserNotFoundException {
        Optional<Cart> cart = repository.findById(id);
        if(cart.isPresent()){
            return cart.get();
        }
        throw new UserNotFoundException("Cart item not found !!!");
    }

    public void delete_cart(Integer id){
        repository.deleteById(id);
    }
}
