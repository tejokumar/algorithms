package com.tejo.cc;

public class StringRemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringRemoveDuplicates srd = new StringRemoveDuplicates();
		String s = "onceuponatimeinindia";
		char[] strArray = s.toCharArray();
		srd.removeDuplicates(strArray);
		System.out.println(strArray);
	}
	
	public void removeDuplicates(char[] strArray){
		if(strArray == null || strArray.length < 2)return;
		int len = strArray.length;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0;  j< tail; ++j) {
				if(strArray[i] == strArray[j])break;
			}
			if(tail == j){
				strArray[tail] = strArray[i];
				++tail;
			}
		}
		for(;tail<len;tail++)
			strArray[tail] = 0;
	}
}
