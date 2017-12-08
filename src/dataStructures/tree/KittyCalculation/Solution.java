package dataStructures.tree.KittyCalculation;

import java.util.*;

/**
 * Created by aditya.dalal on 19/09/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        Node[] nodes = new Node[n];
        // there is an undirected edge between nodes. fix the nodes mapping
        for (int i = 1; i < n; i++) {
            int pVal = scanner.nextInt();
            int cVal = scanner.nextInt();
            if(nodes[pVal-1] == null) {
                Node parent = new Node(pVal);
                nodes[pVal-1] = parent;
            }
            if(nodes[cVal-1] == null) {
                Node child = new Node(cVal);
                nodes[cVal - 1] = child;
            }
            nodes[pVal-1].children.add(nodes[cVal-1]);
            nodes[cVal-1].parent = nodes[pVal-1];
        }
        for(int i = 0; i < q; i++) {
            int setSize = scanner.nextInt();
            int[] set = new int[setSize];
            for(int j = 0; j < setSize; j++) {
                set[j] = scanner.nextInt();
            }
            if(setSize == 1) {
                System.out.println(0);
                continue;
            }
            System.out.println(process(nodes[0], set));
        }
    }

    private static long process(Node root, int[] set) {
        List<Node> nodeList = getNodeList(root, set);
        Map<Node, List<Node>> paths = getAllNodePaths(nodeList);
        List<List<Node>> pairs = getAllPairs(nodeList);
        long total = 0;
        for(List<Node> pair: pairs) {
            total += pair.get(0).data * pair.get(1).data * getDistance(pair, paths);
        }
        return (long) (total % (Math.pow(10, 9) + 7));
    }

    private static int getDistance(List<Node> pair, Map<Node, List<Node>> paths) {
        List<Node> n1 = paths.get(pair.get(0));
        List<Node> n2 = paths.get(pair.get(1));
        int i = 0;
        while (n1.get(i) == n2.get(i)) {
            i++;
        }
        i--;
        return n1.size()-1 + n2.size()-1 - 2*i;
    }

    private static List<List<Node>> getAllPairs(List<Node> nodes) {
        List<List<Node>> lists = new ArrayList<>();
        for(int i = 0; i < nodes.size()-1; i++) {
            for(int j = i+1; j < nodes.size(); j++) {
                List<Node> pair = new ArrayList<>();
                pair.add(nodes.get(i));
                pair.add(nodes.get(j));
                lists.add(pair);
            }
        }
        return lists;
    }

    private static Map<Node, List<Node>> getAllNodePaths(List<Node> nodeList) {
        Map<Node, List<Node>> paths = new HashMap<>();
        for(Node node: nodeList)
            paths.put(node, getPathFromRoot(node));
        return paths;
    }


    private static List<Node> getPathFromRoot(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(0, node);
            node = node.parent;
        }
        return path;
    }

    private static List<Node> getNodeList(Node root, int[] set) {
        Map<Integer, Boolean> setMap = new HashMap<>();
        for (int val: set)
            setMap.put(val, true);
        List<Node> queue = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0) {
            Node curr = queue.remove(0);
            if(setMap.get(curr.data) != null)
                nodeList.add(curr);
            if(nodeList.size() == setMap.size())
                break;
            queue.addAll(curr.children);
        }
        return nodeList;
    }
}

class Node {
    int data;
    List<Node> children;
    Node parent;

    public Node(int data) {
        this.data = data;
        children = new ArrayList<>();
    }
}