package cei37.binarySearch;

import java.util.ArrayList;
import java.util.List;

/*
 * 34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position 
of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
public class FindFirstLastPositionElementSortedArray {

	public static void main(String[] args) {
		FindFirstLastPositionElementSortedArray ff = new FindFirstLastPositionElementSortedArray();
		List<Data> list = new ArrayList<>();
		list.add(new Data(new int[] { 5,7,7,8,8,10 }, 8, "3,4"));
		list.add(new Data(new int[] { 5,7,7,8,8,10 }, 6, "-1, -1"));
		list.add(new Data(new int[] { }, 0, "-1, -1"));
		list.add(new Data(new int[] { 1 }, 1, "0, 0"));
		
		for (Data d : list) {
			int res[] = ff.searchRange(d.nums, d.target);
			System.out.println(res[0] + ", " + res[1] + " expected " + d.expected);
		}
	}

    public int[] searchRange(int[] nums, int target) {
    	int pos = bs(nums, target, 0, nums.length-1);
    	if (pos == -1) {
    		return new int[] {-1, -1};
    	}
    	int left = pos;
    	int right = pos;
    	
    	while(left-1 >=0 && nums[left-1]==target) {
    		left--;
    	}
    	
    	while(right+1 < nums.length && nums[right+1]==target) {
    		right++;
    	}
    	
        return new int[] { left, right };
    }
    
    public int bs(int[] nums, int target, int left, int right) {
    	int mid = (right+left)/2;
    	
    	if (left > right) return -1;
    	
    	if (nums[mid] == target) {
    		return mid;
    	} else if (target > nums[mid]) {
    		return bs(nums, target, mid + 1, right);
    	} else {
    		return bs(nums, target, left, mid - 1);
    	}
    }
    
    static class Data {
    	int nums[];
    	int target;
    	String expected;
    	public Data(int [] nums, int target, String expected) {
    		this.nums = nums;
    		this.target = target;
    		this.expected = expected;
    	}
    }
}
