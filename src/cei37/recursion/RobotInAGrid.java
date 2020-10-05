package cei37.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem: Imagine a robot sitting on the upper left corner of grid with r rows
 * and c columns. The robot can only move in two directions, right and down, but
 * certain cells are "off limits" such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the
 * bottom right.
 *
 */

public class RobotInAGrid {

	public static List<List<int[]>> res = new ArrayList<>();
	public static void main(String[] args) {
		boolean X = false;
		boolean Y = true;
		boolean[][] maze = new boolean[][] {
			{ Y, Y, Y, X, X },
			{ Y, X, Y, Y, X },
			{ Y, Y, Y, Y, X },
			{ X, X, Y, Y, Y },
		};
		
		RobotInAGrid rig = new RobotInAGrid();
		List<int[]> list = rig.getPath(maze);
		for (int[] p : list) {
			System.out.println(p[0] + " , " + p[1]);
		}
	}

	public List<int[]> getPath(boolean[][] maze) {
		List<int[]> path = new ArrayList<>();
		
		if (maze == null || maze.length == 0) return path;
		
		getPath(maze, maze.length - 1, maze[0].length - 1, path);

		return path;
	}
	
	public boolean getPath(boolean[][] maze, int row, int colum, List<int[]> path) {
		
		if (row < 0 || colum < 0 || !maze[row][colum]) {
			return false;
		}
		
		boolean isAtOrigin = (row == 0 && colum == 0);

		
		if (isAtOrigin || getPath(maze, row - 1, colum, path) || getPath(maze, row, colum - 1, path)) {
			path.add(new int[] {row, colum});
			return true;
		}
		
		return false;
	}
}
