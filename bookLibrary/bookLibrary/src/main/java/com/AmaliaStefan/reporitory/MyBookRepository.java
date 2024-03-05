package com.AmaliaStefan.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AmaliaStefan.entity.MyBookList;


@Repository
public interface MyBookRepository extends JpaRepository<MyBookList,Integer>{

}