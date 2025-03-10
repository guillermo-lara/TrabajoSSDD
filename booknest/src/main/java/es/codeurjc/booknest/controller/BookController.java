package es.codeurjc.booknest.controller;



import java.io.IOException;

import es.codeurjc.booknest.model.*;
import es.codeurjc.booknest.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//NO HE HECHO CAMBIOS

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private  AuthorService authorService;
    public BookController(BookService service, AuthorService authorService) {
        this.service = service;
        this.authorService = authorService;
    }
    
    @PostMapping("/save")
    public String saveBook(@RequestParam String name, @RequestParam int yearPub, @RequestParam Long authorId, @RequestParam("image") MultipartFile image) {
        Author author = authorService.findById(authorId); 
    
        if (author == null) {
            return "redirect:/error"; 
        }
    
        Book book = new Book();
        book.setName(name);
        book.setYearPub(yearPub);
        book.setAuthor(author); 
        try {
            if (!image.isEmpty()) {
                book.setImage(image.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/error";
        }
    
        service.save(book); 
        return"redirect:/";
    }

@GetMapping("/edit-book/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        Book book = service.findById(id);
        if (book == null) {
            return "redirect:/";
        }

        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.findAll());
        return "edit-book";
    }
/* 
    @PostMapping("/edit")
    public String efditBook(@RequestParam Long id, @RequestParam String name, @RequestParam int yearPub, @RequestParam Long authorId) {
        Book book = service.findById(id);
        if (book == null) {
            return "redirect:/";
        }

        Author author = authorService.findById(authorId);
        if (author == null) {
            return "redirect:/";
        }

        book.setName(name);
        book.setYearPub(yearPub);
        book.setAuthor(author);

        service.save(book);
        return "redirect:/";
}





@PostMapping("/update/{id}")
public String editBook(@RequestParam Long id, @RequestParam String name, @RequestParam int yearPub, @RequestParam Long authorId) {
    Book book = service.findById(id);
    if (book == null) {
        return "redirect:/";
    }

    Author author = authorService.findById(authorId);
    if (author == null) {
        return "redirect:/";
    }

    book.setName(name);
    book.setYearPub(yearPub);
    book.setAuthor(author);

    service.save(book);
    return "redirect:/";
}

*/
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
