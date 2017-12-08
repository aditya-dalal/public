package dataStructures.tree.swapNodes;

import java.util.*;

/**
 * Created by aditya.dalal on 19/09/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = new Node(1, 1);
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        for(int i = 0; i < n; i++) {
            Node parent = queue.remove(0);
            int leftVal = scanner.nextInt();
            int rightVal = scanner.nextInt();
            if(leftVal != -1) {
                Node left = new Node(leftVal, parent.level+1);
                parent.left = left;
                queue.add(left);
            }
            if(rightVal != -1) {
                Node right = new Node(rightVal, parent.level+1);
                parent.right = right;
                queue.add(right);
            }
        }
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int k = scanner.nextInt();
            swap(root, k);
            inorder(root);
            System.out.println();
        }
    }

    static void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void swap(Node root, int level) {
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0) {
            Node curr = queue.remove(0);
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
            if(curr.level % level == 0) {
                Node temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
            }
        }
    }
}

class Node{
    int data;
    int level;
    Node left;
    Node right;

    public Node(int data, int level) {
        this.data = data;
        this.level = level;
    }
}