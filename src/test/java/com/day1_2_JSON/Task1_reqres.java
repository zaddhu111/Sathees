package com.day1_2_JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task1_reqres {

	public static void main(String[] args) throws IOException, ParseException {

		// 1, Mention the path of the json
		FileReader reader = new FileReader(
				"C:\\Users\\Admin\\eclipse-workspace\\Json_2207\\src\\test\\resources\\reqres.json");

		// 2, Create the object for JSONParser Class
		JSONParser jsonParser = new JSONParser();

		// 3, Pass the json file to fetch values
		Object obj = jsonParser.parse(reader);

		// 4, Convert Object to JSONObject ---> classCast
		JSONObject j = (JSONObject) obj;

		Object data = j.get("data");
		System.out.println(data);
		System.out.println("---------------------------------------");

		JSONObject jData = (JSONObject) data;

		Object id = jData.get("id");
		System.out.println(id);

		Object email = jData.get("email");
		System.out.println(email);

		Object firstName = jData.get("first_name");
		System.out.println(firstName);

		Object lastName = jData.get("last_name");
		System.out.println(lastName);

		Object avatar = jData.get("avatar");
		System.out.println(avatar);

		System.out.println("***************************************");

		Object support = j.get("support");
		System.out.println(support);
		System.out.println("---------------------------------------");

		JSONObject jSupport = (JSONObject) support;

		Object url = jSupport.get("url");
		System.out.println(url);

		Object text = jSupport.get("text");
		System.out.println(text);

	}
}
