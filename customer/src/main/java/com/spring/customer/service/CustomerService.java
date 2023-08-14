package com.spring.customer.service;

import java.util.List;

import com.spring.customer.entities.CustomerDetail;

public interface CustomerService {
	public void addBook(CustomerDetail detail);
	public List<CustomerDetail> getAllBooks();
}
