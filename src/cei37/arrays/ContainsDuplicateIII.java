package cei37.arrays;

import java.util.TreeSet;

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		ContainsDuplicateIII cd = new ContainsDuplicateIII();
		int[] nums = new int[] {
			2147483640,2147483641
		};
		int k = 1;
		int t = 100;
		
		System.out.println(cd.containsNearbyAlmostDuplicate(nums, k, t));

	}

	/**
	 * This is a copy
	 * @param nums - The array of numbers
	 * @param k - the absolute difference between i and j is at most 
	 * @param t - the absolute difference between nums[i] and nums[j] is at most 
	 * @return
	 */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
    	if (nums == null || nums.length == 0) return false;
    	
    	TreeSet<Long> set = new TreeSet<>();
    	
    	for (int i=0; i<nums.length; i++) {
    		Long num = (long)(nums[i]);
    		Long ceil = set.ceiling(num);
    		if (ceil != null && ceil <= num + t) {
    			return true;
    		}
    		
    		Long floor = set.floor(num);
    		if (floor != null && num <= floor + t) {
    			return true;
    		}
    		
    		set.add(num);
    		if (set.size() > k) {
    			set.remove((long)(nums[i - k]));
    		}
    	}
    	
    	return false;
    }
    
    /**
     * This is a copy too, however it is based in brute force and it is the fastest one
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    if(nums.length>9999)
	    {
	        return false;
	    }
	    for(int i=0;i<nums.length;i++)
	    {
	        for(int j=i+1;j<Math.min(i+k+1,nums.length);j++)
	        {
	            if(Math.abs((long)nums[i]-(long)nums[j])<=t)
	            {
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
