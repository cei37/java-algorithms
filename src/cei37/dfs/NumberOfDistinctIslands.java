package cei37.dfs;

import java.util.HashSet;
import java.util.Set;

/*
 * 694. Number of Distinct Islands
Medium

970

59

Add to List

Share
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the 
grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another 
if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.

 */
public class NumberOfDistinctIslands {

	public static void main(String[] args) {
		int[][] grid = new int[][] {
			{ 1, 1, 0, 0, 0 },
			{ 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 1 },
			{ 0, 0, 0, 1, 1 }
		};
		int[][] grid2 = new int[][] {
			{ 1, 1, 0, 1, 1 },
			{ 1, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 1},
			{ 1, 1, 0, 1, 1}
		};
		NumberOfDistinctIslands n = new NumberOfDistinctIslands();
		System.out.println(n.numDistinctIslands(grid2));

	}

	int[][] grid;
	int[][] visited;
	int coor[][] = new int[][] {
		{ 0, 1 }, { 0, -1 },
		{ 1, 0 }, { -1, 0 },
	};
    public int numDistinctIslands(int[][] grid) {
    	if (grid == null || grid.length == 0) return 0;
    	
    	this.grid = grid;
    	this.visited = new int[grid.length][grid[0].length];
    	Set<String> path = new HashSet<>();
    	int num = 0;

    	for (int i=0; i<grid.length; i++) {
    		for (int j=0; j<grid[i].length; j++) {
    			StringBuilder sb = new StringBuilder();
    			dfs(i,j,0, 0, sb);
    			if (sb.length() > 0 && !path.contains(sb.toString())) {
    				path.add(sb.toString());
    				num++;
    			}
        	}
    	}
    	return num;
    }
    
    public void dfs(int r, int c, int x, int y, StringBuilder sb) {
    	if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || 
    			grid[r][c] == 0 || visited[r][c] == 1) return;

    	sb.append(x).append(y);
    	visited[r][c] = 1;
    	for (int[] p : coor) {
	    	dfs(r + p[0], c + p[1], x + p[0], y + p[1], sb);
    	}
    }
}
