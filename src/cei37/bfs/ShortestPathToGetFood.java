package cei37.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1730. Shortest Path to Get Food
Medium

30

1

Add to List

Share
You are starving and you want to eat food as quickly as possible. You want to find the shortest path 
to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to
reach food, return -1.

 

Example 1:


Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
Output: 3
Explanation: It takes 3 steps to reach the food.
Example 2:


Input: grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
Output: -1
Explanation: It is not possible to reach the food.
Example 3:


Input: grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],
["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
Output: 6
Explanation: There can be multiple food cells. It only takes 6 steps to reach the bottom food.
Example 4:

Input: grid = [["O","*"],["#","O"]]
Output: 2
Example 5:

Input: grid = [["X","*"],["#","X"]]
Output: -1

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[row][col] is '*', 'X', 'O', or '#'.
The grid contains exactly one '*'.
 */
public class ShortestPathToGetFood {
	public static void main(String[] s) {
		char[][] grid1 = {
			{'X','X','X','X','X','X'},
			{'X','*','O','O','O','X'},
			{'X','O','O','#','O','X'},
			{'X','X','X','X','X','X'}		
		};

		char[][] grid2 = {
			{'X','X','X','X','X','X','X','X'},
			{'X','*','O','X','O','#','O','X'},
			{'X','O','O','X','O','O','X','X'},
			{'X','O','O','O','O','#','O','X'},
			{'X','X','X','X','X','X','X','X'}		
		};
		
		ShortestPathToGetFood sh = new ShortestPathToGetFood();
		
		System.out.println(sh.getFood(grid2));
	}
	
    public int getFood(char[][] grid) {
    	if (grid == null) return -1;
    	
    	int[] local = getLocation(grid);
    	
    	
    	return getShortestPath(local, grid);
    }

    private int getShortestPath(int[] local, char[][] grid) {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(local);
    	int m = grid.length;
    	int n = grid[0].length;
    	int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        //it is possible to use the same grid as visited, however, it is more slow because
        //we are adding more elements to  the queue to be processed, so it is better to use
        //an additional "visited" array
        boolean[][] visited = new boolean[m][n];
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int row = cur[0];
    		int col = cur[1];
    		int dis = cur[2];

    		if (grid[row][col] == '#') {
    			return dis; 
    		}

    		for (int j =0; j< 4; j++) {
                int r = cur[0] + dr[j];
                int c = cur[1] + dc[j];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]  && grid[r][c] !='X') {
                    int[] child = new int[] {r,c, cur[2] + 1};
                    visited[r][c] = true;
                    //ans[r][c] = ans[curr[0]][curr[1]] +1;
                    q.add (child);
                }
            }
    		/*
    		//right
    		if (col + 1 < grid[0].length && grid[row][col + 1] != 'X' ) {
    			q.offer(new int[] {row, col + 1, dis + 1});
        		//grid[row][col + 1] = 'X';
    		}
    		
    		//left
    		if (col - 1 >= 0 && grid[row][col - 1] != 'X' ) {
    			q.offer(new int[] {row, col - 1, dis + 1});
    			//grid[row][col - 1] = 'X';
    		}
    		
    		//down
    		if (row + 1 < grid.length && grid[row + 1][col] != 'X' ) {
    			q.offer(new int[] {row + 1, col, dis + 1});
    			//grid[row + 1][col] = 'X';
    		}

    		//top
    		if (row - 1 >= 0 && grid[row -1][col] != 'X' ) {
    			q.offer(new int[] {row - 1, col, dis + 1});
    			//grid[row - 1][col + 1] = 'X';
    		}*/
    	}

    	return -1;
    }

    private int[] getLocation(char[][] grid) {
    	int res[] = new int[3];
    	
    	for(int i=0; i<grid.length; i++) {
    		for (int j=0; j<grid[i].length; j++) {
    			if (grid[i][j] == '*') {
    				res[0] = i;
    				res[1] = j;
    			}
    		}
    	}
    	return res;
    }
}
