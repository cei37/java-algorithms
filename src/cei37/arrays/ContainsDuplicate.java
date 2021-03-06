package cei37.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate {

	/*
		Given an array of integers, find if the array contains any duplicates.
		
		Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
		
		Example 1:
		
		Input: [1,2,3,1]
		Output: true
		Example 2:
		
		Input: [1,2,3,4]
		Output: false
		Example 3:
		
		Input: [1,1,1,3,3,4,3,2,4,2]
		Output: true
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3,};
		System.out.println(ContainsDuplicate.containsDuplicate(arr));
	}
	
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i=0; i < nums.length; i++) {
        	if (set.contains(nums[i])) {
        		return true;
        	} else {
        		set.add(nums[i]);
        	}
        }
        
    	return false;
    }
}
