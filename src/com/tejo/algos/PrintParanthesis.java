package com.tejo.algos;

public class PrintParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int number = 3;
		char[] arrr = new char[number * 2];
		printPar(3, 3, arrr, 0);

	}
	
	public static void printPar(int left,int right,char[] arr,int count){
		if(left <0 || right < left)return;
		if(left == 0 && right == 0){
			System.out.println(arr);
		}else{
			if(left > 0){
				arr[count] = '(';
				printPar(left-1, right, arr, count+1);
			}
			if(right > 0){
				arr[count] = ')';
				printPar(left, right-1, arr, count+1);
			}
		}
	}

}
