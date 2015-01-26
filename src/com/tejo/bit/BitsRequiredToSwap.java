package com.tejo.bit;

public class BitsRequiredToSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(bitsSwapRequired(10, 12));

	}
	//XOR will swap bits. If both numbers have same bits, there is nothing to swap
	public static int bitsSwapRequired(int a,int b){
		int count =0;
		for (int i = a^b; i != 0; i = i>>1) {
			count += i&1;
		}
		return count;
	}

}
