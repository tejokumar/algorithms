package com.tejo;

public class BinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree = new Tree();
		for (int i = 0; i < 10; i++) {
			tree.insert((int)(Math.random() * 100));
		}
//		tree.inOrder(tree.root);
		tree.preOrder(tree.root);
//		tree.postOrder(tree.root);
	}
}
class Node{
	public int data;
	public Node leftChild;
	public Node rightChild;
	
	public void displayNode(){
		System.out.println("Node - "+data);
	}
}

class Tree{
	public Node root;
	
	public Tree(){
		root = null;
	}
	
	public Node find(int key){
		Node currentNode = root;
		while(currentNode.data != key){
			if(key < currentNode.data)
				currentNode = currentNode.leftChild;
			else
				currentNode = currentNode.rightChild;
			if(currentNode == null)
				return null;
		}
		return currentNode;
	}
	
	public void insert(int newValue){
		Node newNode = new Node();
		newNode.data = newValue;
		
		if(root == null)
			root = newNode;
		else{
			Node currentNode = root;
			Node parent = currentNode;
			while(true){
				parent = currentNode;
				if(newValue < currentNode.data){		
					currentNode = currentNode.leftChild;
					if(currentNode == null){
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					currentNode = currentNode.rightChild;
					if(currentNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}		
	}
	
	public boolean delete(int data){
		Node currentNode = root;
		Node parent=currentNode;
		boolean isLeftChild = false;
		while(currentNode.data != data){
			parent = currentNode;
			if(data < currentNode.data){
				isLeftChild = true;
				currentNode = currentNode.leftChild;
			}else{
				isLeftChild = false;
				currentNode = currentNode.rightChild;
			}
			if(currentNode == null)
				return false;
		}
		if(currentNode.leftChild == null && currentNode.rightChild == null){
			if(currentNode == root)
				root=null;
			else if(isLeftChild)
					parent.leftChild = null;
				else
					parent.rightChild = null;
			return true;
		}
		if(currentNode.leftChild == null){
			if(currentNode == root)
				root=currentNode.rightChild;
			else if(isLeftChild)
					parent.leftChild = currentNode.rightChild;
				else
					parent.rightChild = currentNode.rightChild;
			return true;
		}
		if(currentNode.rightChild == null){
			if(currentNode == root)
				root=currentNode.leftChild;
			else if(isLeftChild)
					parent.leftChild = currentNode.leftChild;
				else
					parent.rightChild = currentNode.leftChild;
			return true;
		}
		Node successor = getSuccessor(currentNode);
		successor.leftChild = currentNode.leftChild;
		if(currentNode == root){			
			root = successor;
		}	
		else if(isLeftChild){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			
		return true;
	}
	
	public Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node currentNode = delNode.rightChild;
		
		while(currentNode != null){
			successorParent = successor;
			successor = currentNode;
			currentNode = currentNode.leftChild;
		}
		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	public void inOrder(Node node){
		if(node != null){
			inOrder(node.leftChild);
			node.displayNode();
			inOrder(node.rightChild);
		}
	}
	
	public void preOrder(Node node){
		if(node != null){
			node.displayNode();
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	
	public void postOrder(Node node){
		if(node != null){
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			node.displayNode();
		}
	}
}
