package cei37.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a MxN matrix where each element can either be 0 or 1. We need to find 
 * the shortest path between a given source cell to a destination cell. The path 
 * can only be created out of a cell if its value is 1.

Expected time complexity is O(MN).
 */
public class ShortestPathMaze {

	public static void main(String[] args) {
		
		System.out.println(1<<5);
		
		int maze[][] = new int[][] {
		  // 0  1  2  3  4  5  6  7  8  9
/* 0 */	    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
/* 1 */     {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
/* 2 */		{1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
/* 3 */		{0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
/* 4 */     {1, 1, 1, 0, 1, 1, 1, 0, 1, 1 },
/* 5 */		{1, 0, 1, 1, 1, 1, 0, 1, 0, 1 },
/* 6 */		{1, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
/* 7 */		{1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
/* 8 */		{1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
		};
		
		int[] source = {0, 0};
		int[] target = {8, 9};
		
		
		ShortestPathMaze spm = new ShortestPathMaze();
		System.out.println(spm.shortestPathMaze(maze, source, target));
	}

	public int shortestPathMaze(int[][] maze, int[] source, int target[]) {
		
		if (maze == null || maze[0].length == 0) return -1;
		
		boolean mazeTem[][] = new boolean[maze.length][maze[0].length];
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(source[0], source[1], 0, null));
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int row = point.row;
			int col = point.col;

			if (row == target[0] && col == target[1]) {
				int dis = point.dis;
				while(point != null) {
					System.out.println(point.row + " , " + point.col);
					point = point.path;
				}
				
				return dis;
			}
			
			if (row - 1 >= 0 && maze[row - 1][col] == 1 && !mazeTem[row - 1][col]) {
				queue.add(new Point ( row - 1, col, point.dis + 1, point ));
				mazeTem[row - 1][col] = true;
			}
			
			if (row + 1 < maze.length && maze[row + 1][col] == 1 && !mazeTem[row + 1][col]) {
				queue.add(new Point ( row + 1, col, point.dis + 1, point ));
				mazeTem[row + 1][col] = true;
			}
			
			if (col - 1 >= 0 && maze[row][col - 1] == 1 && !mazeTem[row][col - 1]) {
				queue.add(new Point ( row, col - 1, point.dis + 1, point ));
				mazeTem[row][col - 1] = true;
			}
			
			if (col + 1 < maze[0].length && maze[row][col + 1] == 1 && !mazeTem[row][col + 1]) {
				queue.add(new Point ( row, col + 1, point.dis + 1, point ));
				mazeTem[row][col + 1] = true;
			}
		}

		return 0;
	}
	
	class Point {
		int row = 0;
		int col = 0;
		int dis = 0;
		
		Point path = null;
		
		public Point(int row, int col, int dis, Point previous) {
			this.row = row;
			this.col = col;
			this.dis = dis;
			path = previous;
		}
	}
}