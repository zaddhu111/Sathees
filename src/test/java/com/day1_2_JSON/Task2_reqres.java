package com.day1_2_JSON;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task2_reqres {

	public static void main(String[] args) throws IOException, ParseException {

		// 1, Mention the path of the json
		FileReader reader = new FileReader(
				"C:\\Users\\Admin\\eclipse-workspace\\Json_2207\\src\\test\\resources\\reqres2.json");

		// 2, Create the object for JSONParser Class
		JSONParser jsonParser = new JSONParser();

		// 3, Pass the json file to fetch values
		Object obj = jsonParser.parse(reader);

		// 4, Convert Object to JSONObject ---> classCast
		JSONObject j = (JSONObject) obj;
		
		Object data = j.get("data");
		
		JSONArray a = (JSONArray) data;
		
		for (int i = 0; i < a.size(); i++) {
			Object o = a.get(i);
			JSONObject j1 = (JSONObject) o;
			
			Object id = j1.get("id");
			System.out.println(id);
			
			Object email = j1.get("email");
			System.out.println(email);
			
			Object fName = j1.get("first_name");
			System.out.println(fName);
			
			Object lName = j1.get("last_name");
			System.out.println(lName);
			
			Object avatar = j1.get("avatar");
			System.out.println(avatar);
			
		}
		
		
		
		
		
	}
}
