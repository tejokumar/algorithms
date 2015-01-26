package com.tejo.bit;

public class SwapOddAndEvenBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int swapOddAndEvenBits(int number){
		//Mask odd bits and shift right. Mask even bits and shift left
		int oddMask = 0xaaaaaaaa; //......101010101
		int evenMask = 0x55555555; //.......10101010
		
		return ((number & oddMask) >> 1) | ((number & evenMask) << 1);
	}

}
