package cei37.dp;

public class RangeSumQueryMutable {

	public static void main(String[] args) {
		//int[] arr1 = { 1, 3, 5};
		//int[] arr1 = { 9, -8};
		int[] arr1 = { 0, 9, 5, 7, 3};
		
		RangeSumQueryMutable.NumArray ra = new RangeSumQueryMutable().new NumArray(arr1);
		//ra.update(0, 3);
		System.out.println(ra.sumRange(4, 4));
		System.out.println(ra.sumRange(2, 4));
		System.out.println(ra.sumRange(3, 3));
	}

	class NumArray {
	    int[] nums;
	    int[] sum;
	    public NumArray(int[] nums) {
	        this.nums = nums;
	        this.sum = new int[nums.length];
	        this.calculateAll();
	    }
	    
	    public void update(int index, int val) {
	        if (nums[index] == val) {
	            return;
	        }

	        nums[index] = val;
	        if (index == 0) {
	            calculateAll();
	            return;
	        }
	        
	        for (int i=index; i<nums.length; i++) {
	            sum[i] = nums[i] + sum[i-1];
	        }
	    }
	    
	    public int sumRange(int left, int right) {
	    	if (right < left) return 0;
	    	
	        if (left == 0) {
	            return sum[right];
	        }
	        
	        if (left == right) {
	        	return nums[right];
	        }
	        
	        return sum[right] - sum[left - 1];
	    }
	    
	    private void calculateAll() {
	    	sum[0] = nums[0];
	        for (int i=1; i<nums.length; i++) {
	            sum[i] = nums[i] + sum[i-1];
	        }
	    }
	}
}
