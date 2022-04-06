package com.example.demo.controller;

import com.example.demo.model.Production;
import com.example.demo.model.Types;
import com.example.demo.services.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TypeController {

    @Autowired
    private TypesService service;

    @GetMapping("/add-new-type")
    public String show_form_add_type( Model model){
        model.addAttribute("types",new Types());
        model.addAttribute("title","Add new title");
        return "form_add_types";
    }

    @PostMapping("/add-progress")
    public String add_new_title(Types type, RedirectAttributes re_atr){
        service.saveTypes(type);
        re_atr.addFlashAttribute("message","Chủ đề mới đã được thêm vào !!!");
        return "redirect:/add";
    }
}
