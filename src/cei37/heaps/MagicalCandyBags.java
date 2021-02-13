package cei37.heaps;

import java.util.PriorityQueue;

/*
 * Magical Candy Bags
You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of 
candy are inside), and as soon as you finish, the bag mysteriously refills. If there were x pieces of 
candy in the bag at the beginning of the minute, then after you've finished you'll find that floor(x/2) 
pieces are now inside.
You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?
Signature
int maxCandies(int[] arr, int K)
Input
1 ≤ N ≤ 10,000
1 ≤ k ≤ 10,000
1 ≤ arr[i] ≤ 1,000,000,000
Output
A single integer, the maximum number of candies you can eat in k minutes.
Example 1
N = 5 
k = 3
arr = [2, 1, 7, 4, 2]
output = 14
In the first minute you can eat 7 pieces of candy. That bag will refill with floor(7/2) = 3 pieces.
In the second minute you can eat 4 pieces of candy from another bag. That bag will refill with floor(4/2) = 2 pieces.
In the third minute you can eat the 3 pieces of candy that have appeared in the first bag that you ate.
In total you can eat 7 + 4 + 3 = 14 pieces of candy.
 */
public class MagicalCandyBags {

	int maxCandies(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k == 0) return 0;
		int eat = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int n : arr) {
			pq.add(n);
		}
		
		for (int i=0; i<k; i++) {
			int n = pq.poll();
			eat += n;
			n /= 2;
			pq.add(n);
		}
		
		return eat;
	}
	
	


	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() {
		int n_1 = 5, k_1 = 3;
		int[] arr_1 = { 2, 1, 7, 4, 2 };
		int expected_1 = 14;
		int output_1 = maxCandies(arr_1, k_1);
		check(expected_1, output_1);

		int n_2 = 9, k_2 = 3;
		int[] arr_2 = { 19, 78, 76, 72, 48, 8, 24, 74, 29 };
		int expected_2 = 228;
		int output_2 = maxCandies(arr_2, k_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new MagicalCandyBags().run();
	}

}
