package cei37.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.*;
import java.util.function.UnaryOperator;


public class MyLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(5);
		list.add(30);
		list.add(1);
		list.add(2);
		list.addLast(15);
		list.add(10);
		list.add(3);
		list.add(4);
		list.addFirst(8);
		

		Iterator<Integer> it = list.iterator();
		for (;it.hasNext();) {
			System.out.println(it.next());
		}
		
		Comparator<Integer> sortAsc = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2) return 1;
				if (o1 > o2) return -1;
				return 0;
			}
		};
		
		list.sort(sortAsc);
		
		
		
		System.out.println(list.contains(11));
		
		
		System.out.println(list);
		
		Iterator<Integer> it2 = list.descendingIterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		System.out.println("List iterator");
		Iterator<Integer> it3 = list.listIterator(5);
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		System.out.println("Arrays");
		Integer[] arr = new Integer[list.size()];
		list.toArray(arr);
		
		for (Integer i: arr)
			System.out.println(i);
		
		System.out.println("Arrays2");
		Object[] arr2 = list.toArray();
		
		for (Object i: arr2)
			System.out.println(i);
		
		
		System.out.println("UnaryOperator");
		UnaryOperator<Integer> o = t -> t * 2;
		list.replaceAll(o);
		System.out.println(list);
		
		System.out.println("Collections");
		Collections.sort(list, sortAsc);
		System.out.println(list);
		
		
		System.out.println("----------");
		
		
	}
}
