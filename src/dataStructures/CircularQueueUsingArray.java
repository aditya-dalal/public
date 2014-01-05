package dataStructures;

public class CircularQueueUsingArray
{
    public static void main(String[] args)
    {
        Queue queue = new Queue(5);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printElements();
        System.out.println(queue.dequeue());
        queue.printElements();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.printElements();
    }
}
