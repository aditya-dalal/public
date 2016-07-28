package crackingCodingInterview.TreesAndGraphs;

public class FirstCommonAncestor
{
	public static void main(String[] args)
	{
		Node root = new Node(4);
		Node n1 = new Node(2);
		Node n2 = new Node(6);
		Node n3 = new Node(1);
		Node n4 = new Node(3);
		Node n5 = new Node(5);
		Node n6 = new Node(7);
		Node n7 = new Node(8);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n6.right = n7;

		System.out.println(firstCommonAncestor(root, n3, n4).data);

	}

	public static Node firstCommonAncestor(Node root, Node n1, Node n2)
	{
		if(n1 ==  null || n2 == null || root == null)
			return null;
		if(root == n1 || root == n2)
			return root;
		Node left = firstCommonAncestor(root.left, n1, n2);
		Node right = firstCommonAncestor(root.right, n1, n2);

		if(left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}