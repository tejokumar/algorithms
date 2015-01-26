package com.tejo.cc;

public class StartOfCircularLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node A = new Node(1);
		Node B = new Node(2);
		Node C = new Node(3);
		Node D = new Node(4);
		Node E = new Node(5);
		Node F = new Node(6);
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		E.next = F;
		F.next = C;
		
		Node start = getStartOfCircle(B);
		System.out.println(start.data);
	}
	
	public static Node getStartOfCircle(Node head){
		Node slower = head;
		Node faster = head;
		
		while(faster !=null && faster.next != null){
			slower = slower.next;   
			faster = faster.next.next;
			if(slower == faster)
				break;
			if(faster.next == null)
				return null;
		}
		
		slower = head;
		while(slower != faster){
			slower = slower.next;
			faster = faster.next;
		}
		return slower;
	}

}
