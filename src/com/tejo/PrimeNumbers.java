package com.tejo;

import java.io.IOException;

public class PrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int number = Integer.parseInt(MyUtils.getString());
		for (int i = 2; i <= number; i++) {
			if(isPrime(i))
				System.out.println(i);
		}

	}
	
	public static boolean isPrime(int number){
		for (int i = 2; i < number; i++) {
			if(number%i == 0)
				return false;
		}
		return true;
	}

}
