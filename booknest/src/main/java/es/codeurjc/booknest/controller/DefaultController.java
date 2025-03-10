package es.codeurjc.booknest.controller;

import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.booknest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {
    //@Autowired
    //private  AuthorService authorService;
    @Autowired
    private BookService bookService;
    //@Autowired
    //private ReviewService reviewService;
    //@Autowired
    //private UserService userService;
    //Los comentados todavía no se usan, pero supongo que los tendremos que acabar usando


    @GetMapping
    public String showLists(Model model) {
        model.addAttribute("books", bookService.findRandomBooks(6));
        return "index";
    }

    //EN LA PÁGINA PRINCIPAL SERÁ COMO EN LETTERBOX, SE MOSTRARÁN UNOS LIBROS ALEATORIAMENTE
    //TENEMOS QUE SEGUIR EL MISMO SISTEMA DE URLS QUE LETTERBOX O UNO MUY SIMILAR PARA QUE NO NOS LIEMOS
    //CUANDO UNO HAGA CAMBIOS

    /* 
    @GetMapping("add-user")
    public String addUser() {
        return "add-user";
    }

    @GetMapping("error")
    public String getError() {
        return "error";
    }
    
    

    @GetMapping("add-author")
    public String addAuthor() {
        return "add-author";
    }

    @GetMapping("add-book")
    public String addBook(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "add-book";
    }

    @GetMapping("add-review")
    public String addReview(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("users", userService.findAll());
        return "add-review";
    }

    

  

    @PostMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/delete-review/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/";
    }
    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/";
    }
*/
}
