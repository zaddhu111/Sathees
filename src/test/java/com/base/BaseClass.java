package com.base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification reqSpec;
	Response response;

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
	
	public void addHearders(Headers header) {
		reqSpec = RestAssured.given().headers(header);
	}

	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}
	
	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}
	
	public void basicAuth(String username, String password ) {
		reqSpec = reqSpec.auth().preemptive().basic(username, password);
	}

	public Response requestType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endpoint);
			break;
		case "POST":
			response = reqSpec.post(endpoint);
			break;
		case "PUT":
			response = reqSpec.put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}
	
	public int getResponseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	
	public String getReqBodyAsString(Response response) {
		String asString = response.asString();
		return asString;	
	}
	
	
	public String getReqBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}
	
	
	
	

}
