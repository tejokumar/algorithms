package com.tejo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Anagram {
	static char[] arrInput;
	static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String myString = MyUtils.getString();
		arrInput = new char[myString.length()];
		for (int i = 0; i < myString.length(); i++) {
			arrInput[i] = myString.charAt(i);
		}
		doAnagram(arrInput.length);
		//List<String> list = getWords(myString);
		//System.out.println(list.size());
	}
	
	public static void doAnagram(int size){
		if(size == 1)
			return;
		for (int i = 0; i < size; i++) {
			doAnagram(size-1);
			if(size == 2){
				displayWord();
			}
			rotate(size);
		}
	}
	public static void rotate(int size){
		int j;
		int position = arrInput.length - size;
		char temp = arrInput[position];
		for (j = position +1; j < arrInput.length; j++) {
			arrInput[j-1] = arrInput[j];
		}
		arrInput[j-1] = temp;
	}
	public static void displayWord(){
		if(count < 99)
	         System.out.print(" ");
	      if(count < 9)
	         System.out.print(" ");
	      System.out.print(++count + " ");
	      for(int j=0; j<arrInput.length; j++)
	         System.out.print( arrInput[j] );
	      System.out.print("   ");
	      System.out.flush();
	      if(count%6 == 0)
	         System.out.println("");
	}
	
	public static List<String> getWords(String word){
		List<String> list = new ArrayList<String>();
		if(word == null)return null;
		if(word.length() == 0){
			list.add("");
			return list;
		}
		char first = word.charAt(0);
		String remaining = word.substring(1);
		List<String> otherWords = getWords(remaining);
		for(String otherWord : otherWords){
			for (int i = 0; i <= otherWord.length(); i++) {
				list.add(insertChartAt(otherWord, first, i));
			}
		}
		return list;
	}
	public static String insertChartAt(String word,char c,int index){
		return word.substring(0,index) + c + word.substring(index);
		
	}

}
