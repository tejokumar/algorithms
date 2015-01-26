package com.tejo.cc;

public class TreeFromSortedArrayWithMinHeight {
	static int[] array = {1,2,3,4,5,6,7};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		getTree().inOrder();
	}
	
	public static BinaryTreeNode getTree(){
		return addChildren(0, array.length -1);
	}
	
	public static BinaryTreeNode addChildren(int lower,int higher){
		if(lower > higher)
			return null;
		int mid = (lower + higher)/2;
		BinaryTreeNode midTree = new BinaryTreeNode(array[mid]);
		midTree.left = addChildren(lower, mid -1);
		midTree.right = addChildren(mid+1, higher);
		
		return midTree;
	}
}
