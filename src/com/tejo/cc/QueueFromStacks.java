package com.tejo.cc;

import java.util.Stack;

public class QueueFromStacks {

	private Stack<Integer> front;
	private Stack<Integer> back;
	
	public QueueFromStacks(){
		front = new Stack<Integer>();
		back = new Stack<Integer>();
	}
	
	public void enqueu(int data){
		front.push(data);
		System.out.println(data);
	}
	
	public Integer dequeu(){
		Integer value = null;
		if(!back.isEmpty())value = back.pop();
		while(value == null && !front.isEmpty())
			back.push(front.pop());
		 value = value == null ?back.pop() : value;
	
		System.out.println(value);
		return value;
	}
	
	public static void main(String args[]){
		QueueFromStacks qfs = new QueueFromStacks();
		qfs.enqueu(1);
		qfs.enqueu(2);
		qfs.enqueu(3);
		qfs.enqueu(4);
		
		qfs.dequeu();
		qfs.dequeu();
		qfs.dequeu();
		
		qfs.enqueu(5);
		
		qfs.dequeu();
		qfs.dequeu();
	}
}
