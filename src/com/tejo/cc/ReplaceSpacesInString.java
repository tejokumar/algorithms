package com.tejo.cc;

public class ReplaceSpacesInString {

	/**
	 * @param args
	 */
	//Replace a space in string with %20
	public static void main(String[] args) {
		String str = "abc def ghi";
		//str = str.replaceAll(" ", "%20");
		System.out.println(str);
		
		char[] chars = str.toCharArray();
		int spaceCount =0;
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] == ' ')
				spaceCount++;
		}
		int newLength = chars.length + spaceCount * 2;
		char[] newchars = new char[newLength];
		for (int i = chars.length -1; i >=0 ; i--) {
			if(chars[i]==' '){
				newchars[newLength-1] = '0';
				newchars[newLength-2] = '2';
				newchars[newLength-3] = '%';
				newLength = newLength -3;
			}else{
				newchars[newLength-1] = chars[i];
				newLength = newLength -1;
			}
		}
		
		str = new String(newchars);
		System.out.println(str);
	}

}
