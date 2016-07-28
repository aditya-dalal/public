package problems;

/**
 * Created by aditya.dalal on 04/12/15.
 */
public class Tree {

    public static void main(String[] args) {
        Integer[] arr = {12,5,7,3,9,11,15,2};

        Node root = createTree(arr);
        inorder(root);
    }

    private static Node createTree(Integer[] arr) {
        if(arr.length == 0)
            return null;
        Node root = new Node(arr[0]);
        for (int i : arr)
            add(root, i);
        return root;
    }

    private static void add(Node root, int val) {
        if(val < root.value) {
            if (root.left != null)
                add(root.left, val);
            else
                root.left = new Node(val);
        }
        else if(val > root.value) {
            if (root.right != null)
                add(root.right, val);
            else
                root.right = new Node(val);
        }
    }

    private static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }
}

class Node {
    Integer value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}