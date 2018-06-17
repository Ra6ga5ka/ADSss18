import java.util.LinkedList;

import de.medieninf.ads.ADSTool;



public class aufg2 {

		public class Node {
			private Node next,parent;
			private int data;
			
			public Node(int key){
				next = null;
				parent = null;
				data = key;
			}
		}
	
	public  int [] findPair(int x,LinkedList<Integer> list){
		int [] returns = new int [2];
		int start = x/2;
		Node a = null;
		Node b = null;
		
		for (Integer integer : list) {
			if(integer >= start){
				a = new Node(integer);
				b = new Node(integer);
				break;
			}
			while((a.data +b.data) != x){
				if((a.data + b.data) > x){
					if(a.parent == null);
					else a = a.parent;
				} else if((a.data +b.data)<x){
					if(b.next == null);
					else b = b.next;
				}

			}
		}
		returns[0] = a.data;
		returns[1] = b.data;
		return returns;
	}
}

