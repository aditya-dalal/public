package dataStructures;

public class Queue
{
    private Integer[] queue;
    private int head;
    private int tail;
    private int size;
    private int count;

    public Queue(int size)
    {
        initialize(size);
    }

    private synchronized void initialize(int size)
    {
        queue = new Integer[size];
        this.size = size;
        head = 0;
        tail = -1;
        count = 0;
    }

    public synchronized void enqueue(int value)
    {
        if(tail == -1)
            tail++;
        else if(tail + 1 > size - 1)
        {
            if(head == 0)
            {
                System.out.println("Queue is full");
                return;
            }
            else
                tail = 0;
        }
        else if(tail + 1 == head)
        {
            System.out.println("Queue is full");
            return;
        }
        else
            tail++;

        queue[tail] = value;
        count++;
    }

    public synchronized void dequeue()
    {
        Integer value = null;
        if(count != 0)
        {
            value = queue[head];
            queue[head] = null;
            if(head + 1 > size - 1)
            {
                if(tail == 0)
                    System.out.println("Queue is empty");
                else
                    head = 0;
            }
            else if(head + 1 > tail)
                System.out.println("Queue is empty");
            else
                head++;
            count--;
        }
    }

    public void printElements()
    {
        System.out.println("head: " + head + " tail: " + tail);

        int temp = head;
        for(int i = 0; i < size; i++)
        {
            System.out.println(temp + ": " + queue[temp]);
            if(temp == size - 1)
                temp = 0;
            else
                temp++;
        }
    }
}
