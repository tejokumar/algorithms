package com.tejo.bit;

public class NextAndPreviousWithSame1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number = 100;
		System.out.println(getNextNumber(number));
		System.out.println(getPreviousNumber(number));

	}
	
	public static boolean getBit(int n,int index){
		return ((1<<index) & n) > 0;
	}
	
	public static int setBit(int n, int index, boolean value){
		if(value){
			return n | (1<<index);
		}else{
			int mask = ~(1<<index);
			return n & mask;
		}
	}
	
	public static int getNextNumber(int number){
		int index = 0;
		int onesCount = 0;
		//Get first 1
		while(!getBit(number, index))index++;
		
		//Turn on next 0
		while(getBit(number, index)){
			index++;
			onesCount++;
		}
		
		number = setBit(number, index, true);
		
		//Turn off previous 1
		index--;
		number = setBit(number, index, false);
		onesCount--;
		
		//Set zeros
		for (int i = index-1; i >= onesCount; i--) {
			number = setBit(number, index, false);
		}
		
		//Set 1s
		for (int i = onesCount-1; i >=0; i--) {
			number = setBit(number, index, true);
		}
		return number;
	}
	
	public static int getPreviousNumber(int number){
		int index = 0;
		int zerosCount = 0;
		//Get first 0
		while(getBit(number, index))index++;
		
		//Turn off next 1
		while(!getBit(number, index)){
			index++;
			zerosCount++;
		}
		
		number = setBit(number, index, false);
		
		//Turn on previous 0
		index--;
		number = setBit(number, index, true);
		zerosCount--;
		
		//Set 1s
		for (int i = index-1; i >= zerosCount; i--) {
			number = setBit(number, index, true);
		}
		
		//Set 0s
		for (int i = zerosCount-1; i >=0; i--) {
			number = setBit(number, index, false);
		}
		return number;
	}

}
