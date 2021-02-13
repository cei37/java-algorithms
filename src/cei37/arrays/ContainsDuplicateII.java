package cei37.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*
 * 219. Contains Duplicate II
Easy

1172

1306

Add to List

Share
Given an array of integers and an integer k, find out whether there are two distinct 
indices i and j in the array such that nums[i] = nums[j] and the absolute difference 
between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {
		ContainsDuplicateII cd = new ContainsDuplicateII();
		int[] nums = new int[] {99,99};
		int k = 0;

		System.out.println(cd.containsNearbyDuplicate(nums, k));
	}

	/*
	 * this is my solution
	 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if (nums == null || nums.length == 0) return false;
    	
    	Map<Integer, Queue<Integer>> map = new HashMap<>();
    	
    	for (int i=0; i<nums.length; i++) {
    		if (!map.containsKey(nums[i])) {
    			map.put(nums[i], new PriorityQueue<Integer>());
    		}
    		map.get(nums[i]).offer(i);
    	}

    	for (int i=0; i<nums.length; i++) {
    		if (map.get(nums[i]).isEmpty()) {
    			continue;
    		}

    		int first = map.get(nums[i]).poll();
    		if (!map.get(nums[i]).isEmpty() && map.get(nums[i]).peek() <= first + k) {
    			return true;
    		}
    	}

    	return false;
    }
    //other solutions ---- they are better :(
    public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    
    public boolean containsNearbyDuplicate_3(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
        
    }
}
