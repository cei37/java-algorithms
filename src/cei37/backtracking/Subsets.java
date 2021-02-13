package cei37.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 78. Subsets
Medium

5153

109

Add to List

Share
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */
public class Subsets {

	public static void main(String[] args) {
		int[] nums = new int[] {
			1,2,3		
		};

		Subsets sub = new Subsets();
		for (List<Integer> list : sub.subsets(nums)) {
			for (int num : list) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}
	}
	
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (nums == null || nums.length == 0) return res;

    	return null;
    }
}
