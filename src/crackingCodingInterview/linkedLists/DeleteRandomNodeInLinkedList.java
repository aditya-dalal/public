package crackingCodingInterview.linkedLists;

public class DeleteRandomNodeInLinkedList
{
	public static void main(String[] args)
	{
		LinkedList<Integer> a = new LinkedList<Integer>(3);
		LinkedList<Integer> b = new LinkedList<Integer>(1);
		LinkedList<Integer> c = new LinkedList<Integer>(2);
		LinkedList<Integer> d = new LinkedList<Integer>(4);
		LinkedList<Integer> e = new LinkedList<Integer>(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		printList(a);
		deleteNodeInMiddleOfList(d);
		printList(a);
	}

	public static <T> void deleteNodeInMiddleOfList(LinkedList<T> node)
	{
		if(node != null && node.next != null)
		{
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}

	public static <T> void printList(LinkedList<T> list)
	{
		while(list != null)
		{
			System.out.print(list.data + ", ");
			list = list.next;
		}
		System.out.println();
	}
}
