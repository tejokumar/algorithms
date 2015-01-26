package com.tejo.euler;

public class SmallestMultiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub 6,8,7,9,10
		
		int number=20;
		while(true){
			//if(number%6 == 0 && number%7 == 0 && number%8 == 0 && number%9 == 0 && number%10 ==0){
			if(number%11 == 0 && number%12 == 0 && number%13 == 0 && number%14 == 0 && number%15 == 0 && number%16 == 0 && number%17 ==0 && number%18 ==0 && number%19 ==0 && number%20 ==0){
				System.out.println(number);
				break;
			}
			number++;
		}

	}

}
