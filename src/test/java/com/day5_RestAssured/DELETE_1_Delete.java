package com.day5_RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DELETE_1_Delete {

	public static void main(String[] args) {
		RequestSpecification reqSpec;
		
		//1, Initialize REST assured
		reqSpec = RestAssured.given();
		
		//2, Param..,Headers,Auth,reqBody--->Header
		reqSpec = reqSpec.header("Content-Type","application/json");
		
		//3, Mention req method type
		Response response = reqSpec.delete("https://reqres.in/api/users/2");
		
		//Get status code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		//Get the Body(as a Thorough explanation we create this)
		ResponseBody body = response.getBody();
		
		
		//asString
		String asString = response.asString();
		System.out.println(asString);
		
		//asPrettyString
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		
		
		
		
		
	}
}
