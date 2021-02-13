package cei37.arrays;

import java.util.HashMap;

/*
 * 560. Subarray Sum Equals K
Medium

5718

189

Add to List

Share
Given an array of integers and an integer k, you need to find the total number of continuous
subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		SubarraySumEqualsK s = new SubarraySumEqualsK();
		int nums[] = new int[] {
			1,  2,  3,  4,  1,  2,  3,  4,  1,  2,  3,  4
		//  1   3   6   10  11  13  16  20  21  23  26  30
		//      1   1           1   1           1   1
		};
		int k = 3;
		
		System.out.println(s.subarraySum(nums, k));
	}
	
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    
    public int subarraySum_2(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }

    public int subarraySum_1(int[] nums, int k) {
    	int count = 0;
        for (int i=0; i<nums.length; i++) {
        	int sum = 0;
        	for (int j=i; j<nums.length; j++) {
            	sum += nums[j];
            	if (sum == k) {
            		count++;
            	}
            }	
        }
    	return count;
    }
}
