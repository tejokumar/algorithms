package com.tejo;

public class NumberSwapXOR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n1 = 123;
		int n2 = 345;
		
		System.out.println("Before "+n1+" "+n2);
		// XORing twice any number gets the number back
		n1 = n1 ^ n2; // n1 XOR n2
		n2 = n1 ^ n2; // ( n1 XOR n2 ) XOR n2 = n1
		n1 = n1 ^ n2; // ( n1 XOR n2 ) XOR n1 = n2
		
		System.out.println("Before "+n1+" "+n2);

	}

}
