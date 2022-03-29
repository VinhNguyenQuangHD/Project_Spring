package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public ModelAndView show_home_page(){
        ModelAndView model = new ModelAndView();
        model.setViewName("homepage");

        return model;
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
        userRepository.save(user);

        return "redirect:/login";
    }

}
