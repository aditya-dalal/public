package crackingCodingInterview.TreesAndGraphs;

public class MinimumHeightBinaryTreeFromSortedArray
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Node root = treeFromArray(0, arr.length-1, arr);
        System.out.println(root);
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