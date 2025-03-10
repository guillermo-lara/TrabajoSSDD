package es.codeurjc.booknest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import es.codeurjc.booknest.model.*;
import es.codeurjc.booknest.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//NO HE HECHO CAMBIOS

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private  AuthorService service;


    @GetMapping("/edit-author/{id}")
    public String editAuthor(@PathVariable Long id, Model model) {
        Author author = service.findById(id);
        model.addAttribute("id", author.getId());
        model.addAttribute("name", author.getName());
        return "edit-author";

    }
    
    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, @RequestParam String name) {
        Author author = service.findById(id);
        if (author != null) {
            author.setName(name);
            service.save(author);
        }
        return "redirect:/";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Author author) {
        service.save(author);
        return "redirect:/";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/authors";
    }
}
