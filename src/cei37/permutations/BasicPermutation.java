package cei37.permutations;

import java.util.ArrayList;
import java.util.List;

public class BasicPermutation {

	public static void main(String[] args) {
		for (String str: BasicPermutation.permutation("ABC")) {
			System.out.println(str);
		}
	}

	public static List<String> permutation(String str) {
		List<String> output = new ArrayList<>();
		permutation(output, str.toCharArray(), 0);
		return output;
	}
	
	public static void permutation(List<String> list, char[] arr, int pos) {
		
		if (pos >= arr.length) {
			list.add(new String(arr));
			return;
		}
		for (int i=pos; i<arr.length; i++) {
			swap(arr, i, pos);
			permutation(list, arr, pos + 1);
			swap(arr, i, pos);
		}
	}
	
	public static void swap(char arr[], int i, int j) {
		char tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;
	}
}
