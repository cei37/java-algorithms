package cei37.dfs;

/*
1219. Path with Maximum Gold
Medium

828

29

Add to List

Share
In a gold mine grid of size m * n, each cell in this mine has an integer representing the 
amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

1 <= grid.length, grid[i].length <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.

 */
public class PathWithMaximumGold {

	public static void main(String[] args) {
		PathWithMaximumGold p = new PathWithMaximumGold();
		int[][] grid = {
			{1,0,7},
			{2,0,6},
			{3,4,5},
			{0,3,0},
			{9,0,20}
		};
		System.out.println(p.getMaximumGold(grid));
	}

	//this is my solution
    public int getMaximumGold_1(int[][] grid) {
    	boolean[][] visited = new boolean[grid.length][grid[0].length];
    	int maxGold = Integer.MIN_VALUE;
    	for (int i=0; i<grid.length; i++) {
    		for (int j=0; j<grid[0].length; j++) {
    			if (grid[i][j] > 0) {
    				maxGold = Math.max(dfs(i, j, grid, visited), maxGold);
    			}
    		}
    	}
    	return maxGold;
    }
    
    public int dfs(int row, int col, int[][] grid, boolean[][] visited) {
    	int max = 0;
    	int current = 0;
    	if (row < grid.length && row >= 0 && col < grid[0].length && col >= 0 && !visited[row][col] &&
    			grid[row][col] > 0) {
    		int[][] inc = { {1,0}, {0,1}, {-1,0}, {0,-1} };
    		visited[row][col] = true;
    		current = grid[row][col];
    		for (int[] p : inc) {
    			max = Math.max(dfs(row + p[0], col + p[1], grid, visited), max);
    		}
    		visited[row][col] = false;
    	}
    	return max + current;
    }
    
    /*
     * This is someone else solution
     */
    public int getMaximumGold(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    ans=Math.max(ans, dfs(grid, i, j, 0));
                }
            }
        }
        return ans;
    }
    
    public int dfs(int[][] grid, int i, int j, int count){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==0){
            return count;
        }
        
        count += grid[i][j];
        int temp=grid[i][j];
        grid[i][j]=0;
        int left = dfs(grid,i-1,j,count);
        int right=dfs(grid,i+1,j,count);
        int up=dfs(grid,i,j+1,count);
        int down=dfs(grid, i, j-1, count);
        grid[i][j]=temp;
        return Math.max(left,Math.max(right,Math.max(up,down)));
    }
}