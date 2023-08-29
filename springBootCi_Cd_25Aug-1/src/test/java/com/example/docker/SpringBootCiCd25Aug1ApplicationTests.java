package com.example.docker;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
class SpringBootCiCd25Aug1ApplicationTests {

	@org.junit.jupiter.api.Test
	void contextLoads() {
			baseURI = "http://localhost:9090";
	    
	    given()
	        .when().get("/test")
	        .then()
	        .statusCode(200)
	        .log().all().body(equalTo("Test Pass"));
	}

}
