package com.tejo;

import java.util.Stack;

public class Knapsack {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		KnapSackInternal ks = new KnapSackInternal();
		ks.knipSack(20);
	}
	

}

class KnapSackInternal{
	private Stack<Integer> myStack = new Stack<Integer>();
	private int[] myArray = new int[100];
	private int nElems;
	public KnapSackInternal(){
		myArray[0] = 11;
		myArray[1] = 8;
		myArray[2] = 7;
		myArray[3] = 6;
		myArray[4] = 5;
		
		nElems = 5;
	}
	
	public  void displayStack(){
		for (int i = 0; i < myStack.size(); i++) {
			System.out.println(myStack.get(i));
		}
	}
	public  void knipSack(long target){
		int i = 0;
		
		while(true){
			if(i == nElems)
				break;
			myStack.push(myArray[i]);
			if(doSelection(i, target))
			{
				displayStack();
				break;
			}else
				i++;
				
		}
	}
	public  boolean doSelection(int index,long target){
		if(myArray[index] == target)
			return true;
		else if(index == nElems -1){
			myStack.pop();
			return false;
		}
		/*}else if(myArray[index] > target){
			myStack.pop();
			int nextIndex = index +1;
			myStack.push(myArray[nextIndex]);
			return doSelection(nextIndex, target-myArray[index]);
		}*/
		return false;
			
	}
}
