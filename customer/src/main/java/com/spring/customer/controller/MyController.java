package com.spring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.customer.dao.CustomerRepository;
import com.spring.customer.entities.CustomerDetail;
import com.spring.customer.service.CustomerServiceImpl;

@RestController
public class MyController {
	@Autowired
	private CustomerRepository repo;
	@Autowired
	private CustomerServiceImpl impl;
	@PostMapping(path="/addbook")
	public ResponseEntity<?> addBook(@RequestBody CustomerDetail detail){
		if(repo.existsById(detail.getBookId())) {
			return new ResponseEntity<String>("Book Already Available!!",HttpStatus.CONFLICT);
		}
		impl.addBook(detail);
		return new ResponseEntity<String>("Added Successfully",HttpStatus.OK);
	}
	@GetMapping(path="/getall")
	public ResponseEntity<?> getAll(){
		List<CustomerDetail> detail=impl.getAllBooks();
		if(detail.size()<=0) {
			return new ResponseEntity<String>("Empty List",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<CustomerDetail>>(detail,HttpStatus.OK);
	}
}
