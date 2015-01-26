package com.tejo.euler;

public class LargestPrimeFactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
		long number = 600851475143l;
		long largestPrime=0;
		for (long i = 3; i < number; i++) {
			if(number%i == 0){
				number /= i;
				if(i*i > number)
					largestPrime = number;
			}
		}
		System.out.println(largestPrime);
		System.out.println(System.currentTimeMillis() - currentTime);
	}
	
}
