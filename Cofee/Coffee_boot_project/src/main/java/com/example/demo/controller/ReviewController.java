package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("/review")
    public String show_review(Model model){
        List<Review> list = service.findAllReview();
        model.addAttribute("list_review", list);

        return "review_form";
    }
}
