package cei37.permutations;

import java.util.*;

/*
 * 46. Permutations

Given an array nums of distinct integers, return all the possible permutations. 
You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = new int[] {
			1, 2, 3
		};
		for (List<Integer> list : p.permute(nums)) {
			for (Integer n : list) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}

    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> out = new ArrayList<>();
    	permute(nums, out, 0);
    	return out;
    }

    public void permute(int[] nums, List<List<Integer>> out, int idx) {
    	if (idx >= nums.length) {
    		List<Integer> list = new ArrayList<Integer>();
    		for (int n : nums) {
    			list.add(n);
    		}
    		out.add(list);
    		return;
    	}

    	for (int i=idx; i<nums.length; i++) {
    		swap(nums, idx, i);
    		permute(nums, out, idx + 1);
    		swap(nums, idx, i);
    	}
    }
    
    public void swap(int[] nums, int i, int j) {
    	int tem = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tem;
    }
}