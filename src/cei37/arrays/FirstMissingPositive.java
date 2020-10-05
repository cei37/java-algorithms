package cei37.arrays;

/*
 * 41. First Missing Positive

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
1,2,3,5,6,7
Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Follow up:

Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		System.out.println(f.firstMissingPositive(new int[] {1, 2, 3}));
		System.out.println(f.firstMissingPositive(new int[] {3, 4, -1, -2, 1, 5, 16, 0, 2, 0 }));
		System.out.println(f.firstMissingPositive(new int[] {1, 2, 0}));
		System.out.println(f.firstMissingPositive(new int[] {3, 4, -1, 1}));
		System.out.println(f.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
	}

    public int firstMissingPositive(int[] nums) {
    	boolean onePresent = false;
    	
    	//verify that there is a number 1 in the array
    	for (int num : nums) {
    		if (num == 1) {
    			onePresent = true;
    			break;
    		}
    	}
    	
    	if (onePresent) {
    		if (nums.length == 1) return 2;
    		//let's clean up all the invalid numbers such as negative, and greater than arra.lenght + 1
    		for (int i=0; i<nums.length; i++) {
    			if (nums[i] <= 0 || nums[i] > nums.length) {
    				//the clean up will be setting 1
    				nums[i] = 1;
    			}
    		}
    		
    		//let's walk the array and change the sign for present numbers. number --> arrayIndex
    		for (int i=0; i<nums.length; i++) {
    			if (Math.abs(nums[ i ]) == nums.length) {
					nums[ 0 ] = - Math.abs(nums[ 0 ]);
				} else if (Math.abs(nums[i]) > 0 && nums[Math.abs(nums[i])] > 0) {
    				//shifting the sign
    				nums[ Math.abs(nums[ i ]) ] = -nums[ Math.abs(nums[ i ]) ];
    			}
    		}
    		
    		for (int i=1; i<nums.length; i++) {
    			if (nums[i] > 0) {
    				return i;
    			}
    		}
    		
    		if (nums[0] > 0) {
    			return nums.length;
    		}
    		else {
    			return nums.length + 1;
    		}
    	}

    	return 1;
    }
    
}