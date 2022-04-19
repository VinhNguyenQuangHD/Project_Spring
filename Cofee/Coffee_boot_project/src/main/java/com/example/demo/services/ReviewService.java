package com.example.demo.services;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAllReview(){
        return reviewRepository.findAll();
    }

    public void saveReview(Review review){
        reviewRepository.save(review);
    }

    public void deleteReview(Integer id){
        reviewRepository.deleteById(id);
    }
}
