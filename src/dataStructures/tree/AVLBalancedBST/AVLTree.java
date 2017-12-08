package dataStructures.tree.AVLBalancedBST;

/**
 * Created by aditya.dalal on 01/10/17.
 */
public class AVLTree {

    //Incomplete solution
    public static void main(String[] args) {
//        int[] vals = {14,25,21, 10, 23, 7, 26, 12, 30, 16, 19};
//        int[] vals = {17, 6, 10, 18, 22, 16};
        int[] vals = {3,2,7,6,5};
        Node root = null;
        for (int n : vals) {
            root = insert(root, n);
            inorder(root);
            System.out.println();
        }
        System.out.println(getHeight(root.left) - getHeight(root.right));
    }

    static Node insert(Node root, int val) {
        root = insertBST(root, val);
        if(root.ht == 0)
            return root;
        int diff = getHeight(root.left) - getHeight(root.right);
        if(diff >= -1 && diff <= 1)
            return root;
        Node parent = null, temp = root, prevParent = null;
        String prevEdge = null, edge = null;
        while (true) {
            diff = getHeight(temp.left) - getHeight(temp.right);
            if(diff < -1) {
                prevParent = parent;
                parent = temp;
                temp = temp.right;
                prevEdge = edge;
                edge = "r";
            }
            else if (diff > 1) {
                prevParent = parent;
                parent = temp;
                temp = temp.left;
                prevEdge = edge;
                edge = "l";
            }
            else break;
        }
        Node n = balanceTree(parent);
        if(prevParent == null)
            return n;
        if(prevEdge.equalsIgnoreCase("r"))
            prevParent.right = n;
        else
            prevParent.left = n;
        setHeight(root);
        return root;
    }

    static Node balanceTree(Node root) {
        Node newRoot = null;
        if(root.right != null && root.right.right != null) {
            newRoot = root.right;
            newRoot.left = root;
            root.right = null;
        }
        else if (root.right != null && root.right.left != null){
            newRoot = root.right.left;
            newRoot.right = root.right;
            root.right.left = null;
            newRoot.left = root;
            root.right = null;
        }
        else if(root.left != null && root.left.left != null) {
            newRoot = root.left;
            newRoot.right = root;
            root.left = null;
        }
        else if(root.left != null && root.left.right != null) {
            newRoot = root.left.right;
            newRoot.left = root.left;
            root.left.right = null;
            newRoot.right = root;
            root.left = null;
        }
        setHeight(newRoot);
        return newRoot;
    }

    static int getHeight(Node root) {
        return root != null ? root.ht : -1;
    }

    static Node insertBST(Node root, int val) {
        Node node = new Node(val);
        node.ht = 0;
        if(root == null)
            return node;
        Node temp = root, parent = null;
        while(temp != null) {
            parent = temp;
            if(val < temp.val)
                temp = temp.left;
            else
                temp = temp.right;
        }
        if(val < parent.val)
            parent.left = node;
        else
            parent.right = node;
        setHeight(root);
        return root;
    }

    static int setHeight(Node root) {
        if(root == null)
            return -1;
        root.ht = 1 + Math.max(setHeight(root.left), setHeight(root.right));
        return root.ht;
    }

    static void  inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

class Node {
    int val;
    int ht;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}