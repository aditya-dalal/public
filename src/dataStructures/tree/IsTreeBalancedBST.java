package dataStructures.tree;

/**
 * Created by aditya.dalal on 10/04/18.
 */
public class IsTreeBalancedBST {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);

        d.left = b;
        d.right = f;
        b.left = a;
        b.right = c;
        f.left = e;
        f.right = g;
        g.right = h;
        h.right = i;
        System.out.println(isBalancedBST(d));
        System.out.println(isBalancedBSTOptimized(d));
    }

    static int countNodes(Node root) {
        if(root == null)
            return 0;
        return 1+countNodes(root.left) + countNodes(root.right);
    }

    static boolean isBalancedBST(Node root) {
        return isBST(root, null, null) && isBalanced(root);
    }

    static boolean isBalancedBSTOptimized(Node root) {
        int nodeCount = countNodes(root);
//        int balancedHeight = (int) (Math.log(nodeCount) / Math.log(2)) + 1;
        int balancedHeight = 0;
        while (nodeCount > 0) {
            nodeCount >>= 1;
            balancedHeight++;
        }
        int actualHeight = height(root, 0);
        return actualHeight == balancedHeight;
    }

    static boolean isBST(Node root, Node left, Node right) {
        if (root == null)
            return true;
        if(left != null && left.data > root.data)
            return false;
        if(right != null && right.data < root.data)
            return false;
        return isBST(root.left, left, root) && isBST(root.right, root, right);
    }

    static boolean isBalanced(Node root) {
        if(root == null)
            return true;
        int lh = height(root.left, 0);
        int rh = height(root.right, 0);
        return Math.abs(lh-rh) <= 1;
    }

    static int height(Node root, int level) {
        if(root == null)
            return level;
        return Math.max(height(root.left, level+1), height(root.right, level+1));
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