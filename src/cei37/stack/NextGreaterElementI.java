package cei37.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 496. Next Greater Element I
Easy

1812

2366

Add to List

Share
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements 
are subset of nums2. Find all the next greater numbers for nums1's elements in the 
corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its 
right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 */
public class NextGreaterElementI {

	public static void main(String[] args) {
		NextGreaterElementI nge = new NextGreaterElementI();
		int findNums[] = new int[] {
			4,1,2
		};
		int nums[] = new int[] {
			1,3,4,2
		};

		for (int n : nge.nextGreaterElement(findNums, nums) ) {
			System.out.println(n);
		}
	}

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
    	if (findNums == null || findNums.length == 0) return new int[0];
    	
    	Stack<Integer> stack = new Stack<>();
    	Map<Integer, Integer> hash = new HashMap<>();

    	for (int i=0; i<nums.length; i++) {
    		while(!stack.isEmpty() && nums[i] > stack.peek()) {
    			hash.put(stack.pop(), nums[i]);
    		}
    		stack.push(nums[i]);
    	}
    	
    	while(!stack.isEmpty()) {
    		hash.put(stack.pop(), -1);
    	}
    	
    	for (int i=0; i<findNums.length; i++) {
    		findNums[i] = hash.get(findNums[i]);
    	}
    	
    	return findNums;
    }
}
