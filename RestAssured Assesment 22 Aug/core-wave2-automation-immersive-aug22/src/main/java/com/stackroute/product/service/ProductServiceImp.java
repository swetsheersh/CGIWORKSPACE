package com.stackroute.product.service;

import org.springframework.stereotype.Service;

import com.stackroute.product.respository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import com.stackroute.product.exception.ProductNotFoundException;
import com.stackroute.product.model.Product;
import com.stackroute.product.respository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	private ProductRepository productRepository;

	public ProductServiceImp(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		Product productadded = productRepository.save(product);
		return productadded;
	}

	public boolean deleteProduct(int productId) throws ProductNotFoundException {
		try {
			productRepository.deleteById(productId);
			return true;
		} catch (Exception e) {
			throw new ProductNotFoundException("Product is not present ");
		}
	}

	public Product updateProduct(Product product, int productId) {
		productRepository.save(product);
		return productRepository.findById(productId).get();

	}

	@Override
	public Product getProductById(int productId) throws ProductNotFoundException {
		Product product = null;
		try {
			product = productRepository.findById(productId).get();
			if (product != null) {
				return product;
			} else {
				throw new ProductNotFoundException("Product is not found");
			}
		} catch (NoSuchElementException e) {

			throw new ProductNotFoundException("Product is not found");
		}
	}

	public List<Product> getAllproducts(Product product) {
		return productRepository.findAll();
	}

}
