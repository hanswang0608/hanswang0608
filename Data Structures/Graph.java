import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		System.out.print("Please Enter the Total Number of Nodes: ");
		Scanner s = new Scanner(System.in);
		int total = s.nextInt();
		s.nextLine();
		
		for (int i = 0; i < total; i++) {
			graph.add(new ArrayList<Integer>());
			System.out.print("Enter the nodes that are connected to Node " + (i+1) + ": ");
			String a = s.nextLine();
			String[] tokens = a.split("\\s+");
			for (int j = 0; j < tokens.length; j++) {
				graph.get(i).add(Integer.parseInt(tokens[j]));
			}
		}
		
		for (int i = 0; i < graph.size(); i++) {
			String str = "Node " + (i + 1) + " is connected to: ";
			for (int j = 0; j < graph.get(i).size(); j++) {
				str += graph.get(i).get(j) + " ";
			}
			System.out.println(str);
		}
		
	}
}
