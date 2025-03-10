package es.codeurjc.booknest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.booknest.model.BookList;


public interface BookListRepository extends JpaRepository<BookList,Long> {
    
}
