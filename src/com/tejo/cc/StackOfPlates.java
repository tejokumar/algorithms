package com.tejo.cc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
	final int maxSize = 10;
	List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	
	
	public Object pop(){
		
		int topStack = stacks.size()-1;
		Stack<Integer> stack = stacks.get(topStack);
		Object obj= stack.pop();
		if(stack.isEmpty())
			stacks.remove(topStack);
		return obj;
	}
	
	public void push(Integer obj){
		if(stacks.size() == 0){
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(obj);
			stacks.add(stack);
		}else{
			Stack<Integer> stack = stacks.get(stacks.size()-1);
			if(stack.size() == maxSize){
				Stack<Integer> newstack = new Stack<Integer>();
				newstack.push(obj);
				stacks.add(newstack);
			}else
				stack.push(obj);
		}
	}
}
