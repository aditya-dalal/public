package dataStructures.tree.topView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 18/09/17.
 */
public class TopView {
    static TempNode linkedList;
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(2);
        Node c = new Node(1);
        Node d = new Node(5);
        Node e = new Node(4);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left = b;
        a.right = c;
        b.right = d;
        d.right = e;
        e.right = f;
        f.right = g;
        topView1(a);
        System.out.println();
        topView(a);
    }

    static void topView(Node root) {
        if(root == null)
            return;
        List<Integer> view = new ArrayList<>();
        view.add(root.data);
        Node temp = root.left;
        while (temp != null) {
            view.add(0, temp.data);
            temp = temp.left;
        }
        temp = root.right;
        while (temp != null) {
            view.add(temp.data);
            temp = temp.right;
        }
        for (int i: view)
            System.out.print(i + " ");
    }

    static void topView1(Node root) {
        if(root == null)
            return;
        List<TempNode> queue = new ArrayList<>();
        List<TempNode> topView = new ArrayList<>();
        queue.add(new TempNode(root, 0));
        while(queue.size() > 0) {
            TempNode node =  queue.remove(0);
            if(node.val.left != null)
                queue.add(new TempNode(node.val.left, node.level-1));
            if(node.val.right != null)
                queue.add(new TempNode(node.val.right, node.level+1));
            if(topView.size() == 0) {
                topView.add(node);
                continue;
            }
            if(node.level < topView.get(0).level)
                topView.add(0, node);
            else if(node.level > topView.get(topView.size()-1).level)
                topView.add(node);
        }
        for (TempNode i : topView)
            System.out.print(i.val.data + " ");
    }

}

class TempNode {
    Node val;
    int level;
    TempNode next;

    public TempNode(Node val, int level) {
        this.val = val;
        this.level = level;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        this.data = val;
    }
}
