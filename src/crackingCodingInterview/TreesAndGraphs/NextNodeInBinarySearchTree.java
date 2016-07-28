package crackingCodingInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class NextNodeInBinarySearchTree
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
        n1.parent = root;
        n2.parent = root;
        n3.parent = n1;
        n4.parent = n1;
        n5.parent = n2;
        n6.parent = n2;
        n7.parent = n6;

        Node test = root;
        System.out.println(nextNode(test).data);

        List<Node> inorder = new ArrayList<Node>();
        nextNodeUsingInOrderTraversal(inorder, root);

        for(int i = 0; i < inorder.size(); i++)
        {
            if(inorder.get(i) == test)
            {
                System.out.println(inorder.get(i+1).data);
                break;
            }
        }
    }

    public static Node nextNode(Node node)
    {
        if(node == null)
            return null;
        if(node.right != null)
            return getNext(node.right);

        Node result = null;
        if(node.left == null && node.right == null)
        {
            if(node.parent.left == node)
                result = node.parent;
            else
            {
                while(node.parent != null && node.parent.right == node)
                    node = node.parent;
                result = node.parent;
            }
        }
        return result;
    }

    private static Node getNext(Node node)
    {
        while(node.left != null)
            node = node.left;
        return node;
    }

    public static void nextNodeUsingInOrderTraversal(List<Node> list, Node root)
    {
        if(root == null)
            return;
        nextNodeUsingInOrderTraversal(list, root.left);
        list.add(root);
        nextNodeUsingInOrderTraversal(list, root.right);
    }
}