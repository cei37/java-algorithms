package cei37.dailyCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 448. Find All Numbers Disappeared in an Array 

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice
and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list 
does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 */
public class FindAllNumbersDisappeared {

	public static void main(String[] args) {
		FindAllNumbersDisappeared fn = new FindAllNumbersDisappeared();
		int nums[] = {4,3,2,7,8,2,3,1};
		
		for (int n : fn.findDisappearedNumbers(nums)) {
			System.out.println(n);
		}

	}

    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	if (nums == null || nums.length == 0) 
    		return res;
    	
    	//iterate to mark the existing numbers
    	for (int i=0; i < nums.length; i++) {
    		int num = Math.abs(nums[i]);
    		if (nums[num-1] > 0)
    			nums[num-1] = -nums[num-1];
    	}
    	//iterate to mark the existing numbers
    	for (int i=0; i < nums.length; i++) {
    		int num = nums[i];
    		if (num > 0) {
    			res.add(i + 1);
    		}
    	}
    	
    	return res;
    }
}
