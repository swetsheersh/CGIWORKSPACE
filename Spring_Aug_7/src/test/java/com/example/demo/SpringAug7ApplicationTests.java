package com.example.demo;


import static io.restassured.RestAssured.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
class SpringAug7ApplicationTests {

	@Test
	void contextLoads() {
		baseURI="http://localhost:8080//getall";
		given().get().then().statusCode(200);
	}

}
