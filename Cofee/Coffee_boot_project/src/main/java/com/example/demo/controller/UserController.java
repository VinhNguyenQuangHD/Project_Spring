package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

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
    public ModelAndView Save_infor(User user, RedirectAttributes re_atr){
        ModelAndView model = new ModelAndView();
        if(userServiceImp.isUserAlreadyExists(user)){
            re_atr.addFlashAttribute("alert","User already exists !!!");
        }else{
            userServiceImp.saveUser(user);

        }
        model.addObject("register",new User());
        model.setViewName("register");
        return model;
    }

    @PostMapping("/login-progress")
    public String login_process(){
        return "redirect:/home";
    }
}
