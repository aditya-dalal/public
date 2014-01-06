package dataStructures;

public class CircularQueueUsingArray
{
    public static void main(String[] args)
    {
        ShiftingQueue sQueue = new ShiftingQueue(5);
        sQueue.enqueue(0);
        sQueue.enqueue(1);
        sQueue.enqueue(2);
        sQueue.enqueue(3);
        sQueue.enqueue(4);
        sQueue.enqueue(5);
        sQueue.printElements();
        System.out.println(sQueue.dequeue());
        System.out.println(sQueue.dequeue());
        sQueue.printElements();
        sQueue.enqueue(6);
        sQueue.enqueue(7);
        sQueue.enqueue(8);
        sQueue.printElements();

        System.out.println("\n####################\n");

        Queue queue = new Queue(5);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printElements();
        queue.dequeue();
        queue.dequeue();
        queue.printElements();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.printElements();

        System.out.println("\n####################\n");

        Queue queue1 = new Queue(5);
        queue1.enqueue(0);
        queue1.enqueue(1);
        queue1.printElements();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.enqueue(3);
        queue1.printElements();
    }
}
