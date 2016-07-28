package crackingCodingInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class RouteBetweenTwoNodes
{
	public static void main(String[] args)
	{
		Graph graph = new Graph();
		GNode a = new GNode('a');
		GNode b = new GNode('b');
		GNode c = new GNode('c');
		GNode d = new GNode('d');
		GNode e = new GNode('e');

		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);

		a.nodes.add(b);
		a.nodes.add(c);
		a.nodes.add(d);
		b.nodes.add(c);
		b.nodes.add(e);
		c.nodes.add(e);
		c.nodes.add(d);
		d.nodes.add(b);

		System.out.println(routeBetweenNodes(graph, a, e));
	}

	public static boolean routeBetweenNodes(Graph graph, GNode n1, GNode n2)
	{
		for(GNode node : graph.nodes)
			node.color = "White";

		List<GNode> visited = new ArrayList<GNode>();
		visited.add(n1);
		while(!visited.isEmpty())
		{
			GNode node = visited.get(visited.size()-1);
			for(GNode n : node.nodes)
			{
				if(n == n2)
					return true;

				if(!n.color.equals("Black"))
					visited.add(n);
			}
			node.color = "Black";
            visited.remove(node);
		}
		return false;
	}
}

class GNode
{
	List<GNode> nodes;
	char data;
	String color;

	public GNode(char value)
	{
		nodes = new ArrayList<GNode>();
		data = value;
	}
}

class Graph
{
	List<GNode> nodes;

	public Graph()
	{
		nodes = new ArrayList<GNode>();
	}

	public void add(GNode node)
	{
		nodes.add(node);
	}
}
