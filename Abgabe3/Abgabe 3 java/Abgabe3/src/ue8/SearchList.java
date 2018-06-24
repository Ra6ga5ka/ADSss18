package ue8;

import java.util.Iterator;


import de.medieninf.ads.ADSTool;



public class SearchList<T extends Comparable<T>> implements SList<T>{
	public Node<T> head;
	public int length;
	
	public SearchList(){
		this.head = null;
		this.length = 0;
	}
	
	
	public class Node<TT>  {
		public Node<TT> next;
		public TT data;
		public int occurance;
		
		public Node(TT data,Node<TT> next){
			this.data =  data;
			this.next = next;
			this.occurance = 1;
		}
	}
	

	public void add(T t) {
		if(head == null){		// Wenn Liste leer ist
			head = new Node<T>(t,null);
			length++;
			
			} else if(head.data.compareTo(t) >0){	//Wenn erstes Listenelement größer als das Einzufügende
			Node<T> n = new Node<T>(t,head);
			head = n;
			length++;
			
			} else if(head.data.compareTo(t) == 0){ //Wenn Element am Anfang der Liste = des Einzufügenden
			head.occurance++;
			
		} else {
			
			Node<T> n = head;
			for(int i = 0;i<length;i++){ //Suchen Stelle zum einfügen 
				if(n.next == null || n.next.data.compareTo(t)  >= 0){		
				} else {
					n = n.next;
				}
			}	
			
		if(n.next!= null && n.next.data.compareTo(t) == 0){	//Wenn Element = einzufügendes
			n.next.occurance ++;
			return;
		} else {
			Node<T> newNode = new Node<T>(t, n.next);
			n.next = newNode;
			length++;
		}
	}
	
}
	
	public int noOccurences() {
		Node<T> n = head;
		int allOccurences = 0;
		while(n != null){
			allOccurences += n.occurance;
			n = n.next;
		}
		return allOccurences;
	}

	@Override
	public int noWords() {
		return length;
	}
	
	@Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
               T data;
               data = current.data;
               current = current.next;
               return data;
            }
        };
    }

	@Override
	public int count(T t) {
		if(head.data.compareTo(t) == 0) return head.occurance;
		Node<T> current = head;
		while(current.next != null &&current.next.data.compareTo(t) != 0 ){
			current = current.next;
		}
		if(current.next == null) return 0;
		else  return current.next.occurance;
	}

	
	@Override
	public boolean remove(T t) {
		Node<T> n = head;
		for(int i = 0;i<length;i++){ 
			if(n.next == null || n.next.data.compareTo(t)  == 0){		
			} else {
				n = n.next;
			}
		}
		if(n.next == null)return false;	
		else{
			n.next = n.next.next;
			return true;
		}
	}
	
	public void sysout(){
		Node<T> n = head;
		while(n != null){
			System.out.println(n.data.toString());;
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		SearchList<String> list = new SearchList<String>();
		String [] txt = ADSTool.readWordArray("RAJSorted.txt");

		list.add("d");
		list.add("e");
		list.add("c");
		list.add("g");
		list.add("b");
		list.add("c");
		list.add("c");
		System.out.println(list.count("c"));
		list.remove("c");
		System.out.println(list.count("c"));
		list.sysout();


	}

}

