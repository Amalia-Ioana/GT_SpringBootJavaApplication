package com.AmaliaStefan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.AmaliaStefan.entity.Book;
import com.AmaliaStefan.service.BookService;
import com.AmaliaStefan.service.CommentService;

@Controller
public class DetailsController {
	
	@Autowired
	private BookService service;
	
    @Autowired
    private CommentService commentService;
	
    @GetMapping("details/bookDetails/{id}")
    public String getBookDetails(@PathVariable("id") int id, Model model) {
        Book book = service.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("comments", commentService.getCommentsByBookId(id)); //adaugarea comentariilor utilizatorilor pentru fiecare carte in parte
            return "bookDetails";
        } else {
            return "error"; 
        }
    }

}
