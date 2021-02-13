package cei37.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = {
			{1, 3, 4, 8},
			{3, 2, 2, 4},
			{5, 7, 1, 9},
			{2, 3, 2, 3},
		};
		//MinimumPathSum.MySolution my = new MinimumPathSum().new MySolution();
		//MinimumPathSum.MySolution2 my = new MinimumPathSum().new MySolution2();
		//MinimumPathSum.LeetCodeSolution my = new MinimumPathSum().new LeetCodeSolution();
		MinimumPathSum.MySolution3 my = new MinimumPathSum().new MySolution3();

		System.out.println(my.minPathSum(grid));
	}

	
	class MySolution3 {
		//this solution only took 2 ms, this is great, much better than the previous
		//this approach is only possible because we are using a matrix and we can just
		//move down or right, if the directions were down, up, right, left it won't be
		//possible to use this strategy, hence we need to use Dijkstra
		
		//it looks like my solution now is very good
	    public int minPathSum(int[][] grid) {
	    	
	    	for (int i = 0; i<grid.length; i++) {
	    		for (int j = 0; j<grid[i].length; j++) {
	    			if (i == 0 && j == 0) {
	    				continue;
	    			}
	    			if (i == 0 && j > 0) {
	    				grid[i][j] = grid[i][j] + grid[i][j - 1];
	    				continue;
	    			}
	    			if (i > 0 && j == 0) {
	    				grid[i][j] = grid[i][j] + grid[i - 1][j];
	    				continue;
	    			}
	    			grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
	    		}
	    	}
	    	
	        return grid[grid.length - 1][grid[0].length - 1];
	    }
	}

	//this is my first solution
	//after trying a BFS I realize we can apply Dijkstra here
	class MySolution {
		int [][] res;
	    public int minPathSum(int[][] grid) {
	    	int rows = grid.length;
	    	int cols = grid[0].length;
	    	res = new int[rows][cols];
	    	res[0][0] = grid[0][0];

	    	dfs(grid, 0, 0);
	    	
	        return res[rows - 1][cols - 1];
	    }

	    public void dfs(int[][] grid, int i, int j) {
	    	if (i >= grid.length || j >= grid[i].length) {
	    		return;
	    	}

	    	if (i > 0 && j > 0) {
	    		res[i][j] = Math.min(grid[i][j] + res[i - 1][j], grid[i][j] + res[i][j - 1]);
	    	} else if (i == 0 && j > 0) {
	    		res[i][j] = grid[i][j] + res[i][j - 1];
	    	} else if (j == 0 && i > 0) {
	    		res[i][j] = grid[i][j] + res[i - 1][j];
	    	}

	    	
	    	dfs(grid, i + 1, j);
	    	dfs(grid, i, j + 1);
	    }
	}

	class MySolution2 {
		//let's start with a BFS approach, it won't be the best,
		//but it will help to practice more
		//Time Limit Exceeded
	    public int minPathSum(int[][] grid) {
	    	Map<String, Integer> g = new HashMap<>();
	    	Queue<Point> q = new LinkedList<>();
	    	
	    	int rows = grid.length;
	    	int cols = grid[0].length;
	    	q.offer(new Point(0, 0, grid[0][0]));
	    	g.put("0_0", grid[0][0]);
	    	
	    	while(!q.isEmpty()) {
	    		Point p = q.poll();
	    		
	    		if (p.i + 1 < rows) {
	    			Point newP = new Point(p.i + 1, p.j, p.sum + grid[p.i + 1][p.j]);
	    			q.offer(newP);
	    			String key = (p.i + 1) + "_" + p.j;
	    			if (g.containsKey(key)) {
	    				if (newP.sum < g.get(key)) {
	    					g.put(key, newP.sum);
	    				}
	    			} else {
	    				g.put(key, newP.sum);
	    			}
	    		}

	    		if (p.j + 1 < cols) {
	    			Point newP = new Point(p.i, p.j + 1, p.sum + grid[p.i][p.j + 1]);
	    			q.offer(newP);
	    			String key = p.i + "_" + (p.j + 1);
	    			if (g.containsKey(key)) {
	    				if (newP.sum < g.get(key)) {
	    					g.put(key, newP.sum);
	    				}
	    			} else {
	    				g.put(key, newP.sum);
	    			}
	    		}
	    	}
	    	String key = (rows-1) + "_" + (cols-1);
	        return g.get(key);
	    }
	    
	    class Point {
	    	int i;
	    	int j;
	    	int sum;
	    	public Point(int i, int j, int sum) {
	    		this.i = i;
	    		this.j = j;
	    		this.sum = sum;
	    	}
	    }
	}
	
	public class LeetCodeSolution {
	    public int calculate(int[][] grid, int i, int j) {
	        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
	        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
	        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
	    }
	    public int minPathSum(int[][] grid) {
	        return calculate(grid, 0, 0);
	    }
	}
	
	class TheBestFromLeetCodeSolution {
	    public int minPathSum(int[][] grid) {
	        int height = grid.length;
	        int width = grid[0].length;
	        if(height == 0 || width == 0) return 0;
	        int [][] memo = new int[height][width];
	        return min(grid,height -1, width - 1,memo);
	    }
	    public int min(int[][]grid,int m , int n , int[][] memo){
	        if(m < 0 || n < 0) return Integer.MAX_VALUE;
	        if(m == 0 && n == 0) return grid[m][n];
	        if(memo[m][n] > 0) return memo[m][n];
	        memo[m][n] = grid[m][n] + Math.min(min(grid,m-1,n,memo),min(grid,m,n-1,memo));
	        return memo[m][n];
	    }
	}
}