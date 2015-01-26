package com.tejo.cc;

import java.util.Arrays;

public class FindAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 ="abcd";
		String s2 = "acdb";
		char[] chars = s1.toCharArray();
		Arrays.sort(chars);
		s1= new String(chars);
		
		chars = s2.toCharArray();
		Arrays.sort(chars);
		s2 = new String(chars);
		
		if(s1.equals(s2))
			System.out.println(true);
		else
			System.out.println(false);

	}

}
