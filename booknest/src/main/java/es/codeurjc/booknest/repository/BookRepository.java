package es.codeurjc.booknest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.booknest.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    
}
