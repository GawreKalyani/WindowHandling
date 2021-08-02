package collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashmapExa {
public static void main(String[] args) {
	HashMap<String,String>hs=new HashMap<String,String>();
	hs.put("hh","kk");
	hs.put("", "klhp");
	hs.put("ooo","ppp");
	hs.put("l", "tr444");
	hs.put("l", "TTtr444");
	hs.put("uuu","yy");        //One null key is allowed and multiple null value allowed
	System.out.println("Printing hashmap");  // for 2 null updated key is accepted
	System.out.println(hs);
	
	System.out.println("iterating by foreach loop:");
	Set<String>keys=hs.keySet();
	for (String string : keys) {
		System.out.println(string+" ->"+hs.get(string));
	}
	
	System.out.println("iterating by iterator:");
	Iterator<String>it=keys.iterator();	
	while(it.hasNext()){
		String key=it.next();
		System.out.println(key+" -> "+hs.get(key));
	}
	
	System.out.println("iterating by entrySet:");
	Set<Entry<String, String>>hh=hs.entrySet();
	for (Entry<String, String> entry : hh) {
		System.out.println(entry);
	}
}
}
