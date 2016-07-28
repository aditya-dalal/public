package crackingCodingInterview.StacksAndQueues;

public class ThreeStacksInOneArray
{
	static int[] array = new int[9];
	static int index[] = {-1, -1, -1};
	static int offset = array.length / 3;

	public static void main(String[] args)
	{
        push(0, 10);
        push(0, 11);
        push(0, 12);
        push(0, 13);
        push(1, 20);
        push(1, 21);
        push(2, 30);
        push(2, 31);
        push(2, 32);
        push(2, 33);

        System.out.println(pop(1));
        System.out.println(pop(1));
        System.out.println(pop(1));
        System.out.println(pop(2));
        System.out.println(pop(0));

	}

	public static void push(int stack, int value)
	{
		int top = stack * offset + index[stack];
		int endIndex = (stack+1) * offset;

		if(top == endIndex-1)
		{
			System.out.println("Stack is full");
			return;
		}

		array[++top] = value;
		index[stack]++;
	}

	public static int pop(int stack)
	{
		int top = (stack * offset) + index[stack];

		if(top < stack * offset)
		{
			System.out.println("Stack is empty");
			return Integer.MAX_VALUE;
		}

		index[stack]--;
		return array[top];
	}
}