package com.tejo.cc;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	int data;
	boolean visited;
	List<TreeNode> children;
	public TreeNode(int inpData){
		data = inpData;
		visited = false;
	}
	public TreeNode addChild(int d){
		TreeNode child = new TreeNode(d);
		if(children == null)children = new ArrayList<TreeNode>();
		children.add(child);
		return child;
	}
	
	public TreeNode getUnVisitedChild(){
		if(children == null)return null;
		for(TreeNode child : children){
			if(!child.visited)return child;
		}
		return null;
	}
}
