package cei37.matriz;

/*
 * 463. Island Perimeter

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 
represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded 
by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
Determine the perimeter of the island.

https://leetcode.com/problems/island-perimeter/

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		IslandPerimeter ip = new IslandPerimeter();
		int[][] grid = new int[][] {
			{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}
		};

		System.out.println(ip.islandPerimeter(grid));
	}

    public int islandPerimeter(int[][] grid) {
    	if (grid == null || grid.length == 0) return 0;
    	
    	int per = 0;
    	for (int row=0; row<grid.length; row++) {
    		for (int col=0; col<grid[row].length; col++) {
        		if (grid[row][col] == 1) {
        			int land = 0;
        			if (row - 1 >= 0 && grid[row - 1][col] == 1) {
        				land++;
        			}
        			if (row + 1 < grid.length && grid[row + 1][col] == 1) {
        				land++;
        			}
        			if (col - 1 >= 0 && grid[row][col - 1] == 1) {
        				land++;
        			}
        			if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
        				land++;
        			}
        			per += 4 - land;
        		}
        	}
    	}
    	
    	return per;
    }
	
	/*
    public int islandPerimeter(int[][] grid) {
    	if (grid == null || grid.length == 0) return 0;
    	
    	for (int row=0; row<grid.length; row++) {
    		for (int col=0; col<grid[row].length; col++) {
        		if (grid[row][col] == 1) {
        			return getPerimeter(grid, row, col);
        		}
        	}
    	}
    	
    	return 0;
    }
    
    public int getPerimeter(int[][] grid, int row, int col) {
    	
    	if (row < 0 || row >= grid.length || col < 0 ||
    			col >= grid[0].length || grid[row][col] == 0) {
    		return 1;
    	}
    	
		if (grid[row][col] == -1)
			return 0;
		grid[row][col] = -1;
    	
    	return getPerimeter(grid, row - 1, col) + 
			   getPerimeter(grid, row + 1, col) +
			   getPerimeter(grid, row, col + 1) +
			   getPerimeter(grid, row, col - 1);
    }*/
}