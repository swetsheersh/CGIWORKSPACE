package com.testing.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import com.github.cliftonlabs.json_simple.JsonObject;

import io.restassured.http.ContentType;

public class PatchUpdate {
	@Test
	public void patchupd() {
		JsonObject ob= new JsonObject();
		ob.put("name", "hello");
		baseURI="https://reqres.in/api/users/2";
		  given().header("Content-Type","application/json")
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON).body(ob.toJson())
		  .when().put().then().statusCode(200).body("name", equalTo("hello"))
		  .log().all();
	}
}
