package com.tejo.datastructures;

public class LinkedListNode {
	public LinkedListNode next = null;
	public int data;
	public LinkedListNode(int d){
		this.data = d;
	}
	public void addToTail(int d){
		LinkedListNode newNode = new LinkedListNode(d);
		LinkedListNode n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = newNode;
	}
	
	public LinkedListNode deleteNode(LinkedListNode head,int d){
		LinkedListNode n = head;
		if(n.data == d){
			return head.next;
		}
		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}
		}
		return head;
	}
}
