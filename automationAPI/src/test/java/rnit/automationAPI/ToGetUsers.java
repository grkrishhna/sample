package rnit.automationAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ToGetUsers {

	@Test
	public void getUsers()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET, "?page=2");
		System.out.println("response body is "+response.prettyPrint());
		System.out.println("status line is "+response.statusLine());
		System.out.println("headers are "+response.headers());
		
	}
	
}
