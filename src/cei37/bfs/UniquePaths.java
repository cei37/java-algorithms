package cei37.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*

62. Unique Paths
Medium

4548

235

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.

 */
public class UniquePaths {

	public static void main(String[] args) {
		//UniquePaths.MySolution1 my = new UniquePaths().new MySolution1();
		UniquePaths.MySolution2 my = new UniquePaths().new MySolution2();
		System.out.println(my.uniquePaths(3, 7));
		System.out.println(my.uniquePaths(7, 3));
		System.out.println(my.uniquePaths(3, 2));
		System.out.println(my.uniquePaths(3, 3));
		System.out.println(my.uniquePaths(4, 4));
		System.out.println(my.uniquePaths(3, 4));
	}

	class MySolution2 {
	    public int uniquePaths(int m, int n) {
	    	int[][] grid = new int[m][n];
	    	for (int i=0; i<grid.length; i++) {
	    		for (int j=0; j<grid[i].length; j++) {
	    			if (i == 0 || j == 0) {
	    				grid[i][j] = 1;
	    				continue;
	    			}
	    			grid[i][j] = grid[i-1][j] + grid[i][j-1];
	    		}
	    	}

	    	return grid[m-1][n-1];
	    }
	}
	
	class MySolution1 {
		//Time Limit Exceeded
	    public int uniquePaths(int m, int n) {
	    	Queue<int[]> q = new LinkedList<>();
	    	q.offer(new int[] {0, 0});

	    	int num = 0;
	    	while(!q.isEmpty()) {
	    		int[] p = q.poll();
	    		if (p[0] == m - 1 && p[1] == n - 1) {
	    			num++;
	    			continue;
	    		}

	    		if (p[0] + 1 < m) {
	    			q.offer(new int[] {p[0] + 1, p[1] });
	    		}

	    		if (p[1] + 1 < n) {
	    			q.offer(new int[] {p[0], p[1] + 1});
	    		}
	    	}
	    	return num;
	    }
	}
}