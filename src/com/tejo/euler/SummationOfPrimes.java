package com.tejo.euler;

public class SummationOfPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberLimit = 2000000;
		long sum = 0;
		for (int i = 2; i < numberLimit; i++) {
			if(isPrime(i))
				sum +=i;
		}
		System.out.println(sum);

	}
	private static boolean isPrime(int number){
		for (int i = 2; i <=Math.sqrt(number); i++) {
			if(number%i == 0)
				return false;
		}
		return true;
	}

}
