public class BT {
	private BTNode root;
	
	public BT() {root = null;}
	
	public BT(int i) {root = new BTNode(i);}
	
	public void clear()
	{
		root = null;
	}
	
	public void add(int v)
	{
		if (root == null) {root = new BTNode(v);}
		else addRecursion(root, v);
	}
	
	private void addRecursion(BTNode node, int v)
	{
		if (v < node.getValue())
		{
			if (node.getLeft() == null)
			{
				node.setLeft(new BTNode(v));
			}
			else {addRecursion(node.getLeft(), v);}
		}
		else if (v > node.getValue())
		{
			if (node.getRight() == null)
			{
				node.setRight(new BTNode(v));
			}
			else {addRecursion(node.getRight(), v);}
		}
	}
	
	public String toString()
	{
		return "Binary Tree: " + toStringRecursion(root);
	}
	
	private String toStringRecursion(BTNode node)
	{
		String s = "";
		if (node == null) {return "";}
		s += toStringRecursion(node.getLeft());
		s += node.getValue() + " ";
		s += toStringRecursion(node.getRight());
		return s;
	}
	
	public int average()
	{
		return sum(root) / count(root);
	}
	
	public int sum(BTNode node)
	{
		int total = 0;
		if (node == null) return 0;
		total += sum(node.getLeft());
		total += node.getValue();
		total += sum(node.getRight());
		return total;
	}
	
	public int count(BTNode node)
	{
		if (node == null) return 0;
		else
		{
			return 1 + count(node.getLeft()) + count(node.getRight());
		}
	}
	
	public static void main(String[] args)
	{
		BT bt = new BT(15);
		bt.add(8);
		bt.add(3);
		bt.add(9);
		bt.add(12);
		bt.add(18);
		bt.add(16);
		bt.add(14);
		System.out.println(bt);
	}
}
