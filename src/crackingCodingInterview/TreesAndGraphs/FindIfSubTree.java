package crackingCodingInterview.TreesAndGraphs;

public class FindIfSubTree
{
    public static void main(String[] args)
    {
        Node root = new Node(4);
        Node n1 = new Node(2);
        Node n2 = new Node(6);
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(7);
        Node n7 = new Node(8);
        Node n8 = new Node(10);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n6.right = n7;
        n7.right = n8;

        Node root1 = new Node(6);
        Node n9 = new Node(5);
        Node n10 = new Node(7);
        Node n11 = new Node(8);

        root1.left = n9;
        root1.right = n10;
        n10.right = n11;

        // Approach 1
        Node largeNode = findNode(root, root1);
        System.out.println(findIfSubTree(largeNode, root1));

        // Approach 2
        System.out.println(inorder(root).contains(inorder(root1)) && preorder(root).contains(preorder(root1)));
    }

    public static Node findNode(Node root, Node node)
    {
        if(root == null || node == null)
            return null;
        if(root.data == node.data)
            return root;
        Node left = findNode(root.left, node);
        Node right = findNode(root.right, node);

        return left != null ? left : right;
    }

    public static boolean findIfSubTree(Node root1, Node root2)
    {
        if(root1 == null && root2 == null)
            return true;
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.data != root2.data)
            return false;
        return findIfSubTree(root1.left, root2.left) && findIfSubTree(root1.right, root2.right);
    }

    public static String inorder(Node root)
    {
        StringBuilder str = new StringBuilder();
        return inorderString(str, root).toString();
    }

    public static StringBuilder inorderString(StringBuilder str, Node root)
    {
        if(root == null)
            return str;
        inorderString(str, root.left);
        str.append(root.data);
        inorderString(str, root.right);
        return str;
    }

    public static String preorder(Node root)
    {
        StringBuilder str = new StringBuilder();
        return preorderString(str, root).toString();
    }

    public static StringBuilder preorderString(StringBuilder str, Node root)
    {
        if(root == null)
            return str;
        preorderString(str, root.left);
        str.append(root.data);
        preorderString(str, root.right);
        return str;
    }

}