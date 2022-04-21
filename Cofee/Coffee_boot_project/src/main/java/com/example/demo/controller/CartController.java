package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Production;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping("/show-cart")
    public String view_cart(Model model) throws UserNotFoundException {
        List<Cart> list_cart =  cartService.show_all_cart();
        int sum = 0;
        for(Cart cart : list_cart){
            sum = sum + Integer.valueOf(cart.getTotal());
        }


        model.addAttribute("sum", String.valueOf(sum));
        model.addAttribute("cart_list", list_cart);
        model.addAttribute("total_price", list_cart.size());
        return "cart";
    }

    @GetMapping("/add-cart/{id}")
    public String view_add_cart_form(@PathVariable("id") Integer id,Model model) throws UserNotFoundException {
        Production production = productService.findProductionId(id);
        model.addAttribute("production_name",production.getProduct_name());
        model.addAttribute("production_image",production.getProduct_image());
        model.addAttribute("production_id",production.getId());
        model.addAttribute("production_price",production.getProduct_price());
        return "add_to_cart";
    }

    @PostMapping("/save-cart")
    public String save_to_cart(@RequestParam(value = "production_name", required = false) String name,
                               @RequestParam(value = "production_price", required = false) String price,
                               @RequestParam(value = "production_count", required = false) String count,
                               @RequestParam(value = "production_image", required = false) String image){
        cartService.save_cart(name,price,count,image);
        return "redirect:/home";
    }

    @GetMapping("/delete-cart/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes re_atr){
        cartService.delete_cart(id);
        return "redirect:/show-cart";
    }
}
