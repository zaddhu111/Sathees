package com.day6_BasicAuth;

import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.response.Response;

public class BasicAuth extends BaseClass {

	@Test
	public void login() {

		// 1, Header
		addHeader("accept", "application/json");

		// 2,BasicAuth
		basicAuth("zaddhu111@gmail.com", "Sathees@123");

		// 3, Method type
		Response response = requestType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int responseCode = getResponseCode(response);
		System.out.println(responseCode);

		String reqBodyAsPrettyString = getReqBodyAsPrettyString(response);
		System.out.println(reqBodyAsPrettyString);

	}
}
