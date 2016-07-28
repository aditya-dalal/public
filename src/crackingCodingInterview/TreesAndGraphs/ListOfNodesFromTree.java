package crackingCodingInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class ListOfNodesFromTree
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7,8};

		Node root = treeFromArray(0, arr.length-1, arr);

		List<List<Node>> lists = listsOfNodes(root);
        for (List<Node> list : lists)
        {
            for (Node node : list)
                System.out.print(node.data + " ");
            System.out.println();
        }
    }

	public static List<List<Node>> listsOfNodes(Node root)
	{
		List<List<Node>> lists = new ArrayList<List<Node>>();

        if(root == null)
            return lists;

		List<Node> visited = new ArrayList<Node>();
		visited.add(root);
		while(!visited.isEmpty())
		{
			List<Node> list = new ArrayList<Node>();
			for(Node node : visited)
				list.add(node);
            visited.clear();
            for(Node node : list)
			{
                if(node.left != null)
					visited.add(node.left);
				if(node.right != null)
					visited.add(node.right);
			}
			lists.add(list);
		}
		return lists;
	}

	public static Node treeFromArray(int min, int max, int[] arr)
	{
		if(min > max)
			return null;
		int mid = (max + min) / 2;
		Node node = new Node(arr[mid]);
		node.left = treeFromArray(min, mid - 1, arr);
		node.right = treeFromArray(mid + 1, max, arr);
		return node;
	}
}