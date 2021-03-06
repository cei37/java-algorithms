package cei37.arrays;

/*
 * 287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

Follow-ups:

How can we prove that at least one duplicate number must exist in nums? 
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?
 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
 

Constraints:

2 <= n <= 3 * 104
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		FindTheDuplicateNumber fd = new FindTheDuplicateNumber();
		int nums[] = new int[] {
				1
		};

		System.out.println(fd.findDuplicate(nums));
	}

    public int findDuplicate(int[] nums) {
    	
    	if (nums == null || nums.length == 0) return -1;
    	
    	int tem[] = new int[nums.length + 1];
    	
    	for (int i=0; i<nums.length; i++) {
    		if (tem[nums[i]] > 0) {
    			return nums[i];
    		}
    		tem[nums[i]]++;
    	}

    	return -1;
    }
}