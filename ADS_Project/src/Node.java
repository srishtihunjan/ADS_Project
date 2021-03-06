import java.util.ArrayList;
import java.util.Iterator;

public class Node implements Comparable<Node> {
	int frequency;
	int key;
	Node leftChild;
	Node rightChild;
	Node parent;
	StringBuilder path;

	public Node(int frequency, int key) {
		this.leftChild = null;
		this.rightChild = null;
		this.frequency = frequency;
		this.key = key;
		this.parent = null;
		this.path = new StringBuilder();
	}

	public int compareTo(Node n) {
		if (this.frequency > n.frequency)
			return 1;
		else if (this.frequency < n.frequency)
			return -1;
		else
			return 0;
	}

	public String toString() {
		return Integer.toString(frequency) + " " + Integer.toString(key);
	}

	public static void printArray(ArrayList<Node> node_array) {

		Iterator itr = node_array.iterator();
		while (itr.hasNext()) {
			Node element = (Node) itr.next();
			System.out.println(element.key + ": " + element.frequency + " -- " + element.path.toString());
		}
	}

	public static void printTree(ArrayList<Node> node_array) {

		PrintTreeDFS(node_array.get(0));
	}

	public static void PrintTreeDFS(Node root) {
		if (root.leftChild != null)
			PrintTreeDFS(root.leftChild);
		System.out.println(root.key + ":" + root.frequency + " -- " + root.path.toString());
		if (root.rightChild != null)
			PrintTreeDFS(root.rightChild);
	}
}