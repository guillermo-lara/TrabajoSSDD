package es.codeurjc.booknest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.booknest.model.*;
import es.codeurjc.booknest.repository.*;

@Service
public class ReviewService {
    @Autowired
    private  ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }
    public List<Review> findAll() {
        return repository.findAll();
    }
    public void save(Review review) {
        repository.save(review);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public Review findById(Long id) {
        return repository.findById(id).orElse(null);
    }





    
}