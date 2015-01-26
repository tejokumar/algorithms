package com.tejo.algos;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(getFibRec(10));
		System.out.println(getFibLoop(10));
	}
	
	// Using Recursive Method
	public static int getFibRec(int n){
		if(n<0)return -1;
		if(n==0) return 0;
		if(n==1)return 1;
		return getFibRec(n-1) + getFibRec(n-2);
	}
	
	//Using loop
	public static int getFibLoop(int n){
		if(n<0)return -1;
		if(n==0) return 0;
		int previous=1,current=1;
		for (int i = 3; i <= n; i++) {
			int next = previous+current;
			previous=current;
			current=next;
		}
		return current;
	}
}
