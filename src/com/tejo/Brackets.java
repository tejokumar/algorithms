package com.tejo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Brackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String input;
		while(true){
			System.out.println("Enter String to Check Brackets: ");
			System.out.flush();
			input = getString();
			if(input.equals(""))
				break;
			BracketChecker bracketChecker = new BracketChecker(input);
			bracketChecker.check();
		}

	}
	
	public static String getString() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(reader);
		String line = bReader.readLine();
		return line;
	}

}
class BracketChecker{
	
	private String input;
	private HashMap<String,String> exprMap;
	public BracketChecker(String in){
		input = in;
		exprMap = new HashMap<String, String>();
		exprMap.put("{", "}");
		exprMap.put("[", "]");
		exprMap.put("(", ")");
		
	}
	
	public void check(){
		Stack<String> myStack = new Stack<String>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(exprMap.containsKey(c+""))
				myStack.push(c+"");
			else if(myStack.isEmpty() || (!myStack.isEmpty() && !exprMap.get(myStack.pop()).equals(c+""))){
				System.out.println("Error with "+ c + " at "+i);
			}			
		}
		if(!myStack.isEmpty())
			System.out.println("Error while closing");
	}
}