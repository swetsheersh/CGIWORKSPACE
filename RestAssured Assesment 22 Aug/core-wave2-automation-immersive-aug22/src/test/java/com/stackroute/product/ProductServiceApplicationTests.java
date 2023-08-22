package com.stackroute.product;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.cliftonlabs.json_simple.JsonObject;

import io.restassured.http.ContentType;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class ProductServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	// @Test(priority = 1)
	public void postUserTest() {
		// Response res=RestAssured.post("", new String("hello"));
		JsonObject req = new JsonObject();
		req.put("productId", 5);
		req.put("productName", "OnePlus");
		req.put("productDescription", "OnePlus 10R");
		req.put("productPrice", 44000.25);
		baseURI = "http://localhost:8082/productservice";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJson()).when().post("/addProduct").then().statusCode(201).body("productId", equalTo(5))
				.and().body("productName", equalTo("OnePlus")).and().body("productDescription", equalTo("OnePlus 10R"))
				.and().body("productPrice", equalTo(new Float(44000.25))).log().all();
		;
	}

	@Test
	@Order(2)
	// @Test(priority = 2)
	public void getByIdUserTest() {
		// Response res=RestAssured.post("", new String("hello"));
		baseURI = "http://localhost:8082/productservice";
		given().when().get("/5").then().statusCode(200).body("productId", equalTo(5)).and()
				.body("productName", equalTo("OnePlus")).and().body("productDescription", equalTo("OnePlus 10R")).and()
				.body("productPrice", equalTo(new Float(44000.25))).log().all();
		;
	}

	@Test
	@Order(3)
	// @Test(priority = 3)
	public void putUserTest() {
		// Response res=RestAssured.post("", new String("hello"));
		JsonObject req = new JsonObject();
		req.put("productId", 5);
		req.put("productName", "OnePlus");
		req.put("productDescription", "OnePlus 10R 5G 228GB");
		req.put("productPrice", 44000.25);
		baseURI = "http://localhost:8082/productservice/5";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJson()).when().put().then().statusCode(200).log().all();
		;
	}

	@Test
	@Order(4)
	// @Test(priority = 4)
	public void getAllUserTest() {
		baseURI = "http://localhost:8082/productservice";

		given().when().get("/products").then().statusCode(200).body("[0].productId", equalTo(5))
				.body("[0].productName", equalTo("OnePlus"))
				.body("[0].productDescription", equalTo("OnePlus 10R 5G 228GB"))
				.body("[0].productPrice", equalTo(44000.25f)).log().all();
	}

	@Test
	@Order(5)
	// @Test(priority = 5)
	public void deleteProductTest() {
		baseURI = "http://localhost:8082/productservice";

		given().when().delete("/5").then().statusCode(200).body(equalTo("Successfully deleted the product")).log()
				.all();
	}

}
