package cei37.dailyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		int result[] = TwoSum.twoSum(nums,target);
		for (int i: result) {
			System.out.println(i);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++) {
			int n = nums[i];
			if (map.containsKey(target - n)) {
				return new int[] {map.get(target - n), i};
			}
			map.put(nums[i], i);
		}
		return new int[]{};
	}
}
