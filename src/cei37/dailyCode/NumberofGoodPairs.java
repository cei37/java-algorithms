package cei37.dailyCode;

import java.util.HashMap;
import java.util.Map;

/*
 * 1512. Number of Good Pairs
 * 
Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


 */
public class NumberofGoodPairs {

	public static void main(String[] args) {
		NumberofGoodPairs num = new NumberofGoodPairs();
		int[][] nums = new int[][]{
			{1,2,3,1,1,3},
			{1,1,1,1},
			{1,2,3}
		};
		for (int i=0; i<nums.length; i++) {
			System.out.println(num.numIdenticalPairs2(nums[i]));
		}
	}

	//brute force
    public int numIdenticalPairs(int[] nums) {
    	int good = 0;
        for (int i=0; i<nums.length; i++) {
        	for (int j=i+1; j<nums.length; j++) {
            	//A pair (i,j) is called good if nums[i] == nums[j] and i < j.
        		if (nums[i] == nums[j]) {
        			good++; 
        		}
            }
        }
    	return good;
    }
    

    public int numIdenticalPairs2(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>(); 
    	int good = 0;
    	for (int n : nums) {
    		if (map.containsKey(n) ) {
    			good +=  map.get(n);
    			map.put(n, map.get(n) + 1);
    		} else {
    			map.put(n, 1);
    		}
    	}
    	return good;
    }
}
