package com.testing.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetListUser {
	@Test
	public void getList() {
		
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("status code: "+res.getStatusCode());
		System.out.println("Response Time: "+res.getTime());
		System.out.println("Response Body: "+res.getBody().asString());
		System.out.println("Header: "+res.getHeader("content-type"));
		System.out.println("Status Line: "+res.getStatusLine());
		System.out.println(res.body().asString());
	}
	
}
