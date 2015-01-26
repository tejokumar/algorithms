package com.tejo.euler;

public class Multiples3And5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 3;
		for (int i = 5; i < 1000; i++) {
			if(i%3 == 0 || i%5 == 0)
				sum += i;			
		}
		System.out.println("Sum is "+sum);
	}	

}
