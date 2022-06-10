package rnit.automationAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ToGetSingleUserData {

	@Test
	public void singleUser()
	{
		RestAssured.baseURI="https://reqres.in/api/users/";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET, "2");
		System.out.println("Body is "+response.prettyPrint());
		int statusCode=response.statusCode();
		System.out.println("status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine=response.statusLine();
		System.out.println("status line is "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
}
