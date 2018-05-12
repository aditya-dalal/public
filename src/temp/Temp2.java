package temp;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 17/09/17.
 */
public class Temp2 {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50,60,70,80,90};
        Node root = createBST(arr, 0, arr.length-1);
        inorder(root);
        System.out.println();
        System.out.println(isBalancedBST(root));
        System.out.println(lca(root, 20, 40).data);
        System.out.println(successor(root, 20).data);
        System.out.println(predecessor(root, 50).data);
        insert(root, 25);
        insert(root, 23);
        inorder(root);
        System.out.println();
        System.out.println(isBalancedBST(root));
//        path(root, 23, new ArrayList<>());
//        System.out.println();
        delete(root, 10);
        inorder(root);
        System.out.println();
    }

    static Node delete(Node root, int val) {
        if(root == null)
            return root;
        if(val < root.data)
            root.left = delete(root.left, val);
        else if(val > root.data)
            root.right = delete(root.right, val);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.data = min(root.right).data;
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    static void path(Node root, int val, List<Node> path) {
        if(root == null)
            return;
        path.add(root);
        if(root.data == val)
            for (Node node: path)
                System.out.print(node.data + " ");
        if(val < root.data)
            path(root.left, val, path);
        else
            path(root.right, val, path);
        path.remove(root);
    }

    static void insert(Node root, int val) {
        while (root.left != null && root.right != null) {
            if(val < root.data)
                root = root.left;
            else
                root = root.right;
        }
        Node node = new Node(val);
        if(val < root.data)
            root.left = node;
        else root.right = node;
    }

    static Node predecessor(Node root, int val) {
        Node pre = root;
        Node node = root;
        while (node.data != val) {
            if(node.data < val)
                pre = node;
            if(val < node.data)
                node = node.left;
            else
                node = node.right;
        }
        if(node.left != null)
            return max(node.left);
        return pre;
    }

    static Node max(Node root) {
        while (root.right != null)
            root = root.right;
        return root;
    }

    static Node successor(Node root, int val) {
        Node succ = root;
        Node node = root;
        while (node.data != val) {
            if(node.data > val)
                succ = node;
            if(node.data > val)
                node = node.left;
            else
                node = node.right;
        }
        if(node.right != null)
            return min(node.right);
        return succ;
    }

    static Node min(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    static Node lca(Node root, int val1, int val2) {
        if(root == null)
            return root;
        if(root.data == val1 || root.data == val2)
            return root;
        Node left = lca(root.left, val1, val2);
        Node right = lca(root.right, val1, val2);

        if(left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    static boolean isBalancedBST(Node root) {
        int nodes = count(root);
        int expectedHeight = 0;
        while (nodes > 0) {
            expectedHeight++;
            nodes >>= 1;
        }
        return (expectedHeight == height(root)) && isBST(root);
    }

    static int count(Node root) {
        if(root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }

    static int height(Node root) {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static boolean isBST(Node root) {
        if(root == null)
            return true;
        if(root.left != null && root.left.data > root.data)
            return false;
        if(root.right != null && root.right.data < root.data)
            return false;
        return isBST(root.left) && isBST(root.right);
    }

    static Node createBST(int[] arr, int min, int max) {
        Node node = null;
        if(min <= max) {
            int mid = (min+max)/2;
            node = new Node(arr[mid]);
            node.left = createBST(arr, min, mid-1);
            node.right = createBST(arr, mid+1, max);
        }
        return node;
    }

    static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
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
