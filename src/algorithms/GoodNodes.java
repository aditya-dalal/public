package algorithms;

import java.util.*;

public class GoodNodes
{
    static List<Node> nodeList = new ArrayList<Node>();
    static List<Node> visitedNodes = new ArrayList<Node>();
    static Set<Node> goodNodes = new HashSet<Node>();
    static Node firstNode;
    static int count = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = Integer.parseInt(scanner.nextLine());

        if(nodeCount == 0)
            System.exit(0);

        for(int i = 0; i < nodeCount; i++)
            nodeList.add(new Node(i + 1));
        firstNode = nodeList.get(0);
        goodNodes.add(firstNode);

        for(int i = 0; i < nodeCount; i++)
        {
            int nodeIndex = Integer.parseInt(scanner.nextLine());
            nodeList.get(i).next = nodeList.get(nodeIndex - 1);
        }

        for (int i = 0; i < nodeCount; i++)
        {
            System.out.println("Node: "+ nodeList.get(i).value + " -> " + nodeList.get(i).next.value);
        }

        for(int i = 1; i < nodeCount; i++)
        {
                checkNodes(nodeList.get(i));
        }

        System.out.println("# Nodes which require change: " + count);

        System.out.println("\nAfter changing");
        for (int i = 0; i < nodeCount; i++)
        {
            System.out.println("Node: "+ nodeList.get(i).value + " -> " + nodeList.get(i).next.value);
        }

    }

    private static void checkNodes(Node currentNode)
    {
        visitedNodes.add(currentNode);
        if(goodNodes.contains(currentNode.next))
            return;
        if(currentNode.next == firstNode)
        {
            goodNodes.addAll(visitedNodes);
            visitedNodes.clear();
            return;
        }
        else if(currentNode.next == currentNode)
        {
            currentNode.next = firstNode;
            count++;
            goodNodes.addAll(visitedNodes);
            visitedNodes.clear();
            return;
        }
        else if(visitedNodes.contains(currentNode.next))
        {
            currentNode.next = firstNode;
            count++;
            goodNodes.addAll(visitedNodes);
            visitedNodes.clear();
            return;
        }
        checkNodes(currentNode.next);
    }

}

class Node
{
    int value;
    Node next;

    public Node(int i)
    {
        value = i;
    }
}
