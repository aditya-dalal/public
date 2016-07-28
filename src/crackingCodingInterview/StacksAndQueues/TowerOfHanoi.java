package crackingCodingInterview.StacksAndQueues;

import java.util.Stack;

public class TowerOfHanoi
{
	public static void main(String[] args)
	{
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		Stack<Character> stack3 = new Stack<Character>();

		stack1.push('a');
		stack1.push('b');
		stack1.push('c');
		stack1.push('d');
		stack1.push('e');

        int disks = stack1.size();
		towerOfHanoi(disks, stack1, stack2, stack3);

		for(int i = 0; i < disks; i++)
			System.out.println(stack3.pop());
	}

	public static void towerOfHanoi(int disks, Stack<Character> s1, Stack<Character> s2, Stack<Character> s3)
	{
        if(disks == 0)
            return;
		towerOfHanoi(disks-1, s1, s3, s2);
        s3.push(s1.pop());
        towerOfHanoi(disks-1, s2, s1, s3);
	}
}