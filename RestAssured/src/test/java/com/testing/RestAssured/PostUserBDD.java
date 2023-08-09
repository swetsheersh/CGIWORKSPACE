package com.testing.RestAssured;

import org.testng.annotations.Test;

import com.github.cliftonlabs.json_simple.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostUserBDD {
	@Test
	public void postUser() {
		//Response res=RestAssured.post("", new String("hello"));
		JsonObject req=new JsonObject();
		req.put("name","swet");
		req.put("job", "developer");
		baseURI="https://reqres.in/api";
		given().body(req.toJson())
		.when().post("/user")
		.then().statusCode(201);
		
				
	}
}
