package com.AmaliaStefan.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AmaliaStefan.service.MyBookListService;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="MyBooks")
public class MyBookList {
	
	@Id
	private int id;
	private String name;
	private String author;
	private String price;
	private String image;
	
	public MyBookList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyBookList(int id, String name, String author, String price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}