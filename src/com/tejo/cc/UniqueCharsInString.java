package com.tejo.cc;

public class UniqueCharsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "abcada";
		
		System.out.println(isUniqueBitwise(string));
		System.out.println(removeDuplicates(string));
	}
	
	public static boolean isUniqueBitwise(String str){
		
		int check = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((check & (1<<val)) > 0)return false;
			check = check | (1<<val);
		}
		return true;
	}
	public static boolean isUnique(String str){
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(i<str.length()-1 && str.indexOf(c, i+1) > i)
				return false;
		}
		return true;
	}
	
	public static String removeDuplicates(String str){
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int nextIndex = i<str.length()-1 ? str.indexOf(c, i+1) : -1;
			if(nextIndex > i){
				i--;
				if(nextIndex == str.length() -1)
					str = str.substring(0, nextIndex);
				else
					str = str.substring(0, nextIndex) + str.substring(nextIndex+1);
			}	
		}
		return str;
	}

}
