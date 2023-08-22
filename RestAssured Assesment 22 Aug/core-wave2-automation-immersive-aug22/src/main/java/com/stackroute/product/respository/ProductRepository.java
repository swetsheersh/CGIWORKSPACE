package com.stackroute.product.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stackroute.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
