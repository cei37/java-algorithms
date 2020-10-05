package cei37.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber {

	/*
	 Given a non-empty array of integers, every element appears twice except for one. 
	 Find that single one.
	 Input: [4,1,2,1,2]

Note:

Your algorithm should have a linear runtime complexity. Could you implement it 
without using extra memory?
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1, 2, 3, 1, 2, 5, 6, 3, 5};
		System.out.println(SingleNumber.singleNumber(nums));
	}
	
    public static int singleNumber2(int[] nums) {
    	Set<Integer> set = new HashSet<>();
        for (int num: nums) {
        	if (set.contains(num)) {
        		set.remove(num);
        	} else {
        		set.add(num);
        	}
        }
    	return (int)set.toArray()[0];
    }
    
    //this is a copy
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        return ret;
    }
}
