package com.AmaliaStefan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmaliaStefan.entity.Book;
import com.AmaliaStefan.reporitory.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	
	public List<Book> searchBooks(String query) {
        return bRepo.findByNameContainingOrAuthorContaining(query, query);
    }
}