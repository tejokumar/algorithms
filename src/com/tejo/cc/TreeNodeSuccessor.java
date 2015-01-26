package com.tejo.cc;

public class TreeNodeSuccessor {

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
		
		broot.inOrder();
		System.out.println();
		BinaryTreeNode successor = getSuccessor(broot);
		System.out.println(successor.data);
	}
	
	public static BinaryTreeNode getSuccessor(BinaryTreeNode node){
		if(node == null)return null;
		BinaryTreeNode successor = node.parent;
		
		if(node.parent == null || node.right != null){
			successor = node.right;
			while(successor.left!=null){
				successor = successor.left;
			}
		}else{
			while((successor = node.parent) != null){
				if(successor.left == node)
					break;
				node = successor;
			}
		}
		return successor;
	}

}
