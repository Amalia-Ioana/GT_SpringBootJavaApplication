package com.AmaliaStefan.service;

import com.AmaliaStefan.entity.Comments;
import com.AmaliaStefan.reporitory.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void save(Comments comment) {
        commentRepository.save(comment);
    }

    public List<Comments> getCommentsByBookId(int bookId) {
        return commentRepository.findByBookId(bookId);
    }
}
