package com.tejo.euler;

public class NthPrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10001;
		int primeNumber = 2;
		int number = 2;
		while(n>0){
			if(isPrime(number)){
				primeNumber = number;
				n--;
			}
			number++;
		}
		System.out.println(primeNumber);

	}
	private static boolean isPrime(int number){
		for (int i = 2; i <=Math.sqrt(number); i++) {
			if(number%i == 0)
				return false;
		}
		return true;
	}

}
