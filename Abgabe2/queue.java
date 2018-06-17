

public class queue {
	public class Node {
		private Node next;
		private String data;
		
		public Node(String key){
			next = null;
			data = key;
		}
	}
	
	public class List{
		Node head;
		public List(){
			head = null;
		}
		
		public void insert(String x){
			if(head == null){
				head = new Node(x);
			} else if(head.data.length() > x.length()){
				head = new Node(x);
			}else {
				Node n = head;
				while(n.next != null){
					if(n.next.data.length() < x.length() || n.next == null){
						n.next = new Node(n.next.data);
					} else{
						n = n.next;
					}
				}
			}
		}
		
		public Node min(){
			return head;
		}
		
		public Node getMin(){
			Node old = head;
			head = head.next;
			return old;
		}
		
		public void replaceMin(String x){
			head = new Node(x);
		}
	}
	

}
