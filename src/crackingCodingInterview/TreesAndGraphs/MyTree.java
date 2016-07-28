package crackingCodingInterview.TreesAndGraphs;

import java.util.ArrayList;

public class MyTree
{
	Node root;

	public static void main(String[] args)
	{
		MyTree tree = new MyTree();
		tree.root = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		tree.root.left = n2;
		tree.root.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;

		System.out.println(tree.checkIfBalancedTree(tree.root));

        int max = tree.getMaxDepth(tree.root);
        int min = tree.getMinDepth(tree.root);
        System.out.println(max-min <= 1);
    }

	public boolean checkIfBalancedTree(Node root)
	{
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		getLeavesDepth(leaves, root, 0);
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int val : leaves)
		{
			if(val < min)
				min = val;
			if(val > max)
				max = val;
		}
		return (max - min) <= 1;
	}

	public ArrayList<Integer> getLeavesDepth(ArrayList<Integer> leaves, Node root, int length)
	{
		if(root == null)
			return null;
		if(root.left == null && root.right == null)
			leaves.add(length);
		if(root.left != null)
			getLeavesDepth(leaves, root.left, length+1);
		if(root.right != null)
			getLeavesDepth(leaves, root.right, length+1);
		return leaves;
	}

    public int getMaxDepth(Node root)
    {
        if(root == null)
            return 0;
        return Math.max(1+ getMaxDepth(root.left), 1+ getMaxDepth(root.right));
    }

    public int getMinDepth(Node root)
    {
        if (root == null)
            return 0;
        return Math.min(1+getMinDepth(root.left), 1+getMinDepth(root.right));
    }
}

class Node
{
	int data;
	Node left;
	Node right;
	Node parent;

	public Node(int value)
	{
		data = value;
	}
}