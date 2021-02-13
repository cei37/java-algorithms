package cei37.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 1460. Make Two Arrays Equal by Reversing Sub-arrays

Given two integer arrays of equal length target and arr.

In one step, you can select any non-empty sub-array of arr and reverse it. 
You are allowed to make any number of steps.

Return True if you can make arr equal to target, or False otherwise.

Example 1:

Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.
Example 2:

Input: target = [7], arr = [7]
Output: true
Explanation: arr is equal to target without any reverses.
Example 3:

Input: target = [1,12], arr = [12,1]
Output: true
Example 4:

Input: target = [3,7,9], arr = [3,7,11]
Output: false
Explanation: arr doesn't have value 9 and it can never be converted to target.
Example 5:

Input: target = [1,1,1,1,1], arr = [1,1,1,1,1]
Output: true
 

Constraints:

target.length == arr.length
1 <= target.length <= 1000
1 <= target[i] <= 1000
1 <= arr[i] <= 1000

 */
public class MakeTwoArraysEqualReversingSubArrays {

	public static void main(String[] args) {
		MakeTwoArraysEqualReversingSubArrays mt = new MakeTwoArraysEqualReversingSubArrays();
		int[] target = new int[] {
			3,7,9
		};
		
		int[] arr = new int[] {
			3,7,11
		};

		System.out.println(mt.canBeEqual(target, arr));
	}

    public boolean canBeEqual(int[] target, int[] arr) {
    	if (target == null && arr == null) return true;
    	if (target.length == 0 && arr.length == 0) return true;
    	if (target.length != arr.length) return false;

    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i=0; i<target.length; i++) {
    		map.put(target[i], map.getOrDefault(target[i], 0) + 1);
    	}
    	
    	for (int i=0; i<arr.length; i++) {
    		if (map.get(arr[i]) != null && map.get(arr[i]) > 0) {
    			map.put(arr[i], map.get(arr[i])-1);
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
}