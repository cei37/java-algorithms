package cei37.java;

import java.util.*;

public class MyHashSet {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(5);
		hs.add(1);
		hs.add(8);
		hs.add(10);
		hs.add(15);

		Iterator<Integer> it = hs.iterator();
		while(it.hasNext()) 
			System.out.println(it.next());
		
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("Armada");
		list.add("Green");
		list.add(null);
		list.add("red");
		list.add("ahhh");
		list.add("Green");
		
		HashSet<String> hs2 = new HashSet<String>(list);
		Iterator<String> it2 = hs2.iterator();
		while(it2.hasNext())
			System.out.println(it2.next());
		
		System.out.println("##########");
		for (String s: hs2) {
			System.out.println(s);
		}
	}
}
