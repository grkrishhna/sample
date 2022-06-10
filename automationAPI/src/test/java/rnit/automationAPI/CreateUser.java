package rnit.automationAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	@Test
	public void toPostData()
	{
		RestAssured.baseURI="https://reqres.in/api/";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");
		httpRequest.header("Content-Type", "application/json; charset=utf-8");
		httpRequest.body(requestParams.toJSONString());
		Response response=httpRequest.request(Method.POST, "users");
		String responseBody=response.getBody().asString();
		System.out.println("body is "+responseBody);
		int statusCode=response.statusCode();
		System.out.println("response code is "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
	}
	
}
