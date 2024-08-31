package com.AmaliaStefan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String price;
	private String image;
	private String book_description;
	private String recenzie1;
	private String recenzie2;

	
	public Book(int id, String name, String author, String price, String image, String book_description,
			String recenzie1, String recenzie2) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.image = image;
		this.book_description = book_description;
		this.recenzie1 = recenzie1;
		this.recenzie2 = recenzie2;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getBook_description() {
		return book_description;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	public String getRecenzie1() {
		return recenzie1;
	}

	public void setRecenzie1(String recenzie1) {
		this.recenzie1 = recenzie1;
	}

	public String getRecenzie2() {
		return recenzie2;
	}

	public void setRecenzie2(String recenzie2) {
		this.recenzie2 = recenzie2;
	}
	
}
