package cei37.sorts;

/*
 * 3
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] nums = {10,3,-1,4,5,5,7,11,1, 15, 8, 9, 0};
		ShellSort.shellSort(nums);
		for (int i: nums) {
			System.out.println(i);
		}
	}

	public static void shellSort(int[] nums) {
		int gap = 1;
		int N = nums.length;
		while(gap < N/3)
			gap = 3 * gap + 1; //Knuth’s increments: 1, 4, 13, …, (3k – 1) / 2
		
		while (gap >= 1) {
			for (int i = gap; i < N; i++) {
				for (int j = i; j >= gap && nums[j] < nums[j-gap]; j-=gap) {
					int aux = nums[j];
					nums[j] = nums[j-gap];
					nums[j-gap] = aux; 
				}
			}
			gap = gap/3;
		}
	}
}
