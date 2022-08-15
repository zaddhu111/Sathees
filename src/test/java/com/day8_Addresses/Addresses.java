package com.day8_Addresses;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.day8_pojo.Login_Output_pojo;
import com.day8_pojo.UpdateAddress_Input_pojo;
import com.day8_pojo.UpdateAddress_Output_pojo;
import com.day8_Endpoints.Endpoints;
import com.day8_pojo.AddAddress_Input_pojo;
import com.day8_pojo.AddAddress_Output_pojo;
import com.day8_pojo.DeleteAddress_Input_pojo;
import com.day8_pojo.GetAddress_Output_pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Addresses extends BaseClass {
	String logtoken;
	String address_id;

	@Test(priority = 1)
	public void login() {
		// 1, Header
		addHeader("accept", "application/json");

		// 2, Basic Auth
		basicAuth("zaddhu111@gmail.com", "Sathees@123");

		// Method type
		Response response = requestType("POST", Endpoints.POSTMANBASICAUTHLOGIN);

		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200, "Verify response code");

		Login_Output_pojo output_pojo = response.as(Login_Output_pojo.class);
		// import from day6_pojo.Login_Output_pojo
		String first_name = output_pojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "SatheesKumar", "Verify first name");

		logtoken = output_pojo.getData().getLogtoken();
	}

	@Test(priority = 2)
	public void addAddress() {
		// 1, Header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHearders(headers);

		// 2, Payload
		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo("SatheesKumar", "Murugan", "8928828129",
				"SilverKey", 33, 123, 108, "600097", "Chennai", "Home");
		addBody(addAddress_Input_pojo);

		// 3, reqType
		Response response = requestType("POST", Endpoints.ADDADDRESS);

		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200, "Verify response code");

		String reqBodyAsPrettyString = getReqBodyAsPrettyString(response);
		System.out.println(reqBodyAsPrettyString);

		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);
		String message = addAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address added successfully", "Verify successful message");

		int add = addAddress_Output_pojo.getAddress_id();
		address_id = String.valueOf(add);
	}

	@Test(priority = 3)
	public void updateAddress() {

		// 1, Header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHearders(headers);

		// 2, ReqType
		UpdateAddress_Input_pojo updateAddress_Input_pojo = new UpdateAddress_Input_pojo(address_id, "SatheesKumar",
				"Murugan", "8928828129", "SilverKey", 33, 123, 108, "600097", "Chennai", "Home");

		addBody(updateAddress_Input_pojo);

		// 3,ReqType
		Response response = requestType("PUT", Endpoints.UPDATEADDRESS);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);

		String reqBodyAsPrettyString = getReqBodyAsPrettyString(response);
		System.out.println(reqBodyAsPrettyString);

		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String message = updateAddress_Output_pojo.getMessage();
		Assert.assertEquals(message, "Address updated successfully", "Verify updated address successfully");
	}

	@Test(priority = 4)
	public void deleteAddress() {
		// 1, Header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHearders(headers);

		// 2, Payload
		DeleteAddress_Input_pojo deleteAddress_Input_pojo = new DeleteAddress_Input_pojo(address_id);
		addBody(deleteAddress_Input_pojo);

		// 3, ReqType
		Response response = requestType("DELETE", Endpoints.DELETEADDRESS);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);

		String reqBodyAsPrettyString = getReqBodyAsPrettyString(response);
		System.out.println(reqBodyAsPrettyString);

		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String message = updateAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address deleted successfully", "Verify delete address successfully");

	}

	@Test(priority = 5)
	public void getAddress() {

		// 1, Header
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHearders(headers);

		// 2,ReqType
		Response response = requestType("GET", Endpoints.GETADDRESS);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);

		String reqBodyAsPrettyString = getReqBodyAsPrettyString(response);
		System.out.println(reqBodyAsPrettyString);

		GetAddress_Output_pojo getAddress_Output_pojo = response.as(GetAddress_Output_pojo.class);
		String message = getAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "OK", "Verify get address successfully");

	}

}
