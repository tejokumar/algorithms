package com.tejo;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxSize = 100;
		ArraySelect arr = new ArraySelect(maxSize);
		arr.insert(123);
		arr.insert(12);
		arr.insert(12343);
		arr.insert(11);
		arr.insert(36);
		arr.insert(27);
		arr.insert(245);
		arr.insert(368);
		arr.insert(112);
		arr.insert(1);
		arr.insert(67);
		arr.insert(9999);
		arr.insert(236);
		arr.insert(120);
		
		System.out.println("*************** Before Sort ******************");
		arr.display();
		//arr.selectionSort();
		arr.selectionSortDesc();
		System.out.println("*************** After Sort ******************");
		arr.display();
	}
	
}
class ArraySelect{
	private long[] a; //Array
	private int nElems; //Size
	
	public ArraySelect(int max){
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
	public void selectionSort(){
		int out,in,min;
		for(out=0;out<=nElems-1;out++){
			min = out;
			for(in=out+1;in<nElems;in++){
				if(a[in]<a[min])
					min = in;
			}
			swap(out,min);
		}
	}
	
	public void selectionSortDesc(){
		int out,in,min;
		for(out=0;out<=nElems-1;out++){
			min = out;
			for(in=out+1;in<nElems;in++){
				if(a[in]>a[min])
					min = in;
			}
			swap(out,min);
		}
	}
	private void swap(int one, int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
