package com.tejo;

public class MultiplyTwoBigNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] arr1 = {'5','3','6'};
		char[] arr2 = {'6','3','4'};
		int[] result = multipleString(arr1, arr2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
	public static int[] multipleString(char[] arr1, char[] arr2)
    {
         assert(arr1.length>0&&arr2.length>0);
         int[] result = new int[arr1.length+arr2.length];
         for(int i=arr2.length-1;i>=0;i--) {
          int carry = 0;
          int startIndex = arr2.length-1-i;
          for(int j=arr1.length-1;j>=0;j--){
        	  char c1 = arr1[j];
        	  char c2 = arr2[i];
           int temp = (arr2[i]-'0')*(arr1[j]-'0')
             +result[result.length-1-startIndex-(arr1.length-1-j)]+carry;
           result[result.length-1-startIndex-(arr1.length-1-j)] = temp%10;
           carry = temp/10;
          }
          int index = result.length-1-startIndex-arr1.length;
          while(carry!=0){
           int temp = result[index]+carry;
           result[index] = temp%10;
           carry = temp/10;
           index--;
          }
         }
         return result;       
    }

}
