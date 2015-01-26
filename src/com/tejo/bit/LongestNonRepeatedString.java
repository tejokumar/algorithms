package com.tejo.bit;

public class LongestNonRepeatedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "qwertyuiopqwertyuiopa";
		int n = s.length();
		int number = 0;
		int tempNumber = 0;
		int init = 0;
		int max = 0;
		String maxString = "";
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			number = number | 1 << (c - 'a'); // Capture all characters in a number
			if(tempNumber == number){ // Duplicate character found
				if(i-init > max){
					max = i-init;
					maxString = s.substring(init, i);
				}
				while(s.charAt(init) != c){ //For repeated characters move to next different char
					init++;
				}
				init++;
			}
			tempNumber = number;
		}
		if(n-init > max){
			max = n-init;
			maxString = s.substring(init, n);
		}
		System.out.println(max);
		System.out.println(maxString);
		int mask = ~(1<<3);// 00000100 -> 11111011
		//System.out.println(n);
	}

}
