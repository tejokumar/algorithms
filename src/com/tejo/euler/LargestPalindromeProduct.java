package com.tejo.euler;

public class LargestPalindromeProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long maxProduct = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = i; j < 1000; j++) {
				long temp = i*j;
				if(isPalindrome(temp)){
					if(temp > maxProduct)
						maxProduct = temp;
				}
					
			}
		}
		System.out.println(maxProduct);
	}
	
	private static boolean isPalindrome(long number){
		String actualNumber = number +"";
		StringBuilder sb = new StringBuilder();
		for (int i = actualNumber.length() -1; i >= 0; i--) {
			sb.append(actualNumber.charAt(i));
		}
		if(actualNumber.equals(sb.toString()))
			return true;
		else
			return false;
	}

}
