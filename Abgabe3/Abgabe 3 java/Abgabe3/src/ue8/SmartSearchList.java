package ue8;



import java.util.Iterator;

import de.medieninf.ads.ADSTool;

public class SmartSearchList<T extends Comparable<T>> implements SList<T>{
    public int height;
    public Node<T> head;
    public int lenght;
    
    
    public  SmartSearchList(){
    	this.height = 30;
    	this.head = new Node<T>(height);
    	this.lenght = 0;
    }

    public  class Node<TT> {
        Node<TT>[] next;
        TT data;
        int occurance = 1;

        Node(int length){
            next = new Node[30];
            occurance = 0;
        }
        Node(TT data, int size){
            this.next = new Node[size];
            this.data = data;
        }

    }

    @Override
    public void add(T t) {

    }

    @Override
    public int count(T t){
            return 0;
    }

    @Override
    public boolean remove(T t) {
        return false;
    }

    @Override
    public int noOccurences() {

        return 0;
    }

    @Override
    public int noWords() {
		return 0;

    }

    @Override
    public Iterator<T> iterator() {
		return null;

    }

    public static int getHeight(){
        int height = 1;
        while (Math.random() < 0.5 && height < 30) { height += 1; }
        return height;
    }
    
	public void sysout(){
		Node<T> n = head.next[0];
		while(n != null){
			System.out.println(n.data.toString());;
			n = n.next[0];
			
		}
	}
	public static void main(String[] args) {
		SmartSearchList<String> list = new SmartSearchList<String>();
		String [] txt = ADSTool.readWordArray("RAJSorted.txt");

//		for (int i = 0; i < txt.length; i++) {
//			list.add(txt[i]);
//		}

		list.add("b");
		list.add("a");
		list.add("b");
		list.sysout();
		//System.out.println(list.count("c"));
	}
}
