package com.tejo.cc;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {

	Stack<Integer> minStack = new Stack<Integer>();

	@Override
	public synchronized Integer pop() {
		int value = super.pop();
		if(value == min())
			minStack.pop();
		return value;
	}

	@Override
	public Integer push(Integer value) {
		if(value <= min())
			minStack.push(value);
		return super.push(value);
	}
	
	public Integer min(){
		if(minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}
	
}
