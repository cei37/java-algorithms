package cei37.dynamic;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem statement #
Given an array of integers, write a function to find if any two subsets of the input array exist such that the sum of both subsets is equal. You can assume that the array will only consist of positive integers.

Input #
An array of positive integers

Output #
The output is a boolean. It will be True if such subsets exist and False if they do not

Sample input #
int set[] = {1, 2, 3, 4};
Sample output #
true          // (The 2 subsets will be 1,4 & 2,3)
 */
public class PartitionProblem {

	public static void main(String[] args) {
		int num[] = new int[] {
			1, 2, 3, 4
		};
		System.out.println(canPartition(num));

	}

	public static boolean canPartitionRecursive(int num[], int sum, int currentIndex) {
		int numLength = num.length;
		// base check
		if (sum == 0)
			return true;

		if (numLength == 0 || currentIndex >= numLength)
			return false;

		// recursive call after choosing the number at the currentIndex
		// if the number at currentIndex exceeds the sum, we shouldn't process this
		if (num[currentIndex] <= sum) {
			if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
				return true;
		}

		// recursive call after excluding the number at the currentIndex
		return canPartitionRecursive(num, sum, currentIndex + 1);
	}

	//this is the recomended solution at 
	//https://www.educative.io/courses/algorithms-coding-interviews-java/mE4BRMAm4w9
	public static Object canPartition(int num[]) {
		int numLength = num.length;
		int sum = 0;
		for (int i = 0; i < numLength; i++)
			sum += num[i];
		// if 'sum' is an odd number, we can't have two subsets with equal sum
		if (sum % 2 != 0)
			return false;

		return canPartitionRecursive(num, sum / 2, 0);
	}

	//no sure if this solution is ok
	public static boolean canPartition_1(int[] num) {
		boolean res = false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<num.length; i++) {
			for (int j=i + 1; j<num.length; j++) {
				map.put(num[i] + num[j], map.getOrDefault(num[i] + num[j], 0) + 1);
				if (map.get(num[i] + num[j]) > 1) {
					res = true;
				}
			}
		}
		return res;
	}
}
