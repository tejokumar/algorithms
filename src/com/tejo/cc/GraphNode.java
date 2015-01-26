package com.tejo.cc;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	String nodeName;
	boolean visited;
	List<GraphNode> adjacentNodes;
	
	public GraphNode(String name){
		nodeName = name;
		visited = false;
	}
	public void addAdjacentNode(GraphNode node){
		if(adjacentNodes == null)adjacentNodes = new ArrayList<GraphNode>();
		adjacentNodes.add(node);
	}
	
	public GraphNode getUnvisitedAdjacentNode(){
		if(adjacentNodes == null)return null;
		for(GraphNode node : adjacentNodes)
			if(!node.visited)return node;
		return null;
	}
}
