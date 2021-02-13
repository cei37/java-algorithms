package cei37.matriz;

/*
 * 
 * 73. Set Matrix Zeroes
Medium

Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1


 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,1,1},
			{1,0,1},
			{1,1,1}
		};
		SetMatrixZeroes s = new SetMatrixZeroes();
		s.setZeroes(matrix);
		for (int[] row : matrix) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

    public void setZeroes(int[][] matrix) {
    	if (matrix == null) return;
        
    	int row[] = new int[matrix.length];
        int col[] = new int[matrix[0].length];
        
        for (int i=0; i<matrix.length; i++) {
        	for (int j=0; j<matrix[0].length; j++) {
            	if (matrix[i][j] == 0) {
            		row[i] = 1;
            		col[j] = 1;
            	}
            }	
        }
        
        for (int i=0; i < row.length; i++) {
        	if (row[i] == 1) {
        		setZerosRow(matrix, i);
        	}
        }
        
        for (int i=0; i < col.length; i++) {
        	if (col[i] == 1) {
        		setZerosCol(matrix, i);
        	}
        }
        
    }
    
    public void setZerosRow(int[][] matrix, int row) {
		for (int i=0; i<matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
    }

    public void setZerosCol(int[][] matrix, int col) {
		for (int i=0; i<matrix.length; i++) {
			matrix[i][col] = 0;
		}
    }
}
