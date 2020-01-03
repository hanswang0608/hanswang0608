import java.util.Scanner;

public class Stack {
	private Node top;
	private int counter = 0;
	
	public Stack() {}
	
	public Stack(int i)
	{
		top = new Node(i, null);
		counter ++;
	}
	
	public void push(int i)
	{
		top = new Node(i, top);
		counter ++;
	}
	
	public void pop()
	{
		if (counter > 0)
		{
			top = top.getNext();
			counter--;
		}
	}
	
	public int peek()
	{
		return top == null ? 0 : top.getValue();
	}
	
	public String toString()
	{
		String s = "Stack: ";
		Node tempNode = top;
		while(tempNode != null)
		{
			s += tempNode.getValue() + " ";
			tempNode = tempNode.getNext();
		}
		return s;
	}
	
	public void clear()
	{
		top = null;
		counter = 0;
	}
	
	public int sum()
	{
		int total = 0;
		Node tempNode = top;
		while (tempNode != null)
		{
			total += tempNode.getValue();
			tempNode = tempNode.getNext();
		}
		return total;
	}
	
	public int average()
	{
		int total = 0;
		Node tempNode = top;
		for (int i = 0; i < counter; i++)
		{
			total += tempNode.getValue();
			tempNode = tempNode.getNext();
		}
		return total / counter;
	}
	
	public static void program(Stack s)
	{
		Stack mountain = s;
		Stack branch = new Stack();
		int count = 1;
		while(mountain.top != null || branch.top != null)
		{
			if (mountain.peek() == count)
			{
				mountain.pop();
				count ++;
			}
			else
			{
				if (branch.peek() == count)
				{
					branch.pop();
					count ++;
				}
				else if (mountain.top != null)
				{
					branch.push(mountain.peek());
					mountain.pop();
				}
				else
				{
					System.out.println("N");
					return;
				}
			}
		}
		System.out.println("Y");
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++)
		{
			int n = s.nextInt();
			Stack stack = new Stack();
			for (int j = 0; j < n; j++)
			{
				stack.push(s.nextInt());
			}
			program(stack);
		}
	}
}
