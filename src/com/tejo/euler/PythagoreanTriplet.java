package com.tejo.euler;

public class PythagoreanTriplet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int total = 1000;
		int product = 1;
		int a =0,b=0,c=0;
		for (int i = 0; i < total/3; i++) {
			a = i;
			for (int j = i+1; j < total/2; j++) {
				b = j;
				c = 1000 - a -b;
				if(c*c == (a*a + b*b))
					product = a*b*c;
			}
		}
		System.out.println(product);

	}

}
