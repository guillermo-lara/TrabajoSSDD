package es.codeurjc.booknest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.booknest.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>{
    
}
