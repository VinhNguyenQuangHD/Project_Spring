package com.example.demo.controller;

import com.example.demo.model.StaffInfor;
import com.example.demo.model.User;
import com.example.demo.repository.StaffInforRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.StaffInforService;
import com.example.demo.services.UserNotFoundException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class StaffController {
    @Autowired
    private UserService userService;

    @Autowired
    private StaffInforService staffInforService;

    @GetMapping("/add-new-staff-infor/{id}")
    public String show_add_staff_form(@PathVariable("id") Integer id, Model model) throws UserNotFoundException {
        StaffInfor infor = staffInforService.findStaffInforById(id);
        model.addAttribute("infor",infor);
        return "add_new_staff_infor";
    }

    @PostMapping("/save-user-information")
    public String SaveInforUser(@RequestParam(value = "staff_image", required = false) MultipartFile files,StaffInfor infor) throws IOException {
        staffInforService.StaffSaveInformation(files,infor);
        return "redirect:/home";
    }

    @GetMapping("/show-profile/{id}")
    public String show_profile_page(@PathVariable("id") Integer id, Model model) throws UserNotFoundException {
        User user = userService.findUserById(id);
        StaffInfor infor = staffInforService.findStaffByEmail(user.getEmail());
        model.addAttribute("infor",infor);
        return "profile_personal";
    }
}
