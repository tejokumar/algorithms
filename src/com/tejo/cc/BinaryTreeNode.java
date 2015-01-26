package com.tejo.cc;

public class BinaryTreeNode {
	int data;
	boolean visited;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	public BinaryTreeNode(int inpData){
		data = inpData;
	}
	public BinaryTreeNode addLeft(int inpData){
		left = new BinaryTreeNode(inpData);
		left.parent = this;
		return left;
	}
	
	public BinaryTreeNode addRight(int inpData){
		right = new BinaryTreeNode(inpData);
		right.parent = this;
		return right;
	}
	
	public void inOrder(){
		if(left != null)
			left.inOrder();
		System.out.println(data);
		if(right != null)
			right.inOrder();
	}
}
