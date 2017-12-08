package dataStructures.tree.LeafNodesInorder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 14/11/17.
 */
public class LeafNodesInOrder {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        List<Node> nodes = new ArrayList<>();
        leafNodesInOrder(a, nodes);
        for (Node node: nodes)
            System.out.println(node.val);
    }

    static void leafNodesInOrder(Node root, List<Node> nodes) {
        if(root == null)
            return;
        leafNodesInOrder(root.left, nodes);
        if(root.left == null && root.right == null)
            nodes.add(root);
        leafNodesInOrder(root.right, nodes);
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}