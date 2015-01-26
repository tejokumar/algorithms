package com.tejo.cc;

import java.util.HashMap;
import java.util.Map;

public class DirectedGraph {
	Map<String, GraphNode> nodesMap;
	
	public DirectedGraph(){
		nodesMap = new HashMap<String, GraphNode>();
	}
	
	public GraphNode getNode(String name){
		return nodesMap.get(name);
	}
	public void addNode(String name){
		GraphNode node = new GraphNode(name);
		nodesMap.put(name,node);
	}
	
	public void addAdjacentNode(String name1, String name2){
		nodesMap.get(name1).addAdjacentNode(nodesMap.get(name2));
	}
}
