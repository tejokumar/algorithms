package com.tejo.cc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TreeLinkedListsOfEachDepth {
	
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
		
		Map<Integer, LinkedList<BinaryTreeNode>> map = getLinkedLists(broot);
		
		//4 levels - 4 Linked Lists
		System.out.println(map.values().size());
	}
	public static Map<Integer, LinkedList<BinaryTreeNode>> getLinkedLists(BinaryTreeNode root){
		
		Map<Integer, LinkedList<BinaryTreeNode>> lMap = new HashMap<Integer, LinkedList<BinaryTreeNode>>();
		int currentDepth = 0;
		java.util.Stack<BinaryTreeNode> stack = new java.util.Stack<BinaryTreeNode>();
		stack.push(root);
		root.visited = true;
		
		LinkedList<BinaryTreeNode> rootList = new LinkedList<BinaryTreeNode>();
		rootList.addLast(root);
		lMap.put(0, rootList);
		
		while(!stack.isEmpty()){
			BinaryTreeNode node = stack.peek();
			BinaryTreeNode child = node.left != null && !node.left.visited ? node.left : (node.right != null && !node.right.visited ? node.right : null);
			if(child !=null){
				child.visited = true;
				currentDepth++;
				LinkedList<BinaryTreeNode> childList = lMap.get(currentDepth);
				if(childList == null)childList = new LinkedList<BinaryTreeNode>();
				childList.addLast(child);
				lMap.put(currentDepth, childList);
				stack.push(child);
			}else{
				stack.pop();
				currentDepth--;
			}
		}
		
		return lMap;
	}
}
