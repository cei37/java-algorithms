package cei37.arrays;

import java.util.Arrays;

/*
 * 628. Maximum Product of Three Numbers

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6
 

Example 2:

Input: [1,2,3,4]
Output: 24
 

Note:

The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

 */
public class MaximumProductofThreeNumbers {

	public static void main(String[] args) {
		MaximumProductofThreeNumbers m = new MaximumProductofThreeNumbers();
		int[] nums = new int[] {
			-1, -2, -3
		};
		System.out.println(m.maximumProduct(nums));
	}
	
	/* leet code solution
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }*/
    
	/*
	 * not a good solution it is O(NlgN)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], 
        		nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }*/
    
    public int maximumProduct(int[] nums) {
    	int max1 = Integer.MIN_VALUE;
    	int max2 = Integer.MIN_VALUE;
    	int max3 = Integer.MIN_VALUE;
    	int min1 = Integer.MAX_VALUE;
    	int min2 = Integer.MAX_VALUE;
    	for (int i=0; i<nums.length; i++) {
    		if (nums[i] <= min1) {
    			min2 = min1;
    			min1 = nums[i];
    		} else if (nums[i] <= min2) {
    			min2 = nums[i];
    		}
    		if (nums[i] > max1) {
    			max3 = max2;
    			max2 = max1;
    			max1 = nums[i];
    		} else if (nums[i] > max2) {
    			max3 = max2;
    			max2 = nums[i];
    		} else if (nums[i] > max3) {
    			max3 = nums[i];
    		}
    	}

    	int op1 = max3 * max2 * max1;
    	int op2 = min1 * min2 * max1;

    	return Math.max(op1, op2);
    }
}