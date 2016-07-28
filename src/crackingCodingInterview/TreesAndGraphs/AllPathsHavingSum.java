package crackingCodingInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsHavingSum
{
    public static void main(String[] args)
    {
        Node root = new Node(3);
        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        Node n5 = new Node(5);
        Node n6 = new Node(2);
        Node n7 = new Node(1);
        Node n8 = new Node(2);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n5.right = n7;
        n3.left = n8;

        List<Node> path = new ArrayList<Node>();
        List<List<Node>> paths = new ArrayList<List<Node>>();

        allPathsFromRoot(root, path, paths);
        pathsHavingSum(paths, 6);
    }

    public static void allPathsFromRoot(Node root, List<Node> path, List<List<Node>> paths)
    {
        if(root == null)
            return;
        path.add(root);
        if(root.left == null && root.right == null)
        {
            List<Node> nodes = new ArrayList<Node>();
            for(Node node : path)
                nodes.add(node);
            paths.add(nodes);
        }
        allPathsFromRoot(root.left, path, paths);
        allPathsFromRoot(root.right, path, paths);
        path.remove(root);
    }

    public static void pathsHavingSum(List<List<Node>> paths, int sum)
    {
        for(List<Node> path : paths)
        {
            int p1 = 0;
            int total = 0;
            for(int i = 0; i < path.size(); i++)
            {
                total += path.get(i).data;
                if(total > sum)
                {
                    total -= path.get(p1).data;
                    p1++;
                }
                if(total == sum)
                {
                    for(int j = p1; j <= i; j++)
                        System.out.print(path.get(j).data + " ");
                    System.out.println();
                }
            }
        }
    }

}