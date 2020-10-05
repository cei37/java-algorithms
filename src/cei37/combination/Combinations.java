package cei37.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 * 77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
1 <= k <= n

 */
public class Combinations {

	public static void main(String[] args) {
		List<List<Integer>> comb = Combinations.combine(4, 2);
		
		for (List<Integer> list : comb) {
			for (Integer num : list) {
				System.out.print( num + " ");
			}
			System.out.println("");
		}
		
	}

	public static List<List<Integer>> combine(int n, int k) {
		// init first combination
		LinkedList<Integer> nums = new LinkedList<Integer>();
		for (int i = 1; i < k + 1; ++i)
			nums.add(i);
		nums.add(n + 1);

		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int j = 0;
		while (j < k) {
			// add current combination
			output.add(new LinkedList(nums.subList(0, k)));
			// increase first nums[j] by one
			// if nums[j] + 1 != nums[j + 1]
			j = 0;
			while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
				nums.set(j, j++ + 1);
			nums.set(j, nums.get(j) + 1);
		}
		return output;
	}
}
