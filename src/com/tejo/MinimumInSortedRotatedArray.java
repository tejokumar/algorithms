package com.tejo;

public class MinimumInSortedRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2,3,4,5,6,7,1};
		int lower = 0;
		int upper = array.length -1;
		int current = lower;
		int min = array[lower];
		while(upper >= lower){
			current = (upper + lower)/2;
			
			if(min < array[current]){
				lower = current + 1;
			}else if(min > array[current]){
				min = array[current];
				upper = current-1;
			}
		}
		System.out.println(min);

	}

}
