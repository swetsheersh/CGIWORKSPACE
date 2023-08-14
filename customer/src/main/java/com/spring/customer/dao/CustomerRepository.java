package com.spring.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.customer.entities.CustomerDetail;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetail, Integer>{

}
