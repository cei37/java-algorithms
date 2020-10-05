package cei37.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator1 {

	public static void main(String[] args) {
		char a = 'a';
		char b = 'b';
		
		System.out.println("a".compareTo("b"));
		System.out.println((int)a + " " + (int)b);

		Comparator<String> comp = new Comparator<String>() {
			
			public int compare(String a, String b) {
				
				String spA[] = a.split(" ", 2);
				String spB[] = b.split(" ", 2);
				
				boolean aDig = Character.isDigit(spA[1].charAt(0));
				boolean bDig = Character.isDigit(spB[1].charAt(0));
				
				if (!aDig && !bDig) {
					
					int com = spA[1].compareTo(spB[1]);
					if (com != 0) {
						return com;
					}
					
					return a.compareTo(b);
				}
				
				if (!aDig && bDig) {
					return -1;
				} else if (aDig && !bDig) {
					return 1;
				} else 
					return 0;
			}
		};
		
		String[] nums = new String[] {
			"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"
		};
		
		Arrays.sort(nums, comp);

		for (String n : nums) {
			System.out.println(n);
		}
	}

}
