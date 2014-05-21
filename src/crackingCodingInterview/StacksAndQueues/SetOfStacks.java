package crackingCodingInterview.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks<T>
{
    List<T[]> stackSet = new ArrayList<T[]>();
    int threshold;
    int index;

    public SetOfStacks(int threshold)
    {
        this.threshold = threshold;
        createStack();
    }

    private void createStack()
    {
        T[] stack = (T[]) new Object[threshold];
        stackSet.add(stack);
        index = -1;
    }

    public void push(T value)
    {
        if(index + 1 == threshold)
            createStack();
        int lastStack = stackSet.size() - 1;
        stackSet.get(lastStack)[++index] = value;
    }

    public T pop()
    {
        if(stackSet.size() == 1 && index < 0)
        {
            System.out.println("Stack is empty");
            return null;
        }

        if(index < 0)
        {
            stackSet.remove(stackSet.size() - 1);
            index = threshold - 1;
        }
        return stackSet.get(stackSet.size() - 1)[index--];
    }

    public T popAt(int stack)
    {
        if(stack < 0 || stack >= stackSet.size())
        {
            System.out.println("Invalid stack");
            return null;
        }

        if(stack == stackSet.size() - 1)
            return stackSet.get(stack)[index--];

        T value = stackSet.get(stack)[threshold-1];
        shiftStacks(stack);
        return value;
    }

    private void shiftStacks(int stack)
    {
        while(stack < stackSet.size() - 1)
        {
            stackSet.get(stack)[threshold - 1] = stackSet.get(stack + 1)[0];
            stack++;
            int i = 0, limit;
            if(stack == stackSet.size() - 1)
                limit = index;
            else
                limit = threshold - 1;
            while(i < limit)
                stackSet.get(stack)[i] = stackSet.get(stack)[++i];
        }
        if(--index < 0)
        {
            stackSet.remove(stackSet.size() - 1);
            index = threshold - 1;
        }
    }

    public static void main(String[] args)
    {
        SetOfStacks<Integer> stacks = new SetOfStacks<Integer>(3);

        System.out.println(stacks.pop());
        stacks.push(10);
        stacks.push(20);
        stacks.push(30);
        stacks.push(40);
        stacks.push(50);
        stacks.push(60);
        stacks.push(70);
        System.out.println(stacks.popAt(1));
        System.out.println(stacks.popAt(-1));
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.popAt(0));
        System.out.println(stacks.pop());

    }
}