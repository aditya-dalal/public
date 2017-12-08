package dataStructures.tree.lowestCommonAncestor;

/**
 * Created by aditya.dalal on 19/09/17.
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
        System.out.println(lca(a, 'i', 'h').data);

    }

    static Node lca(Node root, char c1, char c2) {
        if(root == null)
            return root;
        if(root.data == c1 || root.data == c2)
            return root;
        Node left = lca(root.left, c1, c2);
        Node right = lca(root.right, c1, c2);

        if(left != null && right != null)
            return root;

        return (left != null) ? left : right;
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