package crackingCodingInterview.linkedLists;

public class AddTwoIntegerLists
{
    public static void main(String[] args)
    {
        LinkedList<Integer> a = new LinkedList<Integer>(9);
        LinkedList<Integer> b = new LinkedList<Integer>(9);
        LinkedList<Integer> c = new LinkedList<Integer>(9);
        a.next = b;
        b.next = c;

        LinkedList<Integer> d = new LinkedList<Integer>(4);
        LinkedList<Integer> e = new LinkedList<Integer>(5);
        d.next = e;

        LinkedList<Integer> result = addTwoLinkedLists(a, d);
        printList(result);

        LinkedList<Integer> result1 = addLists(a, d, 0);
        printList(result1);
    }

    public static LinkedList<Integer> addTwoLinkedLists(LinkedList<Integer> list1, LinkedList<Integer> list2)
    {
        int val1 = 0;
        int power = 0;
        while(list1 != null)
        {
            val1 += list1.data * Math.pow(10, power++);
            list1 = list1.next;
        }

        int val2 = 0;
        power = 0;
        while(list2 != null)
        {
            val2 += list2.data * Math.pow(10, power++);
            list2 = list2.next;
        }
        int total = val1+ val2;

        LinkedList<Integer> result = null;
        LinkedList<Integer> last = result;
        while(total > 0)
        {
            if(result == null)
            {
                result = new LinkedList<Integer>(total % 10);
                last  = result;
            }
            else
            {
                last.next = new LinkedList<Integer>(total % 10);
                last = last.next;
            }
            total /= 10;
        }
        return result;
    }

    public static LinkedList<Integer> addLists(LinkedList<Integer> l1, LinkedList<Integer> l2, int carry)
    {
        if(l1 == null && l2 == null && carry == 0)
            return null;
        LinkedList<Integer> result = new LinkedList<Integer>(carry);
        int value = carry;

        if(l1 != null)
            value += l1.data;
        if(l2 != null)
            value += l2.data;

        result.data = value % 10;

        LinkedList<Integer> more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
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
