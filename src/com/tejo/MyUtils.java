package com.tejo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyUtils {
	public static String getString() throws IOException{
		System.out.println("Enter Value: ");
		System.out.flush();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(reader);
		String line = bReader.readLine();
		return line;
	}
}
