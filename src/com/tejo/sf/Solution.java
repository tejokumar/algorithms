package com.tejo.sf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	private static ComponentManager cm;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		cm = new ComponentManager();
		
		//Read data File
		InputStreamReader fis = new InputStreamReader(Solution.class.getResourceAsStream("problem.in.txt"));
		BufferedReader bReader = new BufferedReader(fis);
		String line ="";
		while((line = bReader.readLine()) != ""){
			System.out.println(line);
			processInputLine(line);
			if("END".equals(line))
				break;
		}
		
	}
	
	private static void processInputLine(String line){
		//ASSUMING there is only one space between strings
		String[] lineSplit = line.split(" ");
		
		//First Item is the operation
		String operation = lineSplit[0];
		
		if("DEPEND".equals(operation)){
			//Add Item First
			cm.addItem(lineSplit[1]);
			//Add Dependencies
			for (int i = 2; i < lineSplit.length; i++) {
				cm.addDependentItem(lineSplit[1], lineSplit[i]);
			}
		}else if("INSTALL".equals(operation)){
			cm.installItem(lineSplit[1]);
		}else if("REMOVE".equals(operation)){
			cm.removeItem(lineSplit[1]);
		}else if("LIST".equals(operation)){
			cm.listItems();
		}
	}

}
