package com.day3_test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.day3_pojo.*;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Json_2207\\src\\test\\resources\\reqres2.json");

		ObjectMapper mapper = new ObjectMapper();

		Root e = mapper.readValue(file, Root.class);

		int page = e.getPage();
		System.out.println(page);

		int per_page = e.getPer_page();
		System.out.println(per_page);

		int total = e.getTotal();
		System.out.println(total);

		int total_pages = e.getTotal_pages();
		System.out.println(total_pages);

		ArrayList<Datum> d = e.getData();
		for (Datum s : d) {
			System.out.println(s.getId());
			System.out.println(s.getEmail());
			System.out.println(s.getFirst_name());
			System.out.println(s.getLast_name());
			System.out.println(s.getAvatar());

		}
	}
}
