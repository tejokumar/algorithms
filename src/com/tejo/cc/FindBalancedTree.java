package com.tejo.cc;

import java.util.Stack;

public class FindBalancedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l11 = root.addChild(2);
		TreeNode l12 = root.addChild(3);
		TreeNode l21 = l11.addChild(4);
		TreeNode l22 = l11.addChild(5);
		TreeNode l23 = l12.addChild(6);
		TreeNode l24 = l12.addChild(7);
		TreeNode l31 = l21.addChild(8);
		//TreeNode l41 = l31.addChild(16);
		System.out.println(isBalanced(root));
		
		BinaryTreeNode broot = new BinaryTreeNode(1);
		BinaryTreeNode bl11 = broot.addLeft(2);
		BinaryTreeNode bl12 = broot.addRight(3);
		BinaryTreeNode bl21 = bl11.addLeft(4);
		BinaryTreeNode bl22 = bl11.addRight(5);
		BinaryTreeNode bl23 = bl12.addLeft(6);
		BinaryTreeNode bl24 = bl12.addRight(7);
		BinaryTreeNode bl31 = bl21.addLeft(8);
		//BinaryTreeNode bl41 = bl31.addLeft(16);
		System.out.println(isBalancedBinaryTree(broot));
	}
	
	public static boolean isBalancedBinaryTree(BinaryTreeNode binaryTreeNode){
		int max = maxDepth(binaryTreeNode);
		int min = minDepth(binaryTreeNode);
		
		return max - min > 1 ? false : true;
	}
	
	private static int maxDepth(BinaryTreeNode binaryTreeNode){
		if(binaryTreeNode == null)
			return 0;
		return 1 + Math.max(maxDepth(binaryTreeNode.left), maxDepth(binaryTreeNode.right));
	}
	
	private static int minDepth(BinaryTreeNode binaryTreeNode){
		if(binaryTreeNode == null)
			return 0;
		return 1 + Math.min(minDepth(binaryTreeNode.left), minDepth(binaryTreeNode.right));
	}
	
	public static boolean isBalanced(TreeNode root){
		int maxDepth = 0;
		int currentDepth = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		root.visited = true;
		while(!stack.isEmpty()){
			
			if(maxDepth < currentDepth)maxDepth = currentDepth;
			
			TreeNode node = stack.peek();
			if(node.children == null && (maxDepth - currentDepth) > 1) return false;
			TreeNode child = node.getUnVisitedChild();
			if(child != null){
				child.visited = true;
				stack.push(child);
				currentDepth++;
			}else{
				stack.pop();
				currentDepth--;
			}	
		}
		return true;
	}

}
