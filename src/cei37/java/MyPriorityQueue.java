package cei37.java;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.lang.*;

public class MyPriorityQueue {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(/*new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 > o2 ? -1 : 1;
			}
			
		}*/);
		pq.add(10);
		pq.add(5);
		pq.add(4);
		pq.add(8);
		pq.add(15);
		pq.add(3);
		
		System.out.println(pq);
		Iterator<Integer> i =  pq.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
		System.out.println("=========");

		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		/*
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		*/
		
	}

}
