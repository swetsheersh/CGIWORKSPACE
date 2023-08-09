package com.testing.RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.github.cliftonlabs.json_simple.JsonObject;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;

public class PutUser {
  @Test
  public void f() {
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
}
