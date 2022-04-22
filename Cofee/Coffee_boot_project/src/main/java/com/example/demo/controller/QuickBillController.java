package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.services.CartService;
import com.example.demo.services.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuickBillController {
    @Autowired
    private CartService cartService;

    @GetMapping("/quick-bill/{id}")
    public String show_quick_bill(@PathVariable("id") Integer id, Model model) throws UserNotFoundException {
        Cart cart = cartService.update_cart(id);
        model.addAttribute("cart",cart);

        return "quickbill";
    }

    @GetMapping("/full-bill")
    public String show_full_bill(Model model){
        List<Cart> list_cart =  cartService.show_all_cart();
        int sum = 0;
        for(Cart cart : list_cart){
            sum = sum + Integer.valueOf(cart.getTotal());
        }


        model.addAttribute("sum", String.valueOf(sum));
        model.addAttribute("cart_list", list_cart);
        model.addAttribute("total_price", list_cart.size());
        return "full_bill";
    }
}
