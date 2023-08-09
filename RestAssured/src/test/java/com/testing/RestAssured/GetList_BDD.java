package com.testing.RestAssured;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;


public class GetList_BDD {
	@Test
	public void getListBDD() {
		baseURI="https://reqres.in/api/users?page=2";
		System.out.println(given().get().body().asString());
		System.out.println(given().get().statusCode());
		given().get().then().statusCode(200).body("data[0].first_name", equalTo("George"));
	}
}
