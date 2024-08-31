package com.AmaliaStefan.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AmaliaStefan.entity.Comments;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer> {
    List<Comments> findByBookId(int bookId);
}

