package com.testing.RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.github.cliftonlabs.json_simple.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllTest {

  @Test
  public void delUserTest() {
	  baseURI="https://reqres.in/api/users/2";
	  given().delete().then().statusCode(204).log().all();
  }

  @Test
  public void fTest() {
	  JsonObject ob=new JsonObject();
	  ob.put("name", "hello");
	  ob.put("job", "developer");
	  baseURI="https://reqres.in/api/users/2";
	  given().header("Content-Type","application/json")
	  .contentType(ContentType.JSON)
	  .accept(ContentType.JSON).body(ob.toJson())
	  .when().put().then().statusCode(200).body("name", equalTo("hello"))
	  .log().all();
  }

  @Test
  public void getListTest() {
	  	Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("status code: "+res.getStatusCode());
		System.out.println("Response Time: "+res.getTime());
		System.out.println("Response Body: "+res.getBody().asString());
		System.out.println("Header: "+res.getHeader("content-type"));
		System.out.println("Status Line: "+res.getStatusLine());
		System.out.println(res.body().asString());
  }

  @Test
  public void getListBDDTest() {
	  	baseURI="https://reqres.in/api/users?page=2";
		System.out.println(given().get().body().asString());
		System.out.println(given().get().statusCode());
		given().get().then().statusCode(200).body("data[0].first_name", equalTo("George"));
  }

  @Test
  public void patchupdTest() {
	  	JsonObject ob= new JsonObject();
		ob.put("name", "hello");
		baseURI="https://reqres.in/api/users/2";
		  given().header("Content-Type","application/json")
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON).body(ob.toJson())
		  .when().put().then().statusCode(200).body("name", equalTo("hello"))
		  .log().all();
  }

  @Test
  public void postUserTest() {
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
