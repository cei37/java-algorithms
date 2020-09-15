package cei37.java;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class MyTreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>(); 
		set.add(8);
		set.add(2);
		set.add(5);
		set.add(7);
		set.add(6);
		set.add(1);
		
		
		for (Integer n : set) 
			System.out.println(n);
		
		
		
		Comparator<String> com = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		};
		
		System.out.println("------ Comparator -------");
		
		TreeSet<String> set2 = new TreeSet<String>(com); 
		set2.add("Hello");
		set2.add("Blue");
		set2.add("@");
		set2.add("arrg");
		set2.add("yeah");
		set2.add("Arg");
		set2.add("Azul");
		set2.add("$");
		set2.add("3");
		set2.add("1");
		set2.add("8");
		
		
		Iterator<String> it = set2.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
	}

}
