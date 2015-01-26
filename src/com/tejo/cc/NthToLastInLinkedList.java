package com.tejo.cc;

public class NthToLastInLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(5);
		head.addToTail(3);
		head.addToTail(4);
		head.addToTail(5);
		head.addToTail(7);
		head.addToTail(4);
		
		Node n = nthFromLast2(head, 3);
		n.displayNode();

	}
	public static Node nthFromLast2(Node head,int n){
		Node p1 = head;
		Node p2 = head;
		while(n-1>0){
			p2=p2.next;
			n--;
		}
		while(p2.next != null){
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
	}
	public static Node nthNodeFromLast(Node head,int n){
		int lastNodeCount = 0;
		
		Node current = head;
		while(current.next != null){
			current = current.next;
			lastNodeCount++;
		}
		current=head;
		int difference = lastNodeCount - n;
		while(difference >0){
			current = current.next;
			difference--;
		}
		return current.next;
	}
}
