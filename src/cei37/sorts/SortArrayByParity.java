package cei37.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 905. Sort Array By Parity

Given an array A of non-negative integers, return an array consisting of all the even elements of A, 
followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

 */
public class SortArrayByParity {

	public static void main(String[] args) {
		SortArrayByParity s = new SortArrayByParity();
		int input[] = new int[] {
			3,1,2,4
		};
		for (int n : s.sortArrayByParity(input)) {
			System.out.println(n);
		}
	}

    public int[] sortArrayByParity(int[] A) {
    	Integer[] n = new Integer[A.length];
    	for (int i=0; i<A.length; i++) {
    		n[i] = A[i];
    	}

    	Arrays.sort(n, new Comparator<Integer>() {
    		public int compare(Integer a, Integer b) {
    			if (a % 2 == 0) {
    				return -1;
    			}
    			return 1;
    		}
    	});
    	
    	for (int i=0; i<A.length; i++) {
    		A[i] = n[i]; 
    	}

    	
    	return A;
    }
}