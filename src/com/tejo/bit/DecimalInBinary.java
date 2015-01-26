package com.tejo.bit;

public class DecimalInBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(binaryformat("2.5")); 
		System.out.println(binaryformat("2.4")); // Displays error as the binary part is more than 32 chars

	}
	
	public static String binaryformat(String decimal){
		String strInt = decimal.substring(0, decimal.indexOf("."));
		String strDecimal = decimal.substring(decimal.indexOf("."));
		
		int integer = Integer.parseInt(strInt);
		double decimalValue = Double.parseDouble(strDecimal);
		String intPart = new String();
		while(integer > 0){
			intPart= (integer%2) + intPart;
			integer = integer >> 1;
		}
		
		StringBuffer decPart = new StringBuffer();
		while(decimalValue > 0){
			if(decPart.length() > 32)return "ERROR";
			double r = decimalValue * 2;
			if(r > 1){
				decPart.append(1);
				decimalValue = Double.parseDouble((r+"").substring((r+"").indexOf(".")));
				//decimalValue = r-1.0;//Adding extra zeros and 1 at the end. This is creating error results
			}else{
				decPart.append(0);
				decimalValue = r;
			}
		}
		
		return intPart + "."+decPart.toString();
	}

}
