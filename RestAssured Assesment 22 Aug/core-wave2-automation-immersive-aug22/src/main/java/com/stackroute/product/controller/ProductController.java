package com.stackroute.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.product.exception.ProductNotFoundException;
import com.stackroute.product.model.Product;
import com.stackroute.product.service.ProductService;

@RestController
@RequestMapping("/productservice")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	// adding a product

	@PostMapping(path = "/addProduct", consumes = "application/json")
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);

	}

	// updating product
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable("productId") int id, @RequestBody Product product)
			throws ProductNotFoundException {
		Product updateProduct = productService.updateProduct(product, id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}

	// get product by id
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable() int productId) throws ProductNotFoundException {
		Product product = productService.getProductById(productId);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("You don't have any product added in your list", HttpStatus.NOT_FOUND);
		}
	}

	// get all products
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts(Product product) {
		List<Product> allCategory = productService.getAllproducts(product);
		if (allCategory != null) {
			return new ResponseEntity<List<Product>>(allCategory, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error in loading the content", HttpStatus.NOT_FOUND);
		}
	}
	// Delete Mapping

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable() int productId) {
		try {
			productService.deleteProduct(productId);
			return new ResponseEntity<String>("Successfully deleted the product", HttpStatus.OK);
		} catch (ProductNotFoundException exception) {
			return new ResponseEntity<String>("Unable to purge please try again", HttpStatus.NOT_FOUND);
		}
	}
}
