package dataStructures.linkedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aditya.dalal on 20/03/18.
 */
public class FlattenLinkedList {

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node10 = new Node(10);
        Node node19 = new Node(19);
        Node node28 = new Node(28);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node30 = new Node(30);
        Node node20 = new Node(20);
        Node node22 = new Node(22);
        Node node50 = new Node(50);
        Node node35 = new Node(35);
        Node node40 = new Node(40);
        Node node45 = new Node(45);

        node5.right = node10;
        node5.down = node7;
        node7.down = node8;
        node8.down = node30;
        node10.right = node19;
        node19.right = node28;
        node10.down = node22;
        node19.down = node20;
        node20.down = node50;
        node28.down = node35;
        node35.down = node40;
        node40.down = node45;

//        Node node = flattenBySortingList(node5);
        Node node = flattenByMergeSort(node5);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.down;
        }
    }

    private static Node flattenByMergeSort(Node node) {
        if(node == null || node.right == null)
            return node;
        node.right = flattenByMergeSort(node.right);
        node = merge(node, node.right);
        return node;
    }

    private static Node merge(Node node1, Node node2) {
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        Node result;
        if(node1.val < node2.val) {
            result = node1;
            result.down = merge(node1.down, node2);
        }
        else {
            result = node2;
            result.down = merge(node1, node2.down);
        }
        return result;
    }

    private static Node mergeIterative(Node n1, Node n2) {
        if(n1 == null)
            return n2;
        if (n2 == null)
            return n1;
        Node result = n1.val < n2.val ? n1 : n2;
        if(n1.val < n2.val)
            n1 = n1.down;
        else
            n2 = n2.down;
        Node current = result;
        while (n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                current.down = n1;
                current = current.down;
                n1 = n1.down;
            }
            else {
                current.down = n2;
                current = current.down;
                n2 = n2.down;
            }
        }
        current.down = n1 == null ? n2 : n1;
        return result;
    }

    private static Node flattenBySortingList(Node list) {
        List<Node> nodes = new ArrayList<>();
        getNodeList(nodes, list);
        nodes.sort(Comparator.comparing(n -> n.val));
        for (int i = 0; i < nodes.size()-1; i++) {
            Node node = nodes.get(i);
            node.right = null;
            node.down = nodes.get(i+1);
        }
        return nodes.get(0);
    }

    private static void getNodeList(List<Node> list, Node node) {
        if(node == null)
            return;
        list.add(node);
        getNodeList(list, node.down);
        getNodeList(list, node.right);
    }

}

class Node {
    Node right;
    Node down;
    int val;

    public Node(int val) {
        this.val = val;
    }
}
