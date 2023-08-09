package com.testing.RestAssured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteUser {
	@Test
	public void delUser() {
		baseURI="https://reqres.in/api/users/2";
		given().delete().then().statusCode(204).log().all();
		
	}
}
