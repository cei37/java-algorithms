package cei37.dailyCode;

public class ProductOfAll {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		
		nums = ProductOfAll.productOfAll(nums);
		
		for (int i: nums) {
			System.out.println(i);
		}

	}

	public static int[] productOfAll(int[] nums) {
		int productOfAll = 1;
		for (int num : nums) {
			productOfAll *= num;
		}
		
		for (int i=0; i<nums.length; i++) {
			if (productOfAll != 0)
				nums[i] = productOfAll/nums[i];
		}
		
		return nums; 
	}
}
