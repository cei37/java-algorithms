package cei37.sorts;

public class Selection {

	/*
	 * 1
	 */
	public static void main(String[] args) {
		int[] nums = {10,-1,3,4,5,5,7,11,1};
		Selection.selectionSort(nums);
		for (int i: nums) {
			System.out.println(i);
		}
	}
	
	public static void selectionSort(int[] nums) {
		for (int i=0; i<nums.length; i++) {
			int min = i;
			for (int j=i+1; j<nums.length; j++)
				if (nums[j] < nums[min])
					min = j;

			if (min != i) {
				int aux = nums[i];
				nums[i] = nums[min];
				nums[min]=aux;
			}
		}
	}
}