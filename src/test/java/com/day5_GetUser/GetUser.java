package com.day5_GetUser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetUser extends BaseClass {

	//TestNG maven dependancy updated in pom.xml
	
	@Test
	public void getUser() throws ParseException {
		//1, Header
		addHeader("Content-Type", "application/json");
		
		//2, Req type
		Response response = requestType("GET", "https://reqres.in/api/users?page=2");
		
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		
		Assert.assertEquals(responseCode, 200, "Verify statusCode");
		
		String reqBodyAsPrettyString = getReqBodyAsPrettyString(response);
		System.out.println(reqBodyAsPrettyString);
		
		/*
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(reqBodyAsPrettyString);
		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get("data");
		
		JSONArray a = (JSONArray) object;
		Object object2 = a.get(0);
		JSONObject jsonObject2 = (JSONObject) object2;
		Object object3 = jsonObject2.get("first_name");
		String firstName = (String) object3;
		*/
		
		//Instead of using above logic we can use simply apply below logic
		JsonPath jsonPath = response.jsonPath();
		Object object = jsonPath.get("data[0].first_name");
		String firstName = (String) object;
		System.out.println(firstName);
		
		Assert.assertEquals(firstName, "Michael", "Verify firstName");
	}
}