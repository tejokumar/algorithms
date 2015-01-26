package com.tejo.bit;

public class ReplaceBetweenBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 16 - 10000
		// 3 - 11
		// Replace bits 2nd and 3rd from right
		// value should be 10110, which is equal to 22
		System.out.println(updateBits(16,3,1,2));

	}
	
	public static int updateBits(int n,int m, int i, int j){
		int max = ~0;
		//count i and j from right
		//1 through position j and 0s after that
		int left = max - ((1<<j)-1);
		
		//1s after position i
		int right = ((1<<i)-1);
		
		//1s with 0s between i and j
		int mask = left | right;
		
		//clear i through j and OR m. Move m by i times so that bits match
		return (n & mask) | (m << i);
	}
}
