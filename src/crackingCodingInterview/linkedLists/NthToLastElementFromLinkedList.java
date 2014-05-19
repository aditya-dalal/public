package crackingCodingInterview.linkedLists;

public class NthToLastElementFromLinkedList
{
    public static void main(String[] args)
    {
        LinkedList<Integer> a = new LinkedList<Integer>(3);
        LinkedList<Integer> b = new LinkedList<Integer>(1);
        LinkedList<Integer> c = new LinkedList<Integer>(2);
        LinkedList<Integer> d = new LinkedList<Integer>(4);
        LinkedList<Integer> e = new LinkedList<Integer>(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        printList(a);
        LinkedList<Integer> result = getNthToLastElementFrom(a, 4);
        if(result != null)
            System.out.println(result.data);
        else
            System.out.println("null");

        LinkedList<Integer> result1 = getNthToLastElementInSinglePass(a, 4);
        if(result != null)
            System.out.println(result1.data);
        else
            System.out.println("null");
    }

    public static <T> LinkedList<T> getNthToLastElementFrom(LinkedList<T> list, int position)
    {
        if(list == null || position < 1)
            return null;
        int listLength = getListLength(list);
        if(position > listLength)
            return null;
        int i = 1;
        while(i++ <= listLength - position)
            list = list.next;
        return list;
    }

    public static <T> LinkedList<T> getNthToLastElementInSinglePass(LinkedList<T> list, int position)
    {
        if(list == null || position < 1)
            return null;
        LinkedList<T> p1 = list;
        LinkedList<T> p2 = list;
        for(int i = 1; i < position; i++)
        {
            if(p2.next == null)
                return null;
            p2 = p2.next;
        }
        while(p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static <T> int getListLength(LinkedList<T> list)
    {
        int count = 0;
        while(list != null)
        {
            list = list.next;
            count++;
        }
        return count;
    }

    public static <T> void printList(LinkedList<T> list)
    {
        while(list != null)
        {
            System.out.print(list.data + ", ");
            list = list.next;
        }
        System.out.println();
    }
}
