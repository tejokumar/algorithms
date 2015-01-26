package com.tejo.cc;

import java.util.Stack;

public class TreeFindingSubTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode broot = new BinaryTreeNode(1);
		BinaryTreeNode bl11 = broot.addLeft(2);
		BinaryTreeNode bl12 = broot.addRight(3);
		BinaryTreeNode bl21 = bl11.addLeft(4);
		BinaryTreeNode bl22 = bl11.addRight(5);
		BinaryTreeNode bl23 = bl12.addLeft(6);
		BinaryTreeNode bl24 = bl12.addRight(7);
		BinaryTreeNode bl31 = bl21.addLeft(8);
		
		BinaryTreeNode bl41 = new BinaryTreeNode(10);
		
		//System.out.println(isSubtree(broot,bl31));
		System.out.println(isSubtree(broot,bl31));
		System.out.println(subTree(broot,bl31));

	}
	
	public static boolean isSubtree(BinaryTreeNode tree1,BinaryTreeNode tree2){
		return isNodeFromTree(tree1, tree2);
	}
	public static boolean areTreesEqual(BinaryTreeNode node1,BinaryTreeNode node2){
		if(node1 == null && node2 == null)return true;
		if(node1 == null || node2 == null)return false;
		if(node1.data != node2.data)return false;
		
		return areTreesEqual(node1.right, node2.right) && areTreesEqual(node1.left, node2.left);
		
	}
	public static boolean isNodeFromTree(BinaryTreeNode root,BinaryTreeNode node){
		if(root == null || node == null)return false;
		if(root.data == node.data){
			if(areTreesEqual(root, node))
				return true;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);
		root.visited = true;
		while(!stack.isEmpty()){
			BinaryTreeNode current = stack.peek();
			BinaryTreeNode child = current.left != null && !current.left.visited ? current.left : (current.right != null && !current.right.visited ? current.right : null);
			if(child != null){
				if(child.data == node.data){
					if(areTreesEqual(child, node))
						return true;
				}
				child.visited = true;
				stack.push(child);
			}else
				stack.pop();
		}
		return false;
	}
	
	public static boolean subTree(BinaryTreeNode root,BinaryTreeNode node){
		if(root == null || node == null)return false;
		if(root.data == node.data){
			if(areTreesEqual(root, node))
				return true;
		}
		return subTree(root.left, node) || subTree(root.right, node); //Tree can be on either side of the root
	}

}
