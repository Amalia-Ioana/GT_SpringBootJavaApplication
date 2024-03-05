package com.AmaliaStefan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.AmaliaStefan.entity.Author;
import com.AmaliaStefan.service.AuthorService;




@Controller
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
//    @GetMapping("/author-profile")
//    public ModelAndView getAllAuthors() {
//        List<Author> authors = authorService.getAllAuthors();
//        return new ModelAndView("authorList","authors", authors); 
//    }
    
    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";

}
}
