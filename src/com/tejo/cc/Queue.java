package com.tejo.cc;

public class Queue {
	LinkListNode first,last;
	
	public void enque(Object data){
		LinkListNode node = new LinkListNode(data);
		if(last == null){
			last = node;
			first = last;
		}	
		else{
			last.next = node;
			last = last.next;
		}
	}
	
	public Object deque(){
		if(first == null)
			return null;
		Object data = first.data;
		first = first.next;
		return data;
	}
}
