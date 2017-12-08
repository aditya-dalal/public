package dataStructures.tree.pathFromRoot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 20/09/17.
 */
public class Solution {
    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');
        a.left = b;
        a.right = c;
        b.left = d;
        d.right = e;
        c.left = f;
        c.right = g;
        f.left = h;
        System.out.print(getPath(a, 'g'));
    }

    static List<Character> getPath(Node root, char node) {
        if(root == null)
            return null;
        List<Character> pathFromRoot = new ArrayList<>();
        path(root, node, pathFromRoot);
        return pathFromRoot;
    }

    private static boolean path(Node root, char node, List<Character> pathFromRoot) {
        if(root == null)
            return false;
        pathFromRoot.add(root.data);
        if(root.data == node)
            return true;
        if (path(root.left, node, pathFromRoot) || path(root.right, node, pathFromRoot))
            return true;
        pathFromRoot.remove(pathFromRoot.size()-1);
        return false;
    }
}

class Node {
    char data;
    Node left;
    Node right;

    public Node(char val) {
        this.data = val;
    }
}