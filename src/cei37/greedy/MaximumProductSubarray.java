package cei37.greedy;

/*
 * 152. Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at 
least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray m = new MaximumProductSubarray();
		int[] nums = new int[] {
				-2, 3, -4
		};
		System.out.println(m.maxProduct(nums));

	}

	//copy from leetcode solution
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
}