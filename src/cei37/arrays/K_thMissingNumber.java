package cei37.arrays;

/*
 * Given a sorted array A of unique numbers, find the K-th missing number starting from 
 * the leftmost number of the array.

 

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 

Note:

1 <= A.length <= 50000
1 <= A[i] <= 1e7
1 <= K <= 1e8

 */
public class K_thMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int missingElement(int[] nums, int k) {
        int counter = 0, curVal = nums[0];
        for(int index = 0; index < nums.length; index++){
            curVal = nums[index];               
            while(index < nums.length-1 && curVal + 1 < nums[index+1] && 
                    counter < k ){
                curVal++;               
                counter++;              
            }
            if (counter == k){        
                return curVal;
            }
        }   
        return curVal + (k - counter);
    }

}
