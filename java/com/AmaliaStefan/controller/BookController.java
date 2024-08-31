package com.AmaliaStefan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.AmaliaStefan.entity.Author;
import com.AmaliaStefan.entity.Book;
import com.AmaliaStefan.entity.Comments;
import com.AmaliaStefan.entity.MyBookList;
import com.AmaliaStefan.service.AuthorService;
import com.AmaliaStefan.service.BookService;
import com.AmaliaStefan.service.CommentService;
import com.AmaliaStefan.service.MyBookListService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookService;
    
    @Autowired
    private CommentService commentService;
   

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> list = service.getAllBook();
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice(), b.getImage());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model, Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            Book b = service.getBookById(id);
            model.addAttribute("book", b);
            return "bookEdit";
        } else {
            return "accessDenied";
        }
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id, Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            service.deleteById(id);
            return "redirect:/available_books";
        } else {
            return "accessDenied";
        }
    }
    
    @GetMapping("/bookDetails/{id}")
    public String getBookDetails(@PathVariable("id") int id, Model model) {
        Book book = service.getBookById(id);
        List<Comments> comments = commentService.getCommentsByBookId(id);
        model.addAttribute("book", book);
        model.addAttribute("comments", comments);
        return "bookDetails";
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam("bookId") int bookId,
                             @RequestParam("username") String username,
                             @RequestParam("comment") String commentText) {
        Book book = service.getBookById(bookId);
        Comments comment = new Comments(username, commentText, book);
        commentService.save(comment);
        return "redirect:/bookDetails/" + bookId;
    }
    
    @GetMapping("/search_books")
    public ModelAndView searchBooks(@RequestParam(value = "query", required = false) String query) {
        List<Book> books;
        if (query != null && !query.trim().isEmpty()) {
            books = service.searchBooks(query);
        } else {
            books = service.getAllBook();
        }
        return new ModelAndView("bookList", "book", books);
    }
}
