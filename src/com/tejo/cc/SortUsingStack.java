package com.tejo.cc;

import java.util.Stack;

public class SortUsingStack {

	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(6);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		Stack<Integer> newStack = sort(stack);
		while(!newStack.isEmpty())
			System.out.println(newStack.pop());
		
	}
	public static Stack<Integer> sort(Stack<Integer> stack){
		Stack<Integer> newStack = new Stack<Integer>();
		while(!stack.isEmpty()){
			int tmp = stack.pop();
			while(!newStack.isEmpty() && newStack.peek() > tmp)
				stack.push(newStack.pop());
			newStack.push(tmp);
		}
		return newStack;
	}
}
