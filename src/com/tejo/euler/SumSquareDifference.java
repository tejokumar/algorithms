package com.tejo.euler;

public class SumSquareDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 100;
		int sumOfNumbers = n * (n + 1)/2;
		int sumOfSquares = n * (n + 1) * (2*n + 1)/6;
		System.out.println(Math.pow(sumOfNumbers, 2) - sumOfSquares);

	}

}
