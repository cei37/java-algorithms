package cei37.arrays;

import java.util.LinkedList;

public class RotateArray {

	//Given an array, rotate the array to the right by k steps, where k is non-negative.
	/*
	 * Example 1:
		Input: [1,2,3,4,5,6,7] and k = 3
		Output: [5,6,7,1,2,3,4]
		Explanation:
		rotate 1 steps to the right: [7,1,2,3,4,5,6]
		rotate 2 steps to the right: [6,7,1,2,3,4,5]
		rotate 3 steps to the right: [5,6,7,1,2,3,4]
	 */
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		//int arr[] = {99,-1,-100,3};
		//int arr[] = {1,2};
		int k = 3;
		RotateArray.rotate(arr, k);
		for (int ele: arr) {
			System.out.print(ele + "," );
		}
	}
	
    public static void rotateExtraMemory(int[] nums, int k) {
    	if (k < 0 || nums.length == 1) {
    		return;
    	}

    	for (int i = 0; i < k; i++) {
    		int tem = nums[0];
    		int temNext = 0;
    		if (nums.length - 2 == 0) {
    			nums[0] = nums[1];
    			nums[1] = tem;
    		} else {
	    		for (int j = 0; j < nums.length - 2; j++) {
    				temNext = nums[j + 1];
    				nums[j + 1] = tem;
    				tem = temNext;
    				temNext = nums[j + 2];
	    		}
	    		nums[nums.length - 1] = tem;
	    		nums[0] = temNext;
	    	}
    	}
    }
    
    //this was a copy (nice)
    public static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
            System.out.println((i + k) % nums.length);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
