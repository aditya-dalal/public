package dataStructures;

public class BinarySearchTree
{
    public static Integer[] arr = {10,17,27,3,16,13,1,5,7,12,4,8,9,0,4};
//    public static Integer[] arr = {10,11,12,13,14,15};

    public static void main(String[] args)
    {
        Tree tree = createBST(arr);
        Node inNode = new Node();
        Node node = new Node();
        inNode.value = 2;

        System.out.print("InOrder: ");
        inOrder(tree.root);

        System.out.println("\nInserting node with value: " + inNode.value);
        insert(tree, inNode);

        System.out.print("InOrder: ");
        inOrder(tree.root);
        System.out.println();

        System.out.print("PreOrder: ");
        preOrder(tree.root);
        System.out.println();

        System.out.print("PostOrder: ");
        postOrder(tree.root);
        System.out.println();

        System.out.println("Max: " + maximum(tree.root).value);
        System.out.println("Min: " + minimum(tree.root).value);

        node.value = 9;
        System.out.println("Successor: " + successor(tree.root, node).value);

        node.value = 4;
        System.out.println("Predecessor: " + predecessor(tree.root, node).value);

        node.value = 1;
        System.out.println("Node: " + treeSearch(tree.root, node));

        node.value = 18;
        System.out.println("Node: " + iterativeTreeSearch(tree.root, node));

        Node node1 = new Node();
        node.value = 8;
        node1.value = 17;

        Node n1 = treeSearch(tree.root, node);
        Node n2 = treeSearch(tree.root, node1);

        System.out.println("LCA BST approach1: " + lowestCommonAncestorBST(tree.root, n1, n2).value);

        System.out.println("LCA Binary tree: " + lowestCommonAncestorBinaryTree(tree.root, n1, n2).value);

        System.out.println("LCA BST approach2: " + lowestCommonAncestorBinarySearchTree(tree.root, n1, n2).value);

        node.value = 3;
        n1 = treeSearch(tree.root, node);

        delete(tree, n1);
        inOrder(tree.root);
    }

    private static void delete(Tree tree, Node node)
    {
        if(tree.root == null || node == null)
            return;

        Node parent, child, current;

        if(node.leftChild != null && node.rightChild != null)
            current = successor(tree.root, node);
        else
            current = node;

        if(current.leftChild != null)
            child = current.leftChild;
        else
            child = current.rightChild;

        parent = current.parent;

        if(parent == null)
            tree.root = child;
        else if(parent.leftChild == current)
            parent.leftChild = child;
        else
            parent.rightChild = child;

        if(child != null)
            child.parent = parent;

        if(current != node)
            node.value = current.value;
    }

    private static Node lowestCommonAncestorBinaryTree(Node root, Node n1, Node n2)
    {
        if(root == null || n1 == null || n2 == null)
            return null;

        if(n1 == root || n2 == root)
            return root;

        Node left = lowestCommonAncestorBinaryTree(root.leftChild, n1, n2);
        Node right = lowestCommonAncestorBinaryTree(root.rightChild, n1, n2);

        if(left != null && right != null)
            return root;

        return left != null? left : right;
    }

    private static Node lowestCommonAncestorBST(Node root, Node n1, Node n2)
    {
        if(n1 == null || n2 == null || root == null)
            return null;

        Node current = root;
        Node min = n1.value < n2.value ? n1 : n2;
        Node max = n1.value > n2.value ? n1 : n2;

        while (current.value < min.value || current.value > max.value)
        {
            if(min.value > current.value)
                current = current.rightChild;
            else
                current = current.leftChild;
        }
        return current;
    }

    private static Node lowestCommonAncestorBinarySearchTree(Node root, Node n1, Node n2)
    {
        if(n1 == null || n2 == null || root == null)
            return null;

        if(Math.min(n1.value, n2.value) > root.value)
            return lowestCommonAncestorBinarySearchTree(root.rightChild, n1, n2);
        else if(Math.max(n1.value, n2.value) < root.value)
            return lowestCommonAncestorBinarySearchTree(root.leftChild, n1, n2);
        else
            return root;
    }

    private static Node predecessor(Node root, Node node)
    {
        Node current = treeSearch(root, node);

        if(current == null)
            return null;

        if(current.leftChild != null)
            return current.leftChild;
        Node parent = current.parent;
        while (parent != null && parent.leftChild == current)
        {
            current = parent;
            parent = current.parent;
        }
        return parent;
    }

    private static Node successor(Node root, Node node)
    {
        Node current = treeSearch(root, node);

        if(current == null)
            return null;

        if(current.rightChild != null)
            return minimum(current.rightChild);
        Node parent = current.parent;
        while (parent != null && parent.rightChild == current)
        {
//            System.out.println(parent.value);  // For debugging
            current = parent;
            parent = current.parent;
        }
        return parent;
    }

    private static Node minimum(Node root)
    {
        Node current = root;
        if(current == null)
            return null;

        while(current.leftChild != null)
        {
            current = current.leftChild;
        }
        return current;
    }

    private static Node maximum(Node node)
    {
        Node current = node;
        if(current == null)
            return null;

        while (current.rightChild != null)
        {
            current = current.rightChild;
        }
        return current;
    }

    private static Node iterativeTreeSearch(Node root, Node node)
    {
        Node current = root;
        if(current == null)
            return null;

        while (current != null && node.value != current.value)
        {
            if(node.value < current.value)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return current;
    }

    private static Node treeSearch(Node root, Node node)
    {
        if(root == null || root.value == node.value)
            return root;
        else if(node.value < root.value)
            return treeSearch(root.leftChild, node);
        else
            return treeSearch(root.rightChild, node);
    }

    private static void postOrder(Node node)
    {
        if(node != null)
        {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.value + ", ");
        }
    }

    private static void preOrder(Node node)
    {
        if(node != null)
        {
            System.out.print(node.value + ", ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    private static void inOrder(Node node)
    {
        if(node != null)
        {
            inOrder(node.leftChild);
            System.out.print(node.value + ", ");
            inOrder(node.rightChild);
        }
    }

    private static Tree createBST(Integer[] arr)
    {
        Tree tree = new Tree();
        for(int key : arr)
        {
            Node node = new Node();
            node.value = key;
            insert(tree, node);
        }
        return tree;
    }

    private static void insert(Tree tree, Node node)
    {
        Node parent = null, current;
        current = tree.root;
        while (current != null)
        {
            parent = current;
            if(node.value <= current.value)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        if(parent == null)
            tree.root = node;
        else
        {
            if(node.value <= parent.value)
                parent.leftChild = node;
            else
                parent.rightChild = node;
        }
        node.parent = parent;
    }
}

class Tree
{
    Node root;
}

class Node
{
    int value;
    Node leftChild;
    Node rightChild;
    Node parent;
}