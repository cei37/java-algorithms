package cei37.java;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class MyLinkedHashSet {

	public static void main(String[] args) {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
		lhs.add(5);
		lhs.add(3);
		lhs.add(7);
		lhs.add(2);
		lhs.add(null);
		lhs.add(10);
		lhs.add(3);
		
		for (Integer n: lhs) {
			System.out.println(n);
		}
		
		Iterator<Integer> it = lhs.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
