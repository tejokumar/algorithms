package com.tejo.euler;

public class PowerDigitSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(getPowerValue(1000));
	}
	
	private static String getPowerValue(int n){
		if(n==1)
			return 2+"";
		return sum(getPowerValue(n-1),getPowerValue(n-1));
	}
	
	private static String sum(String num1,String num2){
		String sumValue = "";
		int carry = 0;
		String bigString = "";
		String smallString = "";
		if(num1.length() > num2.length()){
			bigString = num1;
			smallString = num2;
		}else{
			bigString = num2;
			smallString = num1;
		}
			
		int startIndex = 0;
		int tempSum =0;
		while(startIndex < smallString.length()){
			tempSum = Integer.parseInt(bigString.charAt(bigString.length()-1-startIndex)+"") + Integer.parseInt(smallString.charAt(smallString.length()-1-startIndex)+"") + carry;
			sumValue = tempSum%10 + sumValue;
			carry = tempSum/10;
			startIndex++;
		}
		if(bigString.length() > startIndex){
			tempSum = Integer.parseInt(bigString.substring(0,bigString.length()-startIndex)+"") + carry;
			sumValue = tempSum + sumValue;
		}else
			sumValue = carry + sumValue;
		
		return sumValue;
	}

}
