package com.tejo;

public class NumberPowerOf2 {

	public static void main(String[] args) {
		System.out.println(isPowerOf2(100));
		System.out.println(isPowerOf2(128));
		System.out.println(getLog2(65));
	}
	
	public static boolean isPowerOf2(int number){
		if(((number-1) & number) != 0)
			return false;
		return true;
	}
	
	// This method gives integer part of log to base 2 of a number
	public static int getLog2(int number){
		int r=0;
		// >> divides number by 2
		while((number = number >> 1) > 0)
			r++;
		return r;
	}
}
