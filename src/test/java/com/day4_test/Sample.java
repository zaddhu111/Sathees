package com.day4_test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.day4_pojo.Data;
import com.day4_pojo.Root;
import com.day4_pojo.Support;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {


	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Json_2207\\src\\test\\resources\\day4.json");

		ObjectMapper mapper = new ObjectMapper();

		List<Data> data = new ArrayList<Data>();
		
		Data d1 = new Data(7,"michael.lawson@reqres.in","Michael","Lawson","https://reqres.in/img/faces/7-image.jpg");
		Data d2 = new Data(8,"lindsay.ferguson@reqres.in","Lindsay","Ferguson","https://reqres.in/img/faces/8-image.jpg");
		Data d3 = new Data(9,"tobias.funke@reqres.in","Tobias","Funke","https://reqres.in/img/faces/9-image.jpg");
		Data d4 = new Data(10,"byron.fields@reqres.in","Byron","Fields","https://reqres.in/img/faces/10-image.jpg");
		Data d5 = new Data(11,"george.edwards@reqres.in","George","Edwards","https://reqres.in/img/faces/11-image.jpg");
		Data d6 = new Data(12,"rachel.howell@reqres.in","Rachel","Howell","https://reqres.in/img/faces/12-image.jpg");
		
		data.add(d1);
		data.add(d2);
		data.add(d3);
		data.add(d4);
		data.add(d5);
		data.add(d6);
		
		Support support = new Support("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
		
		Root r = new Root(2,6,12,2,data,support);
		
		mapper.writeValue(file, r);
	}
}
