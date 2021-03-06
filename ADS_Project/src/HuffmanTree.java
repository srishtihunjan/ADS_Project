import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanTree {

	static HashMap<Integer,String> codeTable = new HashMap<Integer,String>();
	
	public static ArrayList<Node> createHuffmanTreeFromBinaryHeap(ArrayList<Node> binaryHeap) {

		while (binaryHeap.size() > 1) {
			Node element1 = MinHeap.Removemin(binaryHeap);
			Node element2 = MinHeap.Removemin(binaryHeap);
			Node element = new Node(element1.frequency + element2.frequency, -1);
			element.leftChild = element1;
			element1.parent = element;
			element.rightChild = element2;
			element2.parent = element;

			MinHeap.Insert(binaryHeap, element);
		}
		return binaryHeap;
	}

	public static void assignCodes(Node root) {
		if (root.parent != null && root == root.parent.leftChild) {
			root.path.append(root.parent.path);
			root.path.append("0");
		}
		if (root.parent != null && root == root.parent.rightChild) {
			root.path.append(root.parent.path);
			root.path.append("1");
		}
		if (root.leftChild != null)
			assignCodes(root.leftChild);
		if (root.leftChild != null)
			assignCodes(root.rightChild);
	}
	
	public static HashMap<Integer,String> buildCodeTable(Node root){
		if (root.leftChild != null)
			buildCodeTable(root.leftChild);
		if(root.key!=-1){
			//insert into a hashmap
			codeTable.put(root.key, root.path.toString());
		}
		if (root.rightChild != null)
			buildCodeTable(root.rightChild);
		
		return codeTable;
	}

}
