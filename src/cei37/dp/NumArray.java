package cei37.dp;

/*
303. Range Sum Query - Immutable
Easy

1169

1285

Add to List

Share
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 

Constraints:

0 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= i <= j < nums.length
At most 104 calls will be made to sumRange.
 */
public class NumArray {

	public static void main(String[] args) {
		int[] arr1 = { -2, 0, 3, -5, 2, -1 };
		NumArray n = new NumArray(arr1);
		System.out.println(n.sumRange(0, 2));
		System.out.println(n.sumRange(2, 5));
		System.out.println(n.sumRange(0, 5));
	}
	
	int[] nums;
    public NumArray(int[] nums) {
    	for (int i=1; i<nums.length; i++) {
    		nums[i]+= nums[i - 1];
    	}
    	this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
    	if (i == 0) {
    		return nums[j];
    	}
    	return nums[j] - nums[i - 1];
    }
}