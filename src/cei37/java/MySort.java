package cei37.java;

import java.util.Arrays;
import java.util.*;

public class MySort {

	public static void main(String[] args) {
		//sorting an array of integers
		int num[] = {8,3,5,9,10};
		Arrays.sort(num);
		
		for (int i:num) {
			System.out.println(i);
		}
		
		
		System.out.println("*******************");
		
		//sorting a list of integers
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(1);
		list.add(8);
		list.add(3);
		list.add(15);
		
		Collections.sort(list);
		
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
