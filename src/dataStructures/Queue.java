package dataStructures;

public class Queue
{
    private Integer[] queue;
    private int head = 0;
    private int tail = 0;
    private int size;
    private int iteration = 0;

    public Queue(int size)
    {
        queue = new Integer[size];
        this.size = size;
    }

    public synchronized void enqueue(int value)
    {
        queue[tail] = value;
        incrementTail();
    }

    public synchronized int dequeue()
    {
        int value = queue[head];
        queue[head] = null;
        if(head + 1 > size - 1)
            head = 0;
        else
            head++;
        return value;
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

    private void incrementTail()
    {
        if(iteration == 0)
        {
            if(tail + 1 > size - 1)
                tail = 0;
            else
                tail++;
            iteration++;
        }
        else
        {
            if(tail == head)
            {
                if(tail + 1 > size - 1)
                    tail = 0;
                else
                    tail++;
                head = tail;
            }
            else
            {
                if(tail + 1 > size - 1)
                    tail = 0;
                else
                    tail++;
            }
        }
    }

}
