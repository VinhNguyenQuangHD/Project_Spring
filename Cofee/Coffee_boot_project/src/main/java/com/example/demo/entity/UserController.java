package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/add")
    public String show_list(Model model){
        List<User> list = service.listAll();
        model.addAttribute("list",list);
        model.addAttribute("title","Main View");

        return "add";
    }

    @GetMapping("/add/plus")
    public String showAddForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","Add new user");
        return "add_form";
    }

    @PostMapping("/add/save")
    public String saveUser(User user, RedirectAttributes re_atr){
        service.save(user);
        re_atr.addFlashAttribute("message","User has been created !!!");
        return "redirect:/add";
    }

    @GetMapping("/add/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes re_atr){
        try {
            User user = service.get(id);
            model.addAttribute("user",user);
            model.addAttribute("title","Edit User "+id+"");
            return "add_form";
        } catch (UserNotFoundException e) {
            re_atr.addFlashAttribute("message","Error detected !!!");
            return "redirect:/add";
        }
    }

    @GetMapping("/add/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes re_atr){
        try {
            service.delete(id);
            return "redirect:/add";
        } catch (UserNotFoundException e) {
            re_atr.addFlashAttribute("message","Error detected !!!");
            return "redirect:/add";
        }
    }
}
