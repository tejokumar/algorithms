package com.tejo;

public class InsertionSortObjects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayObjects arr = new ArrayObjects(maxSize);
		arr.insert("Tejo","Kumar");
		arr.insert("Mangesh","Phadke");
		arr.insert("Divyesh","Jain");
		arr.insert("Younus","Mohammed");
		arr.insert("Chaitali","Gohel");
		
		
		System.out.println("*************** Before Sort ******************");
		arr.display();
		//arr.bubbleSort();
		arr.insertionSort();
		System.out.println("*************** After Sort ******************");
		arr.display();

	}

}

class Person{
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public Person(String first,String last){
		this.firstName = first;
		this.lastName = last;
	}
}

class ArrayObjects{
	private Person[] a;
	private int nElems;
	
	public ArrayObjects(int max){
		this.a = new Person[max];
		this.nElems = 0;
	}
	public void insert(String first,String last){
		a[nElems] = new Person(first,last);
		nElems++;
	}
	public void display(){
		for (int i = 0; i < nElems; i++) {
			System.out.println(a[i].getLastName());
		}
	}
	
	public void insertionSort(){
		int out,in;
		for(out=1;out<nElems;out++){
			Person temp = a[out];
			in = out;
			while(in>0 && a[in-1].getLastName().compareTo(temp.getLastName()) > 0){
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}
}