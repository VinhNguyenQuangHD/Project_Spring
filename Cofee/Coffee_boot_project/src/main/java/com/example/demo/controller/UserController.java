package com.example.demo.controller;

import com.example.demo.model.Production;
import com.example.demo.model.User;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService service;

    @GetMapping("/home")
    public String show_home_page(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findingUserByUsername(username);
        List<Production> list = service.listAll();
        model.addAttribute("list_production",list);
        model.addAttribute("username",user);
        return "homepage";
    }

    @GetMapping("/login")
    public ModelAndView show_login(){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView show_register(){
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("register", user);
        model.setViewName("register");
        return model;
    }

    @PostMapping("/register")
    public String Save_infor(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode_pass = encoder.encode(user.getPassword());
        user.setPassword(encode_pass);
        userService.save(user);

        return "redirect:/login";
    }

}
