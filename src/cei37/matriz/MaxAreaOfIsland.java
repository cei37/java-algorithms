package cei37.matriz;

/*
 * 695. Max Area of Island

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are 
surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

 */
public class MaxAreaOfIsland {

	public static void main(String[] args) {
		MaxAreaOfIsland max = new MaxAreaOfIsland();
		int[][] grid = new int[][] {
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,1,1,0,1,0,0,0,0,0,0,0,0},
			 {0,1,0,0,1,1,0,0,1,0,1,0,0},
			 {0,1,0,0,1,1,0,0,1,1,1,0,0},
			 {0,0,0,0,0,0,0,0,0,0,1,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		
		System.out.println(max.maxAreaOfIsland(grid));
	}

    public int maxAreaOfIsland(int[][] grid) {
    	if (grid == null || grid.length == 0) return 0;
    	
    	int maxArea = 0;
    	for (int row=0; row<grid.length; row++) {
    		for (int col=0; col<grid[row].length; col++) {
        		if (grid[row][col] == 1) {
        			maxArea = Math.max(maxArea, getArea(grid, row, col));
        		}
        	}
    	}
    	
    	return maxArea;
    }
    
    private int getArea(int[][] grid, int row, int col) {
    	
    	if (row < 0 || row >= grid.length || col < 0 || 
    			col >= grid[0].length || grid[row][col] == 0) {
    		return 0;
    	} else {
    		grid[row][col] = 0;
    		return 1 + getArea(grid, row + 1, col) +
    				   getArea(grid, row - 1, col) + 
    				   getArea(grid, row, col + 1) +
    				   getArea(grid, row, col - 1);
    	}
    }
	
/*
	int maxAreaTem = 0;
    public int maxAreaOfIsland(int[][] grid) {
    	if (grid == null || grid.length == 0) return 0;
    	
    	int maxArea = 0;
    	for (int row=0; row<grid.length; row++) {
    		for (int col=0; col<grid[row].length; col++) {
        		if (grid[row][col] == 1) {
        			maxAreaTem++;
        			grid[row][col] = 0;
        			getArea(grid, row, col);
        			maxArea = Math.max(maxArea, maxAreaTem);
        			maxAreaTem = 0;
        		}
        	}
    	}
    	
    	return maxArea;
    }
    
    private void getArea(int[][] grid, int row, int col) {
    	
    	if (row + 1 < grid.length && grid[row + 1][col] == 1) {
    		maxAreaTem++;
    		grid[row + 1][col] = 0;
    		getArea(grid, row + 1, col);
    	}
    	
    	if (row - 1 >= 0 && grid[row - 1][col] == 1) {
    		maxAreaTem++;
    		grid[row - 1][col] = 0;
    		getArea(grid, row - 1, col);
    	}
    	
    	if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
    		maxAreaTem++;
    		grid[row][col + 1] = 0;
    		getArea(grid, row, col + 1);
    	}
    	
    	if (col - 1 >= 0 && grid[row][col - 1] == 1) {
    		maxAreaTem++;
    		grid[row][col - 1] = 0;
    		getArea(grid, row, col - 1);
    	}
    }
    */
}