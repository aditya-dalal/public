package crackingCodingInterview.linkedLists;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromLinkedList
{
    public static void main(String[] args)
    {
        LinkedList<Integer> a = new LinkedList<Integer>(3);
        LinkedList<Integer> b = new LinkedList<Integer>(1);
        LinkedList<Integer> c = new LinkedList<Integer>(3);
        LinkedList<Integer> d = new LinkedList<Integer>(4);
        LinkedList<Integer> e = new LinkedList<Integer>(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        printList(a);
        removeDuplicates(a);
        printList(a);
    }

    public static <T> void removeDuplicates(LinkedList<T> list)
    {
        Map<T, Boolean> dataMap = new HashMap<T, Boolean>();
        LinkedList<T> previous = null;
        while(list != null)
        {
            if(dataMap.containsKey(list.data))
                previous.next = list.next;
            else
                dataMap.put(list.data, true);
            previous = list;
            list = list.next;
        }
    }

    public static <T> void printList(LinkedList<T> list)
    {
        LinkedList<T> temp = list;
        while(temp != null)
        {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class LinkedList<T>
{
    T data;
    public LinkedList<T> next;

    public LinkedList(T value)
    {
        data = value;
        next = null;
    }
}