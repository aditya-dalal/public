package dataStructures.linkedLists;

/**
 * Created by aditya.dalal on 20/03/18.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);
        MyNode node6 = new MyNode(6);
        MyNode node7 = new MyNode(7);
        MyNode node8 = new MyNode(8);
        MyNode node9 = new MyNode(9);

        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;

        MyNode result = merge(node1, node2);
        while (result != null){
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    private static MyNode merge(MyNode n1, MyNode n2) {
        if(n1 == null)
            return n2;
        if (n2 == null)
            return n1;
        MyNode result = n1.val < n2.val ? n1 : n2;
        if(n1.val < n2.val)
            n1 = n1.next;
        else
            n2 = n2.next;
        MyNode current = result;
        while (n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                current.next = n1;
                current = current.next;
                n1 = n1.next;
            }
            else {
                current.next = n2;
                current = current.next;
                n2 = n2.next;
            }
        }
        current.next = n1 == null ? n2 : n1;
        return result;
    }

}

class MyNode {
    MyNode next;
    int val;

    public MyNode(int val) {
        this.val = val;
    }
}