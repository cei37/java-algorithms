package cei37.matriz;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 1091. Shortest Path in Binary Matrix

In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., 
C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, 
return -1. 

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4

 

Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1
 */
public class ShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		ShortestPathInBinaryMatrix s = new ShortestPathInBinaryMatrix();
		List<int[][]> list = new ArrayList<int[][]>( ) { {
			add(new int[][] {
				{0,1},
				{1,0}
			});
			add(new int[][] {
				{0,0,0},
				{1,1,0},
				{1,1,0}
			});
			add(new int[][] {
				{0,0,0},
				{1,1,0},
				{1,1,1}
			});
		}};

		for (int[][] m : list) {
			System.out.println(s.shortestPathBinaryMatrix(m));
		}
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
    	if (grid == null || grid.length == 0) return -1;
    	int dirs[][]={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    	
    	int rows = grid.length;
    	int cols = grid[0].length;
    	boolean visited[][] = new boolean[rows][cols];
    	Queue<int[]> q = new LinkedList<int[]>();

    	q.offer(new int[] { 0, 0});
    	int[] d = {};
		int r = 0;
		int c = 0;
		int count = 1;
    	while (!q.isEmpty()) {
    		int size = q.size(); 
    		for (int i=0; i<size; i++) {
    			d = q.poll();
        		r = d[0];
        		c = d[1];
        		if (r < 0 || c < 0 || r >= rows || c >= cols) {
        			continue;
        		}
        		if (grid[r][c] == 0 && c == cols - 1 && r == rows - 1) {
    				return count;
    			}
        		if (grid[r][c] == 0 && visited[r][c] == false) {
	    			visited[r][c] = true;
	    			for (int[] dir : dirs) {
	    				int newR = r + dir[0];
	    				int newC = c + dir[1];
	    				q.offer(new int[] { newR, newC });
	    			}
    			}
    		}
    		count++;
    	}
        return -1;
    }

	/*
	public int shortestPathBinaryMatrix(int[][] grid) {
    	if (grid == null || grid.length == 0) return -1;
    	
    	int rows = grid.length;
    	int cols = grid[0].length;
    	int visited[][] = new int[rows][cols];
    	Deque<int[]> q = new ArrayDeque<int[]>();

    	q.offer(new int[] { 0, 0, 1 });
    	
    	while (!q.isEmpty()) {
    		int[] d = q.poll();
    		int r = d[0];
    		int c = d[1];
    		int count = d[2];

    		if (r < 0 || c < 0 || r >= rows || c >= cols) {
    			continue;
    		} else {
    			if (grid[r][c] == 0 && c == cols - 1 && r == rows - 1) {
    				return count;
    			}
    			if (grid[r][c] == 0 && visited[r][c] == 0) {
	    			visited[r][c] = 1;
	    			q.offer(new int[] { r + 1, c, count + 1 }); //down
	    			q.offer(new int[] { r - 1, c, count + 1 }); //top
	    			q.offer(new int[] { r, c + 1, count + 1 }); //right
	    			q.offer(new int[] { r, c - 1, count + 1 }); //left

	    			q.offer(new int[] { r + 1, c + 1, count + 1 }); //down-right
	    			q.offer(new int[] { r - 1, c - 1, count + 1 }); //top-left
	    			q.offer(new int[] { r - 1, c + 1, count + 1 }); //top-right
	    			q.offer(new int[] { r + 1, c - 1, count + 1 }); //down-left
    			}
    		}
    	}
        return -1;
    }*/
	
    /*public int shortestPathBinaryMatrix(int[][] grid) {
    	if (grid == null || grid.length == 0) return -1;
    	
    	int rows = grid.length;
    	int cols = grid[0].length;
    	int visited[][] = new int[rows][cols];
    	Deque<Data> q = new ArrayDeque<Data>();

    	q.offer(new Data(0, 0, 1, null));
    	
    	while (!q.isEmpty()) {
    		Data d = q.poll();
    		int r = d.row;
    		int c = d.col;
    		int count = d.count;

    		if (r < 0 || c < 0 || r >= rows || c >= cols) {
    			continue;
    		} else {
    			if (grid[r][c] == 0 && c == cols - 1 && r == rows - 1) {
    				while(d != null) {
    					System.out.println(d.row + "," + d.col);
    					d = d.data;
    				}
    				return count;
    			}
    			if (grid[r][c] == 0 && visited[r][c] == 0) {
	    			visited[r][c] = 1;
	    			q.offer(new Data(r + 1, c, count + 1, d)); //down
	    			q.offer(new Data(r - 1, c, count + 1, d)); //top
	    			q.offer(new Data(r, c + 1, count + 1, d)); //right
	    			q.offer(new Data(r, c - 1, count + 1, d)); //left

	    			q.offer(new Data(r + 1, c + 1, count + 1, d)); //down-right
	    			q.offer(new Data(r - 1, c - 1, count + 1, d)); //top-left
	    			q.offer(new Data(r - 1, c + 1, count + 1, d)); //top-right
	    			q.offer(new Data(r + 1, c - 1, count + 1, d)); //down-left
    			}
    		}
    	}
        return -1;
    }
    
    class Data {
    	int row;
    	int col;
    	int count;
    	Data data;
    	public Data(int row, int col, int count, Data data) {
    		this.row = row;
    		this.col = col;
    		this.count = count;
    		this.data = data;
    	}
    }*/
}
