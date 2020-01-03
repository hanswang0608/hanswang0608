
public class Node {
	private int value;
	private Node next;
	private Node previous;
	
	public void setValue(int v)
	{
		value = v;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public void setPrevious(Node n)
	{
		previous = n;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public Node getPrevious()
	{
		return previous;
	}
	
	public Node(int v, Node n)
	{
		value = v;
		next = n;
	}
	
	public void recursivePrint(Node n)
	{
		System.out.println(n.getValue());
		if (n.getNext() == null)
		{
			return;
		}
		else
		{
			recursivePrint(n.getNext());
		}
	}
}
