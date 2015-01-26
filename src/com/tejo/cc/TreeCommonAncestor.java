package com.tejo.cc;


public class TreeCommonAncestor {

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
				
		BinaryTreeNode ancestor = commonAncestor(broot, bl21, bl22);
		System.out.println(ancestor.data);
	}
	
	public static int coverNodes(BinaryTreeNode root, BinaryTreeNode n1,BinaryTreeNode n2){
		int ret = 0;
		if(root == null)return ret;
		if(root == n1 || root == n2)return ret += 1;
		ret += coverNodes(root.left, n1, n2);
		if(ret == 2)
			return ret;
		ret += coverNodes(root.right, n1, n2);
		return ret;
	}
	
	public static BinaryTreeNode commonAncestor(BinaryTreeNode root,BinaryTreeNode n1,BinaryTreeNode n2){
		if(n1 == n2 && (root.left == n1 || root.right == n2))return root;
		int nodesLeft = coverNodes(root.left, n1, n2);
		if(nodesLeft == 2){
			if(root.left == n1 || root.left == n2)return root.left;
			else return commonAncestor(root.left, n1, n2);
		}else if(nodesLeft == 1){
			if(root == n1)return n1;
			else if(root == n2)return n2;
		}
		
		int nodesRight = coverNodes(root.right,n1,n2);
		if(nodesRight == 2){
			if(root.right == n1 || root.right == n2)return root.right;
			else return commonAncestor(root.right, n1, n2);
		}else if(nodesRight == 1){
			if(root == n1)return n1;
			else if(root == n2)return n2;
		}
		
		if(nodesLeft == 1 && nodesRight == 1)return root;
		else return null;
	}

}
