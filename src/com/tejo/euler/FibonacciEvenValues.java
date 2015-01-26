package com.tejo.euler;

public class FibonacciEvenValues {

	public static void main(String[] args) {
		long prev = 1;
		long current = 1;
		long next;
		long evensum = 0;
		long residualValue = 4000000;
		while(current<=residualValue){
			next = prev + current;
			prev = current;
			current = next;
			if(current%2 == 0 && current <=residualValue)
				evensum +=current;
		}
		System.out.println(evensum);
	}
}
