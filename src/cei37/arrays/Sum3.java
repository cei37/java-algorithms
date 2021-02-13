package cei37.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 3Sum

Solution
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class Sum3 {

	public static void main(String[] args) {
		Sum3 s = new Sum3();
		int[][] nums = new int[][] {
			{-1,0,1,2,-1,-4}
		};
		
		for (int n[] : nums) {
			for (List<Integer> list : s.threeSum(n)) {
				for (Integer r : list) {
					System.out.print(r + " ");
				}
				System.out.println();
			}
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
			if (i == 0 || nums[i - 1] != nums[i]) {
				twoSum(nums, i, res);
			}
		return res;
	}

	void twoSum(int[] nums, int i, List<List<Integer>> res) {
		Set<Integer> seen = new HashSet<Integer>();
		for (int j = i + 1; j < nums.length; ++j) {
			int complement = -nums[i] - nums[j];
			if (seen.contains(complement)) {
				res.add(Arrays.asList(nums[i], nums[j], complement));
				while (j + 1 < nums.length && nums[j] == nums[j + 1])
					++j;
			}
			seen.add(nums[j]);
		}
	}
}
