package com.tejo.cc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphRouteBetweenNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DirectedGraph dg = new DirectedGraph();
		dg.addNode("A");
		dg.addNode("B");
		dg.addNode("C");
		dg.addNode("D");
		
		dg.addAdjacentNode("A", "B");
		dg.addAdjacentNode("B", "C");
		
		//System.out.println(isRouteAvailable(dg, "A", "C"));
		//System.out.println(isRouteAvailable(dg, "A", "D"));
		
		System.out.println(isRouteAvailable2(dg, "A", "C"));
		System.out.println(isRouteAvailable2(dg, "A", "D"));
	}
	
	//Using Breadth First Search
	public static boolean isRouteAvailable(DirectedGraph dg,String n1,String n2){
		GraphNode node1 = dg.getNode(n1);
		GraphNode node2 = dg.getNode(n2);
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node1);
		node1.visited = true;
		while(!queue.isEmpty()){
			GraphNode node = queue.remove();
			GraphNode adjNode = null;
			while((adjNode = node.getUnvisitedAdjacentNode()) != null){
				if(adjNode == node2)return true;
				adjNode.visited = true;
				queue.add(adjNode);
			}
		}
		return false;
	}
	
	//Using Depth First Search
	public static boolean isRouteAvailable2(DirectedGraph dg,String n1,String n2){
		GraphNode node1 = dg.getNode(n1);
		GraphNode node2 = dg.getNode(n2);
		
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(node1);
		node1.visited = true;
		while(!stack.isEmpty()){
			GraphNode node = stack.peek();
			GraphNode adjNode = node.getUnvisitedAdjacentNode();
			if(adjNode != null){
				if(adjNode == node2)return true;
				adjNode.visited = true;
				stack.push(adjNode);
			}else
				stack.pop();
		}
		return false;
	}

}
