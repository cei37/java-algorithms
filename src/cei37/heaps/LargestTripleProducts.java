package cei37.heaps;

import java.util.PriorityQueue;

/*
 * Largest Triple Products
You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] 
such that, for each index i (between 0 and n-1, inclusive), output[i] is equal to the 
product of the three largest elements out of arr[0..i] (or equal to -1 if i < 2, as arr[0..i] 
then includes fewer than three elements).
Note that the three largest elements used to form any product may have the same values as one 
another, but they must be at different indices in arr.

Signature
int[] findMaxProduct(int[] arr)
Input
n is in the range [1, 100,000].
Each value arr[i] is in the range [1, 1,000].
Output
Return a list of n integers output[0..(n-1)], as described above.


Example 1
n = 5
arr = [1, 2, 3, 4, 5]
output = [-1, -1, 6, 24, 60]
The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.

Example 2
n = 5
arr = [2, 1, 2, 1, 2]
output = [-1, -1, 4, 4, 8]
The 3rd element of output is 2*2*1 = 4, the 4th is 2*2*1 = 4, and the 5th is 2*2*2 = 8.

 */
public class LargestTripleProducts {

	int[] findMaxProduct(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		if (arr.length <= 2) return arr;

		int res[] = new int[arr.length];
		res[0] = -1;
		res[1] = -1;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0]);
		pq.add(arr[1]);
	
		int times = arr[0] * arr[1];
		for (int i=2; i<arr.length; i++) {
			if (pq.size() < 3) {
				pq.add(arr[i]);
				times *= arr[i];
				res[i] = times;
			} else {
				if (arr[i] > pq.peek()) {
					times = times / pq.peek();
					pq.poll();
					times *= arr[i];
					pq.add(arr[i]);
					res[i] = times;
				} else {
					res[i] = times;
				}
			}
		}

		return res;
	}

	
	
	
	
	
	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	public void run() {
		int[] arr_1 = { 1, 2, 3, 4, 5 };
		int[] expected_1 = { -1, -1, 6, 24, 60 };
		int[] output_1 = findMaxProduct(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 4, 7, 1, 5, 3 };
		int[] expected_2 = { -1, -1, 56, 56, 140, 140 };
		int[] output_2 = findMaxProduct(arr_2);
		check(expected_2, output_2);
		
		int[] arr_3 = { 2, 1, 2, 1, 2 };
		int[] expected_3 = { -1, -1, 4, 4, 8 };
		int[] output_3 = findMaxProduct(arr_3);
		check(expected_3, output_3);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new LargestTripleProducts().run();
	}
}