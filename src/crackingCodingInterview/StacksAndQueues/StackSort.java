package crackingCodingInterview.StacksAndQueues;

import java.util.Stack;

public class StackSort
{
	public static void main(String[] args)
	{
		Stack<Integer> s1 = new Stack<Integer>();

        s1.push(30);
        s1.push(10);
        s1.push(40);
        s1.push(20);
        s1.push(50);

		sortStack(s1);
		while(!s1.empty())
			System.out.println(s1.pop());
	}

	public static void sortStack(Stack<Integer> s1)
	{
		Stack<Integer> s2 = new Stack<Integer>();

		while(!s1.empty())
		{
			int val = s1.pop();
			if(s2.empty())
			{
				s2.push(val);
				continue;
			}

			while(!s2.empty() && s2.peek() > val)
				s1.push(s2.pop());
			s2.push(val);
		}

		while(!s2.empty())
			s1.push(s2.pop());
	}
}