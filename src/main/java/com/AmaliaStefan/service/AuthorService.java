package com.AmaliaStefan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmaliaStefan.entity.Author;
import com.AmaliaStefan.reporitory.AuthorRepository;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
    
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
