package com.tejo.bit;

public class UniqueCharactersInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcda";
		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - 'a';
			if((number & (1<<n)) > 0){
				System.out.println("Duplicate Found");
				break;
			}
			number = number | (1<<n);	
		}
	}

}
