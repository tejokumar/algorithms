package com.tejo.cc;

public class AddNumbersInLInkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(3);
		n1.addToTail(1);
		n1.addToTail(5);
		
		Node n2 = new Node(5);
		n2.addToTail(9);
		n2.addToTail(2);
		
		n1.displayNode();
		n2.displayNode();
		addNodesRec(n1, n2,0).displayNode();
		
	}
	public static Node addNodes(Node n1,Node n2){
		int carry = 0;
		Node result = null;
		while(n1 != null || n2 != null){
			int n1Data = n1 != null ? n1.data :0;
			int n2Data = n2 != null ? n2.data :0;
			int sum = n1Data + n2Data + carry;
			carry = sum/10;
			Node resultNode = new Node(sum%10);
			if(result == null)
				result = resultNode;
			else
				result.addToTail(sum%10);
			
			if(n1 != null)
				n1=n1.next;
			if(n2 != null)
				n2=n2.next;
		}
		
		return result;
	}
	
	public static Node addNodesRec(Node n1, Node n2,int carry){
		if(n1 == null && n2 == null)
			return null;
		int sum = carry;
		if(n1 != null)
			sum = sum + n1.data;
		if(n2 != null)
			sum = sum + n2.data;
		
		Node result = new Node(sum%10);
		Node next = addNodesRec(n1 != null ? n1.next : null, n2 != null ? n2.next : null,sum/10);
		result.next = next;
		return result;
		
	}
}
