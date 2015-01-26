package com.tejo;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayMerge arr = new ArrayMerge(maxSize);
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
		arr.mergeSort();
		//arr.insertionSortDesc();
		System.out.println("*************** After Sort ******************");
		arr.display();

	}

}
class ArrayMerge{
	private long[] myArray;
	private int nElems;
	
	public ArrayMerge(int max){
		myArray = new long[max];
		nElems = 0;
	}
	public void insert(long value)    // put element into array
    {
		myArray[nElems] = value;      // insert it
		nElems++;                      // increment size
    }
	 //-----------------------------------------------------------
 public void display()             // displays array contents
    {
    for(int j=0; j<nElems; j++)    // for each element,
       System.out.print(myArray[j] + " ");  // display it
    System.out.println("");
    }
 	public void mergeSort(){
 		long[] workSpace = new long[nElems];
 		recMergeSort(workSpace,0,nElems-1);
 	}
 	public void recMergeSort(long[] workspace,int lowerBound,int upperBound){
 		if(lowerBound == upperBound)
 			return;
 		else{
 			int mid = (lowerBound + upperBound)/2;
 			recMergeSort(workspace, lowerBound, mid);
 			recMergeSort(workspace, mid+1, upperBound);
 			merge(workspace,lowerBound,mid+1,upperBound);
 		}
 	}
 	
 	public void merge(long[] workspace, int lowPtr,int highPtr,int upperBound){
 		int j =0;
 		int lowerBound = lowPtr;
 		int mid = highPtr - 1;
 		int n = upperBound - lowerBound + 1;
 		
 		while(lowPtr <= mid && highPtr <= upperBound){
 			if(myArray[lowPtr] < myArray[highPtr])
 				workspace[j++] = myArray[lowPtr++];
 			else
 				workspace[j++] = myArray[highPtr++];
 		}
 		while(lowPtr <= mid)
 			workspace[j++] = myArray[lowPtr++];
 		while(highPtr <= upperBound)
 			workspace[j++] = myArray[highPtr++];
 		for(j = 0;j<n;j++){
 			myArray[lowerBound + j] = workspace[j];
 		}
 	}
}
