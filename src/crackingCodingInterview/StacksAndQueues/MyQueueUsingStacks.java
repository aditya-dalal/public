package crackingCodingInterview.StacksAndQueues;

import java.util.Stack;

public class MyQueueUsingStacks
{
    Stack<Integer> head;
    Stack<Integer> tail;

    public MyQueueUsingStacks()
    {
        head = new Stack<Integer>();
        tail = new Stack<Integer>();
    }

    public void insert(int value)
    {
        tail.push(value);
    }

    public Integer remove()
    {
        if(head.size() != 0)
            return head.pop();

        while (!tail.empty())
            head.push(tail.pop());

        if(!head.empty())
            return head.pop();
        return null;
    }

    public Integer peek()
    {
        if(head.size() != 0)
            return head.peek();

        while (!tail.empty())
            head.push(tail.pop());

        if(!head.empty())
            return head.peek();
        return null;
    }

    public static void main(String[] args)
    {
        MyQueueUsingStacks queue = new MyQueueUsingStacks();
        System.out.println(queue.remove());
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.insert(40);
        System.out.println(queue.remove());
        System.out.println(queue.peek());
    }

}