package cei37.dailyCode;

/*
Given a binary array, find the maximum length of a contiguous subarray
with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal 
number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

 */
public class FindMaxLength {

	public static void main(String[] args) {
		FindMaxLength fm = new FindMaxLength();
		//int[] nums = {0,1,0,1,0,1,1,0,1};
		//int[] nums = {0,1, 0};
		int nums[] = {0,0,1,0,0,0,1,1};
		System.out.println(fm.findMaxLength(nums));

	}

	public int findMaxLength(int[] nums) {
		return Math.max(findMaxLengthNo(nums), findMaxLengthIn(nums));
	}
	public int findMaxLengthNo(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            int zero = 0;
            int one = 0;
        	for (int j=i; j<nums.length; j++) {
        		if (nums[j] == 0) 
        			zero++;
        		else if(nums[j] == 1) 
        			one++;
        		
        		if (zero == one) {
        			max = Math.max(max, one + zero);
                    i = j;
        		}
        	}
        }
    	return max;
    }
	
	public int findMaxLengthIn(int[] nums) {
        int max = 0;
        for (int i=nums.length-1; i>0; i--) {
            int zero = 0;
            int one = 0;
        	for (int j=i; j>0; j--) {
        		if (nums[j] == 0) 
        			zero++;
        		else if(nums[j] == 1) 
        			one++;
        		
        		if (zero == one) {
        			max = Math.max(max, one + zero);
                    i = j;
        		}
        	}
        }
    	return max;
    }
}