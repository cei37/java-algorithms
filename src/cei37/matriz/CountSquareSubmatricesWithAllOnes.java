package cei37.matriz;

/*
 * 1277. Count Square Submatrices with All Ones
Medium

1635

29

Add to List

Share
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 */
public class CountSquareSubmatricesWithAllOnes {

	public static void main(String[] args) {
		CountSquareSubmatricesWithAllOnes.BetterSolution c = new CountSquareSubmatricesWithAllOnes().new BetterSolution();
		int[][] matrix1 = {
		  {0,1,1,1},
		  {1,1,1,1},
		  {0,1,1,1}
		};
		
		int[][] matrix2 = {
		  {1,0,1},
		  {1,1,0},
		  {1,1,0}
		};
		
		System.out.println(c.countSquares(matrix1));
		System.out.println(c.countSquares(matrix2));
	}

	class MySolution {
	    public int countSquares(int[][] matrix) {
	    	if (matrix == null) return 0;
	    	
	    	int count = 0;
	    	for (int i=0; i<matrix.length; i++) {
	    		for (int j=0; j<matrix[i].length; j++) {
	    			if (matrix[i][j] == 0) {
	    				continue;
	    			}
	    			count++;
	    			count += countSubMax(matrix, i, j, i + 1, j + 1);
	    		}
	    	}
	    	return count;
	    }
	
	    public int countSubMax(int[][] matrix, int oRow, int oCol, int row, int col) {
	    	if (row >= matrix.length || col >= matrix[row].length) {
	    		return 0;
	    	}
	
	    	for (int i=row; i>=oRow; i--) {
	    		if (matrix[i][col] == 0) {
	    			return 0;
	    		}
	    	}
	    	
	    	for (int j=col; j>=oCol; j--) {
	    		if (matrix[row][j] == 0) {
	    			return 0;
	    		}
	    	}
	    	
	    	return 1 + countSubMax(matrix, oRow, oCol, row + 1, col + 1);
	    }
	}
	
	class OtherSolution {
	    // dp[i][j] -> number of squares with i, j as bottom right corner
	    public int countSquares(int[][] matrix) {
	        int result = 0;
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                if (matrix[i][j] == 1 &&
	                   i >= 1 && j >= 1 &&
	                   matrix[i - 1][j - 1] != 0 && matrix[i - 1][j] != 0 && matrix[i][j - 1] != 0) {
	                    matrix[i][j] = Math.min(Math.min( matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
	                }
	                result += matrix[i][j];
	            }
	        } 
	        return result;
	    }
	}
	
	class BetterSolution {
	    public int countSquares(int[][] A) {
	        int totalNumberOfSquares = 0;
	        for (int i = 0; i < A.length; ++i) {
	            for (int j = 0; j < A[0].length; ++j) {
	                if (A[i][j] == 0) {
	                    continue;
	                }
	                if (i > 0 && j > 0) {
	                    A[i][j] += tripleMathMin(  A[i - 1][j - 1],
	                                               A[i - 1][  j  ], 
	                                               A[  i  ][j - 1]  );
	                }
	                totalNumberOfSquares += A[i][j];
	            }
	        }
	        
	        return totalNumberOfSquares;
	    }
	    
	    private int tripleMathMin(int a, int b, int c) {
	        return Math.min(a, Math.min(b, c));
	    }
	    
	}
}