package com.stackroute.product.service;

import java.util.List;

import com.stackroute.product.exception.ProductNotFoundException;
import com.stackroute.product.model.Product;

public interface ProductService {

	Product createProduct(Product product);

	boolean deleteProduct(int productId) throws ProductNotFoundException;

	Product updateProduct(Product product, int ProductId);

	Product getProductById(int productId) throws ProductNotFoundException;

	List<Product> getAllproducts(Product product);
}
