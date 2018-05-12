package dataStructures.tree.BSTSortedArray;

import java.util.*;

/**
 * Created by aditya.dalal on 11/04/18.
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {10,20,30,40,50,60,70,80,90};
        Node root = createBSTFromSortedArray(arr, 0, arr.length-1);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        System.out.println(isBST1(root));
        System.out.println(isBalancedBST(root));
        System.out.println(lowestCommonAncestor(root, 10, 40).data);
        insert(root, 25);
        insert(root, 23);
        inorder(root);
        System.out.println();
        System.out.println(isBalancedBST(root));
        for (Node node: path(root, 23))
            System.out.print(node.data + " ");
        System.out.println();
        List<Node> path = new ArrayList<>();
        List<Node> buffer = new ArrayList<>();
        pathBinaryTree(root, 23, path, buffer);
        for (Node node: path)
            System.out.print(node.data + " ");
        System.out.println();
        System.out.println(successor(root, 10).data);
        System.out.println(successor(root, 25).data);
        System.out.println(successor(root, 40).data);
        System.out.println(successor(root, 90));
        System.out.println(predecessor(root, 40).data);
        System.out.println(predecessor(root, 23).data);
        System.out.println(predecessor(root, 10));

        System.out.println(successor1(root, 40).data);
        System.out.println(predecessor1(root, 60).data);
        System.out.println("#### Row order traversal ###");
        rowOrder(root);
        System.out.println();

        Map<Integer, List<Node>> map = new HashMap<>();
        columnOrder(root, 0, map);
        List<Integer> nodes = new ArrayList<>(map.keySet());
        nodes.sort(Integer::compareTo);
        for (int col: nodes) {
            for (Node node : map.get(col))
                System.out.print(node.data + " ");
            System.out.println();
        }
        System.out.println();

        Map<Integer, List<Node>> map1 = columnOrder1(root);
        for (Map.Entry<Integer, List<Node>> entry: map1.entrySet()) {
            for (Node node: entry.getValue())
                System.out.print(node.data + " ");
            System.out.println();
        }
        System.out.println();

        delete(root, 25);
        inorder(root);
    }

    static void columnOrder(Node root, int col, Map<Integer, List<Node>> map) {
        if(root == null)
            return;
        List<Node> nodes = map.get(col);
        if(nodes == null)
            nodes = new ArrayList<>();
        nodes.add(root);
        map.put(col, nodes);
        columnOrder(root.left, col-1, map);
        columnOrder(root.right, col+1, map);
    }

    static Map<Integer, List<Node>> columnOrder1(Node root) {
        if (root == null)
            return null;
        Map<Integer, List<Node>> map = new TreeMap<>();
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root, 0));
        while (!queue.isEmpty()) {
            NodeLevel node = queue.poll();
            if(node.node.left != null)
                queue.add(new NodeLevel(node.node.left, node.level-1));
            if(node.node.right != null)
                queue.add(new NodeLevel(node.node.right, node.level+1));
            List<Node> nodes = map.get(node.level);
            if(nodes == null)
                nodes = new ArrayList<>();
            nodes.add(node.node);
            map.put(node.level, nodes);
        }
        return map;
    }
    static void rowOrder(Node root) {
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    static Node successor1(Node root, int val) { // doesn't work for last node in tree
        if(root == null)
            return root;
        return succ(root, val, root);
    }

    static Node succ(Node root, int val, Node succ) {
        if(root.data < succ.data && root.data > val)
            succ = root;
        if(val < root.data && root.left != null)
            return succ(root.left, val, succ);
        if(val > root.data && root.right != null)
            return succ(root.right, val, succ);
        if(val == root.data && root.right != null)
            return minVal(root.right);
        return succ;
    }

    static Node minVal(Node root) {
        if(root == null)
            return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    static Node predecessor1(Node root, int data) { // doesn't work for first node in tree
        if(root == null)
            return root;
        return predecess(root, data, root);
    }

    static Node predecess(Node root, int data, Node pre) {
        if(root.data < data)
            pre = root;
        if(data < root.data && root.left != null)
            return predecess(root.left, data, pre);
        if(data > root.data && root.right != null)
            return predecess(root.right, data, pre);
        if(root.data == data && root.left != null)
            return maxVal(root.left);
        return pre;
    }

    static Node maxVal(Node root) {
        if(root == null)
            return root;
        while (root.right != null)
            root = root.right;
        return root;
    }

    static List<Node> path(Node root, int data) {
        List<Node> path = new ArrayList<>();
        if(root == null)
            return path;
        path.add(root);
        while (root != null && root.data != data) {
            if(data < root.data)
                root = root.left;
            else
                root = root.right;
            path.add(root);
        }
        return path;
    }

    static Node successor(Node root, int data) {
        if(root == null)
            return null;
        Node parent = parent(root, data);
        Node curr = (parent.left != null && parent.left.data == data) ? parent.left : parent.right;
        if(curr.right != null)
            return minVal(curr.right);
        if(parent.left == curr)
            return parent;
        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = parent(root, parent.data);
        }
        return parent;
    }

    static Node parent(Node root, int data) {
        Node parent = null, curr = root;
        while (curr != null && curr.data != data) {
            parent = curr;
            if(data < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return parent;
    }

    static Node predecessor(Node root, int data) {
        if(root == null)
            return null;
        Node parent = parent(root, data);
        if(parent.right != null && parent.right.data == data)
            return parent;
        Node curr = parent.left;
        while (parent != null && parent.left == curr) {
            curr = parent;
            parent = parent(root, parent.data);
        }
        return parent;
    }

    static Node search(Node root, int data) {
        if(root == null)
            return null;
        while (root != null && root.data != data) {
            if(data < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

    static void pathBinaryTree(Node root, int data, List<Node> path, List<Node> buffer) {
        if(root == null)
            return;
        buffer.add(root);
        if(root.data == data)
            for (Node node: buffer)
                path.add(node);
        pathBinaryTree(root.left, data, path, buffer);
        pathBinaryTree(root.right, data, path, buffer);
        buffer.remove(root);
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
            if(root.right == null)
                return root.left;
            root.data = minVal(root.right).data;
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    static Node insert(Node root, int val) {
        Node node = new Node(val);
        if(root == null)
            return node;
        Node temp = root, prev = null;
        while (temp != null) {
            prev = temp;
            if(val < temp.data)
                temp = temp.left;
            else
                temp = temp.right;
        }
        if(val < prev.data)
            prev.left = node;
        else
            prev.right = node;
        return root;
    }

    static Node insertRec(Node root, int data) {
        if(root == null)
            return new Node(data);
        if(data < root.data)
            root.left = insert(root.left, data);
        if(data > root.data)
            root.right = insert(root.right, data);
        return root;
    }

    static Node lowestCommonAncestor(Node root, int val1, int val2) {
        if(root == null)
            return root;
        if(root.data == val1 || root.data == val2)
            return root;
        Node leftLCS = lowestCommonAncestor(root.left, val1, val2);
        Node rightLCS = lowestCommonAncestor(root.right, val1, val2);
        if(leftLCS != null && rightLCS != null)
            return root;
        return leftLCS == null ? rightLCS : leftLCS;
    }

    static boolean isBalancedBST(Node root) {
        int count = countNodes(root);
        int expectedHeight = 0;
        while (count > 0) {
            count >>= 1;
            expectedHeight++;
        }
        return isBST(root, null, null) && expectedHeight == height(root);
    }

    static int countNodes(Node root) {
        if(root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static boolean isBST(Node root, Node left, Node right) {
        if(root == null)
            return true;
        if(left != null && root.data < left.data)
            return false;
        if(right != null && root.data > right.data)
            return false;
        return isBST(root.left, left, root) && isBST(root.right, root, right);
    }

    static boolean isBST1(Node root) {
        if(root == null)
            return true;
        if(root.left != null && root.left.data > root.data)
            return false;
        if(root.right != null && root.right.data < root.data)
            return false;
        return isBST1(root.left) && isBST1(root.right);
    }

    static int height(Node root) {
        if(root == null)
            return 0;
        return 1+ Math.max(height(root.left), height(root.right));
    }

    static Node createBSTFromSortedArray(int[] arr, int min, int max) {
        Node root = null;
        if(min <= max) {
            int mid = (min + max) / 2;
            root = new Node(arr[mid]);
            root.left = createBSTFromSortedArray(arr, min, mid-1);
            root.right = createBSTFromSortedArray(arr, mid+1, max);
        }
        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root) {
        if(root != null) {
            System.out.print(root.data +" ");
            preorder(root.left);
            preorder(root.right);
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

class NodeLevel {
    Node node;
    int level;
    public NodeLevel(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}