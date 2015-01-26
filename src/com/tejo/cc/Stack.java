package com.tejo.cc;

public class Stack {
	LinkListNode top;
	Object min;
	public void push(Object data){
		LinkListNode newItem = new LinkListNode(data);
		newItem.next = top;
		top = newItem;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	public Object pop(){
		if(top != null){
			Object data = top.data;
			top = top.next;
			return data;
		}
		return null;
	}
}
