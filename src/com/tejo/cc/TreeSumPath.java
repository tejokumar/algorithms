package com.tejo.cc;

import java.util.ArrayList;
import java.util.List;

public class TreeSumPath {
	//static List<Integer> list = new ArrayList<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode broot = new BinaryTreeNode(6);
		BinaryTreeNode bl11 = broot.addLeft(2);
		BinaryTreeNode bl12 = broot.addRight(3);
		BinaryTreeNode bl21 = bl11.addLeft(4);
		BinaryTreeNode bl22 = bl11.addRight(4);
		BinaryTreeNode bl23 = bl12.addLeft(6);
		BinaryTreeNode bl24 = bl12.addRight(7);
		BinaryTreeNode bl31 = bl21.addLeft(8);
		
		traverseTree(broot,6, 0, new ArrayList<Integer>());
	}
	
	public static void traverseTree(BinaryTreeNode root, int sum,int level,ArrayList<Integer> list){
		if(root == null)return;
		list.add(root.data);
		int tmp = sum;
		for (int i = level; i >=0 ; i--) {
			tmp = tmp - list.get(i);
			if(tmp == 0)print(i,level,list);
		}
		traverseTree(root.left, sum,level+1,(ArrayList<Integer>)list.clone());
		traverseTree(root.right, sum,level+1,(ArrayList<Integer>)list.clone());
	}
	
	public static void print(int currLevel,int level,List<Integer> list){
		for (int i = currLevel; i <= level; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

}
