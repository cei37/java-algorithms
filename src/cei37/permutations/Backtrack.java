package cei37.permutations;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Backtrack {

	public static void main(String[] args) {
		Instant start = Instant.now();

		int[] arr = { 1, 2, 3, 4};
		Backtrack bt = new Backtrack();
		List<List<Integer>> perm = bt.permute(arr);
		
		for (List<Integer> list : perm) {
			for (Integer num : list) {
				System.out.print( num + " ");
			}
			System.out.println("");
		}
		Instant finish = Instant.now();
		System.out.println(Duration.between(start, finish).toMillis());
	}

	public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
		// if all integers are used up
		if (first == n)
			output.add(new ArrayList<Integer>(nums));
		for (int i = first; i < n; i++) {
			// place i-th integer first 
			// in the current permutation
			Collections.swap(nums, first, i);
			// use next integers to complete the permutations
			backtrack(n, nums, output, first + 1);
			// backtrack
			Collections.swap(nums, first, i);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		// init output list
		List<List<Integer>> output = new LinkedList();

		// convert nums into list since the output is a list of lists
		ArrayList<Integer> nums_lst = new ArrayList<Integer>();
		for (int num : nums)
			nums_lst.add(num);

		int n = nums.length;
		backtrack(n, nums_lst, output, 0);
		return output;
	}
}
