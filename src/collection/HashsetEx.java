package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashsetEx {
public static void main(String[] args) {
	HashSet<String>hs=new HashSet<>();
	hs.add("jas");
	hs.add("jas"); //if value gets repeated ,it takes updated one
	hs.add("");
	hs.add("");
	hs.add("Jas"); //one null value is allowed
	System.out.println(hs);
	
	
	System.out.println("Iterator se iterate karo");
	Iterator<String>it=hs.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	
	System.out.println("For each se iterate karo");
	for(String s:hs){
		System.out.println(s);
	}
}
}
