package com.tejo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStringUsingStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String input,output;
		while(true){
			System.out.println("Enter String to Reverse: ");
			System.out.flush();
			input = getString();
			if(input.equals(""))
				break;
			Reverser reverser = new Reverser(input);
			output = reverser.reverseString();
			
			System.out.println("Reversed String : "+ output);
		}

	}
	
	public static String getString() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(reader);
		String line = bReader.readLine();
		return line;
	}

}
class Stack{
	private int maxSize;
	private int top;
	private char[] chars;
	
	public Stack(int size){
		this.maxSize = size;
		this.chars = new char[maxSize];
		this.top = -1;
	}
	
	public void push(char c){
		chars[++top] = c;
	}
	
	public char pop(){
		return chars[top--];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == maxSize-1;
	}
}

class Reverser{
	private String input;
	private StringBuffer output;
	
	public Reverser(String in){
		input = in;
	}
	
	public String reverseString(){
		Stack myStack = new Stack(input.length());
		for (int i = 0; i < input.length(); i++) {
			myStack.push(input.charAt(i));
		}
		while(!myStack.isEmpty()){
			if(output == null)
				output = new StringBuffer();
			output.append(myStack.pop());
		}
		return output.toString();
	}
}