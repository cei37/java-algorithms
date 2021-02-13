package cei37.dp;

/*
63. Unique Paths II
Medium

2446

282

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePathsII {
	
	public static void main(String[] args) {
		
		int[][] obstacleGrid1 = {
			{0,0,0},
			{0,1,0},
			{0,0,0}
		};

		int[][] obstacleGrid2 = {
			{1,0}
		};
		
		int[][] obstacleGrid3 = {
			{1},
			{0}
		};

		UniquePathsII.MySolution my = new UniquePathsII().new MySolution();
		
		System.out.println(my.uniquePathsWithObstacles(obstacleGrid3));
	}

	class MySolution {
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    	int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
	    	boolean stopI = false;
	    	boolean stopJ = false;
	    	if (obstacleGrid[0][0] == 1) return 0;
	    	
	    	for (int i=0; i<grid.length; i++) {
	    		for (int j=0; j<grid[i].length; j++) {
	    			if (i == 0) {
	    				if (obstacleGrid[i][j] != 1 && !stopI) {
	    					grid[i][j] = 1;
	    				} else {
	    					stopI = true;
	    				}
	    				continue;
	    			}
	    			if (j == 0) {
	    				if (obstacleGrid[i][j] != 1 && !stopJ) {
	    					grid[i][j] = 1;
	    				} else {
	    					stopJ = true;
	    				}
	    				continue;
	    			}
	    			if (obstacleGrid[i][j] != 1) {
	    				grid[i][j] = grid[i-1][j] + grid[i][j-1];
	    			}
	    		}
	    	}

	    	return grid[grid.length - 1][grid[0].length - 1];
	    }
	}
}