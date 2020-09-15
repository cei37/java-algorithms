package cei37.sorts;

public class Insertion {

	/*
	 * 2
	 */
	public static void main(String[] args) {
		int[] nums = {10,3,-1,4,5,5,7,11,1};
		Insertion.insertionSort(nums);
		for (int i: nums) {
			System.out.println(i);
		}
	}
	
	public static void insertionSort(int[] nums) {
		for (int i=0; i<nums.length; i++) {
			for (int j=i; j>0; j--)
				if (nums[j] < nums[j-1]) {
					int aux = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = aux;
				} else break;
		}
	}

}
