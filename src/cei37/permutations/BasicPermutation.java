package cei37.permutations;

import java.util.ArrayList;
import java.util.List;

public class BasicPermutation {

	public static void main(String[] args) {
		for (String str: BasicPermutation.permutation("ABCD")) {
			System.out.println(str);
		}
	}

	public static List<String> permutation(String str) {
		List<String> output = new ArrayList<>();
		permutation(output, str, 0, str.length());
		return output;
	}
	
	public static void permutation(List<String> list, String str, int init, int size) {
		
		if (size == 0) {
			list.add(str);
		}
		for (int i=0; i<str.length()-1; i++) {
			String left = str.substring(i);
			String right = str.substring(i + 1, str.length() -1);
			permutation(list, right, i+1, right.length());
		}
	}
}
