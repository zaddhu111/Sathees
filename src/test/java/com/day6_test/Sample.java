package com.day6_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.day6_pojo.Login_Output_pojo;

import io.restassured.response.Response;

public class Sample extends BaseClass {

	@Test
	public void login() {
		// 1, Header
		addHeader("accept", "application/json");

		// 2, BasicAuth
		basicAuth("zaddhu111@gmail.com", "Sathees@123");

		// 3, Method Type
		Response response = requestType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200, "Verify status code");

		Login_Output_pojo output_pojo = response.as(Login_Output_pojo.class);
		String first_name = output_pojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "SatheesKumar", "Verify first name");

	}
}
