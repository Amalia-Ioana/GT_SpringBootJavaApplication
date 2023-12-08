package com.AmaliaStefan.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AmaliaStefan.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer>  {

}