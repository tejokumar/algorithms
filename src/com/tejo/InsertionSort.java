package com.tejo;


public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayInsert arr = new ArrayInsert(maxSize);
		arr.insert(123);
		arr.insert(12);
		arr.insert(12);
		arr.insert(12);
		arr.insert(12343);
		arr.insert(11);
		arr.insert(36);
		arr.insert(27);
		arr.insert(245);
		arr.insert(368);
		arr.insert(112);
		arr.insert(27);
		arr.insert(1);
		arr.insert(67);
		arr.insert(9999);
		arr.insert(27);
		arr.insert(236);
		arr.insert(120);
		
		System.out.println("*************** Before Sort ******************");
		arr.display();
		arr.insertionSort();
		//arr.insertionSortDesc();
		System.out.println("*************** After Sort ******************");
		arr.display();
		System.out.println("Finding number 27 :" + arr.find(27));
		System.out.println("Finding number 66 :" + arr.find(66));
		System.out.println("Random Number: " + Math.random());
	}
	
}
class ArrayInsert{
	private long[] a; //Array
	private int nElems; //Size
	
	public ArrayInsert(int max){
		this.a = new long[max];
		this.nElems = 0;
	}
	public void insert(long value){
		a[nElems] = value;
		nElems++;
	}
	public void display(){
		for (int i = 0; i < nElems; i++) {
			System.out.println(a[i]);
		}
	}
	public void insertionSort(){
		int out,in;
		for(out=1;out<nElems;out++){
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1]>temp){
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}
	
	public void insertionSortDesc(){
		int out,in;
		for(out=1;out<nElems;out++){
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1]<temp){
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}
	
	public int find(long number){
		int lowerBound = 0;
		int upperBound = nElems-1;
		int currIn;
		
		while(true){
			currIn = (lowerBound + upperBound)/2;
			if(a[currIn] == number)
				return currIn;
			else if(lowerBound > upperBound)
				return -1;
			else{
				if(a[currIn] < number)
					lowerBound = currIn +1;
				else
					upperBound = currIn -1;
			}
		}
	}
}

