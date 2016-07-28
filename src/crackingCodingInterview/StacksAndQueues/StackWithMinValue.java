package crackingCodingInterview.StacksAndQueues;

public class StackWithMinValue
{
	public static void main(String[] args)
	{
		Stack stack = new Stack(5);
		stack.push(3);
		System.out.println(stack.min());
		stack.push(2);
		stack.push(6);
		System.out.println(stack.min());
		stack.push(1);
		stack.push(3);
		stack.push(7);

		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.min());
	}

}

class Stack
{
	int[] stack;
	int[] minStack;
	int index, minStackIndex;

	public Stack(int size)
	{
		stack = new int[size];
		minStack = new int[size];
		minStackIndex = 0;
		minStack[minStackIndex] = Integer.MAX_VALUE;
		index = -1;
	}

	public void push(int value)
	{
		if(index == stack.length - 1)
		{
			System.out.println("Stack is full");
			return;
		}
		index++;
		stack[index] = value;
		if(value <= minStack[minStackIndex])
		{
			minStackIndex++;
			minStack[minStackIndex] = value;
		}
	}

	public int pop()
	{
		if(index < 0)
		{
			System.out.println("Stack is empty");
			return Integer.MAX_VALUE;
		}
		if(minStack[minStackIndex] == stack[index])
			minStackIndex--;
		return stack[index--];
	}

	public int min()
	{
        if(minStackIndex == 0)
            System.out.println("Stack is empty");
        return minStack[minStackIndex];
	}
}
