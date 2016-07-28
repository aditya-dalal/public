package algorithms;

public class LinkedListUsingArrays
{
    static final int size = 10;
    static int[] next = new int[size];
    static int[] key = new int[size];
    static int[] prev = new int[size];
    static int head;

    static
    {
        head = 0;
        for(int i = 0; i < size; i++)
        {
            next[i] = -1;
            prev[i] = -1;
            key[i] = -1;
        }
    }

    public static void main(String[] args)
    {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        printList();

        System.out.println(search(20));
        System.out.println(search(50));

        delete(20);
        printList();
    }

    private static void printList()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.println(prev[i] + ":" + key[i] + ":" + next[i]);
        }
    }

    private static void insert(int value)
    {
        if(head+1 < size-1)
        {
            key[head+1] = value;
            next[head] = head+1;
            prev[head+1] = head;
            head++;
        }
    }

    private static int search(int value)
    {
        int result = head;
        while (key[result] != -1 && key[result] != value)
        {
            result = prev[result];
        }
        return result;
    }

    private static void delete(int value)
    {
        int index = search(value);
        if(index != 0)
        {
            key[index] = -1;
            next[prev[index]] = next[index];
            prev[next[index]] = prev[index];
            next[index] = -1;
            prev[index] = -1;
        }
    }
}
