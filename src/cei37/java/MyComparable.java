package cei37.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class MyComparable {
	
	
	public static void main(String[] args) {
		List<Number> list = new ArrayList<Number>();
		list.add(new Number(5));
		list.add(new Number(1));
		list.add(new Number(6));
		list.add(new Number(2));
		list.add(new Number(7));
		
		Collections.sort(list); 
		
		for (Number n: list) {
			System.out.println(n.number);
		}

	}

}
 
class Number implements Comparable<Number> {

	int number;
	
	public Number(int number) {
		this.number = number;
	}
	
	@Override
	public int compareTo(Number o) {
		if (o.number < number) {
			return 1;
		} else {
			return -1;
		}
	}
	
}