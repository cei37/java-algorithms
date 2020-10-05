package cei37.dailyCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 
 * 137. Single Number II

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

 */
public class SingleNumberII {

	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] nums = new int[] {
				2,2,3,2
		};

		System.out.println(sn.singleNumber(nums));
	}

    public int singleNumber(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	int sumTotal = 0;
    	int sumSet = 0;
    	
    	for (int num : nums) {
    		if (!set.contains(num)) {
    			sumSet += num;
    		}
    		set.add(num);
    		sumTotal += num;
    	}
    	
    	return (sumSet * 3 - sumTotal)/2;
    }
}
