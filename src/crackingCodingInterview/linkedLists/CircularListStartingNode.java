package crackingCodingInterview.linkedLists;

import java.util.HashMap;
import java.util.Map;

public class CircularListStartingNode
{
    public static void main(String[] args)
    {
        LinkedList<Character> a = new LinkedList<Character>('a');
        LinkedList<Character> b = new LinkedList<Character>('b');
        LinkedList<Character> c = new LinkedList<Character>('c');
        LinkedList<Character> d = new LinkedList<Character>('d');
        LinkedList<Character> e = new LinkedList<Character>('e');
        LinkedList<Character> f = new LinkedList<Character>('f');
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = c;

        LinkedList<Character> result = getNodeAtBeginningOfLoop(a);
        if(result != null)
            System.out.println(result.data);
        else
            System.out.println("Either list is null or a loop does not exist in the list");

        LinkedList<Character> result1 = getNodeAtBeginningOfLoopWithoutAdditionalStorage(a);
        if(result1 != null)
            System.out.println(result1.data);
        else
            System.out.println("Either list is null or a loop does not exist in the list");
    }

    public static <T> LinkedList<T> getNodeAtBeginningOfLoop(LinkedList<T> head)
    {
        if(head == null)
            return null;
        Map<LinkedList<T>, Boolean> nodeMap = new HashMap<LinkedList<T>, Boolean>();
        while(true)
        {
            if(nodeMap.containsKey(head))
                return head;
            if(head.next == null)
                return null;

            nodeMap.put(head, true);
            head = head.next;
        }
    }

    public static <T> LinkedList<T> getNodeAtBeginningOfLoopWithoutAdditionalStorage(LinkedList<T> head)
    {
        LinkedList<T> n1 = head;
        LinkedList<T> n2 = head;
        while(n2 != null)
        {
            n1 = n1.next;
            n2 = n2.next.next;
            if(n1 == n2)
                break;
        }

        if(n2 == null)
            return null;
        n1 = head;
        while(n1 != n2)
        {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

}