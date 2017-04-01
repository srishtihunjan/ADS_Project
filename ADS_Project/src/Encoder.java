import java.util.*;

public class Encoder {

	public static void MinHeapEncoder(ArrayList<Integer> ipTable, HashMap<Integer,String> cTable){
		Iterator i = ipTable.iterator();
		while(i.hasNext()){
			int temp = (int) i.next();
			System.out.println(temp + " == "+ cTable.get(temp));
		}
	}
	
}
