
public class Queue {
	private Node head;
	private Node tail;
	private int counter = 0;	
	
	public Queue() {}
	
	public Queue(int i)
	{
		head = tail = new Node(i, null);
		counter++;
	}
	
	public void queue(int i)
	{
		if (counter == 0)
		{
			head = tail = new Node(i, null);
		}
		else
		{
			tail = new Node(i, tail);
		}
		counter++;
	}
	
	public void dequeue()
	{
		if (counter <= 1)
		{
			head = null;
			tail = null;
			counter = 0;
		}
		else
		{
			Node tempNode = tail;
			for (int i = 0; i < counter -2; i++)
			{
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(null);
			head = tempNode;
			counter--;
		}
	}
	
	public int peek()
	{
		return counter == 0 ? 0 : head.getValue();
	}
	
	public void clear() 
	{
		head = tail = null;
		counter = 0;
	}
	
	public String toString()
	{
		String out = "Queue: ";
		Node tempNode = tail;
		while(tempNode != null)
		{
			out += tempNode.getValue() + " ";
			tempNode = tempNode.getNext();
		}
		return out;
	}
	
	public static void directMerge(Queue q1, Queue q2)
	{
		q2.head.setNext(q1.tail);
		q2.head = q1.head;
		q1.tail = q2.tail;
		q1.counter = q2.counter = q1.counter + q2.counter;
	}
	
	public static Queue alternateMerge(Queue q1, Queue q2)
	{
		Queue q = new Queue();
		int q1counter = q1.counter;
		int q2counter = q2.counter;
		while(q1counter > 0 && q2counter > 0)
		{
			q.queue(q1.head.getValue());
			q1.dequeue();
			q.queue(q2.head.getValue());
			q2.dequeue();
			q1counter--;
			q2counter--;
		}
		while(q1counter > 0)
		{
				q.queue(q1.head.getValue());
				q1.dequeue();
		}	
		while(q2counter > 0)
		{
			q.queue(q2.head.getValue());
			q2.dequeue();
		}
		return q;
	}
	
	public static void main(String[] args)
	{
		Queue q = new Queue(6);
		
		Queue q2 = new Queue(17);
		q2.queue(1);
		q2.queue(8);
		
		directMerge(q, q2);
		System.out.println(q);
	}
}
