package cei37.matriz;

/*
 * 
 * 240. Search a 2D Matrix II

Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

 */
public class Search2DMatrixII {

	public static void main(String[] args) {
		int matrix[][] = new int[][] {
		  {1,   4,  7, 11, 15},
		  {2,   5,  8, 12, 19},
		  {3,   6,  9, 16, 22},
		  {10, 13, 14, 17, 24},
		  {18, 21, 23, 26, 30}
		};
		int target = 11;
		Search2DMatrixII sm = new Search2DMatrixII();
		
		System.out.println(sm.searchMatrix(matrix, target));

	}

	/*
	 * Approach 4: Search Space Reduction
	Intuition
	
	Because the rows and columns of the matrix are sorted (from left-to-right and top-to-bottom, respectively), 
	we can prune \mathcal{O}(m)O(m) or \mathcal{O}(n)O(n) elements when looking at any particular value.
	
	Algorithm
	
	First, we initialize a (row, col)(row,col) pointer to the bottom-left of the matrix.[1] Then, 
	until we find target and return true (or the pointer points to a (row, col)(row,col) that lies 
	outside of the dimensions of the matrix), we do the following: if the currently-pointed-to value 
	is larger than target we can move one row "up". Otherwise, if the currently-pointed-to value is 
	smaller than target, we can move one column "right". It is not too tricky to see why doing this 
	will never prune the correct answer; because the rows are sorted from left-to-right, we know that 
	every value to the right of the current value is larger. Therefore, if the current value is already 
	larger than target, we know that every value to its right will also be too large. A very similar 
	argument can be made for the columns, so this manner of search will always find target in the matrix 
	(if it is present).
	 */
    public boolean searchMatrix(int[][] matrix, int target) {

    	if (matrix == null || matrix.length == 0) return false;

    	int r = matrix.length - 1;
    	int c = 0;
    	int maxIterations = r + matrix[0].length - 1;
    	int counter = 0;
    	
    	while (counter <= maxIterations && r >= 0 && c < matrix[0].length) {
    		if (matrix[r][c] == target) {
    			return true;
    		} else if (matrix[r][c] > target) {
    			r--;
    		} else {
    			c++;
    		}
    		
    		counter++;
    	}
    	
        return false;
    }
}
