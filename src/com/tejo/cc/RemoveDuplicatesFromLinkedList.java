package com.tejo.cc;

public class RemoveDuplicatesFromLinkedList {

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
		
		head.displayNode();
		deleteDuplicates(head);
		head.displayNode();
	}
	
	
	public static void deleteDuplicates(Node head){
		int duplicateChecker = 0;

		Node previous = head;
		Node n = previous.next;
		duplicateChecker = duplicateChecker | (1<<previous.data);
		while(n != null){
			if((duplicateChecker & (1<<n.data)) >0){
				previous.next = deleteNode(n, n.data);
			}else
			if((duplicateChecker & (1<<n.data)) ==0)
			{
				duplicateChecker = duplicateChecker | (1<<n.data);
				previous = n;

			}
			
			n=previous.next;
			
		}
	}
	public static Node deleteNode(Node head,int d){
		Node n = head;
		if(head.data == d)
			return head.next;
		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}	
		}
		return head;
	}
}


class Node{
	int data = 0;
	Node next = null;
	public Node(int d){
		data = d;
	}
	public void addToTail(int d){
		Node newNode = new Node(d);
		Node n = this;
		while(n.next != null)
			n=n.next;
		n.next = newNode;
	}
	
	public void displayNode(){
		System.out.print(data + " ");
		Node n = this;
		while(n.next != null){
			System.out.print(n.next.data + " ");
			n= n.next;
		}
		System.out.println();
	}
}
