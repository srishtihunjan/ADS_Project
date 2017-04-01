import java.util.ArrayList;

public class HuffmanTree {

	public static ArrayList<Node> createHuffmanTreeFromBinaryHeap (ArrayList<Node> binaryHeap) {
		
		while (binaryHeap.size() > 1) {
			Node element1 = Minheap.Removemin(binaryHeap);
			Node element2 = Minheap.Removemin(binaryHeap);
			Node element = new Node(element1.frequency + element2.frequency, -1);
			element.leftChild = element1;
			element.rightChild = element2;
			Minheap.Insert(binaryHeap,element);
		}
		return binaryHeap;
	}

}