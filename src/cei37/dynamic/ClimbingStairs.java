package cei37.dynamic;

/*
 * 70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45

 */
public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs(4));
	}

    public int climbStairs(int n) {    	
    	return climbStairs(n, new int[n+2]);
    }
    
    public int climbStairs(int n, int [] memo) {
    	 
    	if (n == 1) return 1;
    	if (n == 2) return 2;
    	
    	if (memo[n] == 0) {
    		memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
    	}
    	
    	return memo[n];
    }
}
