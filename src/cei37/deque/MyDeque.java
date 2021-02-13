package cei37.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MyDeque {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();

		dq.push(1);
		dq.push(2);
		dq.push(3);
		dq.push(4);
		
		System.out.println(dq);
		
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		
		
		if (!dq.isEmpty())
			System.out.println(dq.pop());
	}

}
