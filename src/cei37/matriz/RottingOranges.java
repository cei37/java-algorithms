package cei37.matriz;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 994. Rotting Oranges

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange 
becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
If this is impossible, return -1 instead.

 
Example 1:
https://leetcode.com/problems/rotting-oranges/

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4


Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because 
rotting only happens 4-directionally.

 */
public class RottingOranges {

	public static void main(String[] args) {
		RottingOranges ro = new RottingOranges();
		int[][] grid = new int[][] {
			{2,2,2,1,1},
		};
		
		System.out.println(ro.orangesRotting(grid));
	}

    public int orangesRotting(int[][] grid) {
    	if (grid == null || grid.length == 0) return 0;
    	
    	int oranges = 0;
    	Queue<Point> rot = new LinkedList<>();
    	for (int row=0; row<grid.length; row++) {
    		for (int column=0; column<grid[row].length; column++) {
    			if (grid[row][column] == 2) {
    				rot.add(new Point(row, column));
    			} else if (grid[row][column] == 1) {
    				oranges++;
    			}
    		}
    	}

    	Queue<Point> rotTem = new LinkedList<>();
    	int minutes = 0;
    	int counterOfOrangesRotten = 0;
    	while(!rot.isEmpty()) {
    		Point point = rot.poll();
    		
    		counterOfOrangesRotten += rotOranges(point, rotTem, grid);
    		
    		if (rot.isEmpty() && !rotTem.isEmpty()) {
    			minutes++;
    			rot = new LinkedList<Point>(rotTem);
    			rotTem.clear();
    		}
    	}
    	
    	if (counterOfOrangesRotten == oranges) {
    		return minutes;
    	} else {
    		return -1;
    	}
    }
    
    public int rotOranges(Point point, Queue<Point> rotTem, int[][] grid) {
    	int counterOfOrangesRotten = 0;
    	if (point.getColumn() - 1 >= 0 && grid[point.getRow()][point.getColumn() - 1] == 1) {
    		grid[point.getRow()][point.getColumn() - 1] = 2;
    		rotTem.add(new Point(point.getRow(), point.getColumn() - 1));
    		counterOfOrangesRotten++;
    	}
    	if (point.getColumn() + 1 < grid[point.getRow()].length && grid[point.getRow()][point.getColumn() + 1] == 1) {
    		grid[point.getRow()][point.getColumn() + 1] = 2;
    		rotTem.add(new Point(point.getRow(), point.getColumn() + 1));
    		counterOfOrangesRotten++;
    	}
    	if (point.getRow() - 1 >= 0 && grid[point.getRow() - 1][point.getColumn()] == 1) {
    		grid[point.getRow() - 1][point.getColumn()] = 2;
    		rotTem.add(new Point(point.getRow() - 1, point.getColumn()));
    		counterOfOrangesRotten++;
    	}
    	if (point.getRow()+1 < grid.length && grid[point.getRow() + 1][point.getColumn()] == 1) {
    		grid[point.getRow() + 1][point.getColumn()] = 2;
    		rotTem.add(new Point(point.getRow() + 1, point.getColumn()));
    		counterOfOrangesRotten++;
    	}
    	return counterOfOrangesRotten;
    }

    class Point {
    	int column = 0;
    	int row = 0;
    	public Point(int row, int column) {
    		this.column = column;
    		this.row = row;
    	}
    	
    	public int getRow() {
    		return row;
    	}
    	
    	public int getColumn() {
    		return column;
    	}
    }
}
