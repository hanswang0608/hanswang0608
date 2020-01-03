public class LinkedList {
	private Node head;
	private Node tail;
	
	public LinkedList(int value)
	{
		head = new Node(value, null);
		tail = head;
	}
	
	public void add(int value)
	{
		if (head == null)
		{
			head = new Node(value, null);
			tail = head;
		}
		else
		{
		Node newNode = new Node(value, null);
		tail.setNext(newNode);
		tail = newNode;
		}
	}
	
	public int length()
	{
		int total = 0;
		Node tempNode = head;
		while (head != null)
		{
			total++;
			tempNode = tempNode.getNext();
		}
		return total;
	}
	
	public int getVal(int pos)
	{
		if (head == null)
		{
			return 0;
		}
		if (pos == 0)
		{
			return head.getValue();
		}
		
		int counter = 0;
		Node tempNode = head;
		while (tempNode != null)
		{
			counter++;
			if (counter == pos)
			{
				if (tempNode.getNext() == null)
				{
					return 0;
				}
				else 
				{
					return tempNode.getNext().getValue();
				}
			}
			tempNode = tempNode.getNext();
		}
		return 0;
	}
	
	public Node getNode(int pos)
	{
		if (head == null)
		{
			return null;
		}
		if (pos == 0)
		{
			return head;
		}
		
		int counter = 0;
		Node tempNode = head;
		while(tempNode != null)
		{
			counter++;
			if (counter == pos)
			{
				return tempNode.getNext();
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	public void add(int value, int pos)
	{
		if (head == null)
		{
			head = new Node(value, null);
			tail = head;
			return;
		}
		if (pos == 0)
		{
			head = new Node(value, head);
			return;
		}
		
		int counter = 0;
		Node tempNode = head;
		while(tempNode != null)
		{
			counter++;
			if (counter == pos)
			{
				tempNode.setNext(new Node(value, tempNode.getNext()));
				return;
			}
			tempNode = tempNode.getNext();
		}
	}
	
	public String toString()
	{
		String s = "";
		Node tempNode = head;
		while(tempNode != null)
		{
			s += tempNode.getValue() + " ";
			tempNode = tempNode.getNext();
		}
		return s;
	}
	
	public void remove(int pos)
	{
		if (head == null)
		{
			return;
		}
		if (pos == 0)
		{
			head = head.getNext();
			return;
		}
		
		if (getNode(pos) == null) {}
		else if (getNode(pos).getNext() == null)
		{
			tail = getNode(pos-1);
			getNode(pos-1).setNext(null);
		}
		else
		{
			getNode(pos-1).setNext(getNode(pos+1));
		}
	}
	
	public void clear()
	{
		head = tail = null;
	}
	
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList(5);
		l.add(7);
		l.add(9);
		System.out.println(l);
		l.remove(2);
		System.out.println(l);
	}
}