package com.example.demo.controller;

import com.example.demo.model.Production;
import com.example.demo.model.Types;
import com.example.demo.services.ProductService;
import com.example.demo.services.TypesService;
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

import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private TypesService typesService;


    @GetMapping("/add")
    public String show_list(Model model){
        List<Production> list = service.listAll();
        List<Types> list_types = typesService.findAllTypes();
        model.addAttribute("list_production",list);
        model.addAttribute("list_types",list_types);

        return "control_center";
    }

    @GetMapping("/add/plus")
    public String showAddForm(){
        return "add_form";
    }

    /*@PostMapping("/add/save")
    public String saveUser(Production production, @RequestParam(value = "product_image") MultipartFile file,RedirectAttributes re_atr){
        service.save(production,file);
        re_atr.addFlashAttribute("message","User has been created !!!");
        return "redirect:/add";
    }*/

    @PostMapping("/add/save")
    public String addToData(@RequestParam(value = "product_image", required = false) MultipartFile files
    , @RequestParam(value = "product_name", required = false) String name, @RequestParam(value = "product_type", required = false) String type,
                            @RequestParam(value = "product_price", required = false) String price) throws IOException {
        service.SaveImageToDataBase(files,name,price,type);
        return "redirect:/add";
    }

    @GetMapping("/add/setting-name/{id}")
    public String showSettingNameForm(@PathVariable("id") Integer id, Model model) throws UserNotFoundException {
        Production production = service.findProductionId(id);
        model.addAttribute("production",production);
        return "setting-product-name";
    }

    @PostMapping("/add/setting-name")
    public String gotProductSettingName(@PathVariable("id") Integer id, @RequestParam(value = "product_name", required = false) String name){
        service.changeProductName(id,name);
        return "redirect:/add";
    }

    /*@GetMapping("/add/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes re_atr) throws UserNotFoundException {
        Production production = service.findProductionId(id);
        model.addAttribute("production",production);
        model.addAttribute("title","Edit production "+id+"");
        return "add_form";
    }*/

   @GetMapping("/add/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes re_atr){
       service.delete(id);
       return "redirect:/add";
   }
}
