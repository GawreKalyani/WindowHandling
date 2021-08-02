package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class ArraylistEx {
public static void main(String[] args) {
	ArrayList<Integer>al=new ArrayList<Integer>();
	al.add(88);
	al.add(34);
	al.add(23);
	al.add(22);
	System.out.println(al);
	System.out.println("First Index"+" : "+al.get(1));
	
	System.out.println("For Each loop");
	for(Integer s:al){
		System.out.println(s);
	}
	
	System.out.println("Iterator");
	Iterator<Integer>it=al.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	System.out.println("ListIterator");
	ListIterator<Integer>ls=al.listIterator();
	while(ls.hasNext()){
		System.out.println(ls.next());
	}
}
}
