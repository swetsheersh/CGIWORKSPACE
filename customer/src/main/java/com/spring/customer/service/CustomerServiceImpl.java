package com.spring.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.customer.dao.CustomerRepository;
import com.spring.customer.entities.CustomerDetail;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repo;

	@Override
	public void addBook(CustomerDetail detail) {
		this.repo.save(detail);
	}

	@Override
	public List<CustomerDetail> getAllBooks() {
		return this.repo.findAll();
	}
	
	
}
