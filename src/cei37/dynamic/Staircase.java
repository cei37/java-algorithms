package cei37.dynamic;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/*
 * Problem statement #
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 
3 steps at a time. Implement a function to count the number of possible ways that the child 
can run up the stairs.

Input #
An integer that represents the number of stairs

Output #
An integer that represents the number of ways that those stairs can be climbed

Sample input #
int n = 4;
Sample output #
int n = 7;
 */
public class Staircase {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		//System.out.println(countWays(30));
		
		//System.out.println(countWays2(30));
		
		System.out.println(countWays4(30));
		
		long endTime = System.nanoTime();
		//System.out.println();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((endTime - startTime) / 1000000000d) + " seconds");
	}
	
	//Solution #4: Optimizing the tabulated version for space  #
	public static int countWays4(int n) {
		if (n < 0)
			return 0;
		if (n <= 2)
			return 1;
		int thirdLast = 1; // ways to reach third last stair
		int secondLast = 1; // ways to reach second last stair
		int last = 2; // ways to reach last stair
		int current = 0; // ways to reach current stair
		for (int i = 3; i <= n; i++) {
			current = last + secondLast + thirdLast; // summing ways to reach previous three stairs
			thirdLast = secondLast;
			secondLast = last;
			last = current;
		}
		return current;
	}

	//Solution #3: Tabularization #
	public static int countWays3(int n) {
	    int[] lookupTable = new int[n+1]; // Initialize lookup table
	    lookupTable[0] = 1; // Setting the first three values
	    lookupTable[1] = 1;
	    lookupTable[2] = 2;
	    
	    for (int i = 3; i <= n; i++) 
	        lookupTable[i] = lookupTable[i-1] + lookupTable[i-2] + lookupTable[i-3]; // Fill up the table by summing up previous two values
	    
	    return lookupTable[n]; 
		
	}
	
	
	//Solution #2: Memoization #
	public static int countWays2(int n) {
		int memo[] = new int[n + 1];
		for(int i = 0; i<n+1; i++)
			memo[i] = -1;
		return countWays2(n, memo);
	}
	public static int countWays2(int n, int[] memo) {
		if (n < 0) 
			return 0;
		else if (n == 0) 
			return 1;
		else if (memo[n] > -1)
			return memo[n];
		else
			memo[n] = countWays2(n-1, memo) + countWays2(n-2, memo) + countWays2(n-3, memo);
		return memo[n];
	}

	
	//Solution #1: Brute force #
	public static int countWays(int n) {
		if (n < 0) 
			return 0;
		else  if (n == 0) 
			return 1;

		return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
}