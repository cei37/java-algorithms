package cei37.arrays;

/*
 * 1252. Cells with Odd Values in a Matrix

Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices 
where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in 
row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.

 

Example 1:


Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
Example 2:


Input: n = 2, m = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 

Constraints:

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m

https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

 */
public class CellsWithOddValuesMatrix {

	public static void main(String[] args) {
		CellsWithOddValuesMatrix cell = new CellsWithOddValuesMatrix();
		int[][] indices = new int[][] {
			{0,1},
			{1,1}
		};
		int n = 2, m = 3;
		System.out.println(cell.oddCells(n, m, indices));
	}

    public int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] x: indices) {
            row[x[0]]++;
            col[x[1]]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] + col[j]) % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
	
	//no efficient
    public int oddCells2(int n, int m, int[][] indices) {
    	
    	if (indices == null || indices.length == 0) return 0;
    	
    	int[][] matrix = new int[n][m];
    	int count = 0; 
    	for (int point[] : indices) {
    		for (int i=0; i<n; i++) {
    			matrix[i][point[1]]++;
    			if (matrix[i][point[1]] % 2 != 0) {
    				count++;
    			} else {
    				count--;
    			}
    		}
    		for (int i=0; i<m; i++) {
    			matrix[point[0]][i]++;
    			if (matrix[point[0]][i] % 2 != 0) {
    				count++;
    			} else {
    				count--;
    			}
    		}
    	}
    	
    	return count;
    }
    
}
