package dataStructures.tree.BoundryTraversalAnticlockWise;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by aditya.dalal on 10/04/18.
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Node a = new Node(20);
        Node b = new Node(8);
        Node c = new Node(22);
        Node d = new Node(4);
        Node e = new Node(12);
        Node f = new Node(25);
        Node g = new Node(10);
        Node h = new Node(14);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;

        Set<Node> nodes = new LinkedHashSet<>();
        printLeft(a, nodes);
        printLeaves(a, nodes);
        printRight(a, nodes);
        for (Node node: nodes)
            System.out.println(node.data);
    }

    static void printRight(Node root, Set<Node> nodes) {
        if(root == null)
            return;
        printRight(root.right, nodes);
        nodes.add(root);
    }

    static void printLeft(Node root, Set<Node> nodes) {
        while (root != null) {
            nodes.add(root);
            root = root.left;
        }
    }

    static void printLeaves(Node root, Set<Node> nodes) {
        if(root == null)
            return;
        printLeaves(root.left, nodes);
        printLeaves(root.right, nodes);
        if(root.left == null && root.right == null)
            nodes.add(root);
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}