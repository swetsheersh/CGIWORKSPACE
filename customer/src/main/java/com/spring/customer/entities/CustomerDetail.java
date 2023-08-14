package com.spring.customer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CustomerDetail {
	@Id
	@Column(name = "id")
	private int bookId;
	private String bookTitle;
	private String author;
	private double price;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CustomerDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDetail(int bookId, String bookTitle, String author, double price) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.price = price;
	}
	@Override
	public String toString() {
		return "CustomerDetail [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + ", price="
				+ price + "]";
	}
	
	
}
