package com.tejo.cc;

public class DeleteNthNodeInLinkedList {

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
		deleteNode(head.next.next);
		head.displayNode();

	}
	
	public static boolean deleteNode(Node node){
		if(node == null || node.next == null)
			return false;
		Node next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}

}
