package es.codeurjc.booknest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.booknest.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    
}
