package cei37.matriz;

/*
 * 1504. Count Submatrices With All Ones
Medium

751

55

Add to List

Share
Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.

 

Example 1:

Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:

Input: mat = [[0,1,1,0],
              [0,1,1,1],
              [1,1,1,0]]
Output: 24
Explanation:
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3. 
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2. 
There are 2 rectangles of side 3x1. 
There is 1 rectangle of side 3x2. 
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
Example 3:

Input: mat = [[1,1,1,1,1,1]]
Output: 21
Example 4:

Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5
 */
public class CountSubmatricesWithAllOnes {

	public static void main(String[] args) {
		//CountSubmatricesWithAllOnes.MySolution sol = new CountSubmatricesWithAllOnes().new MySolution();
		CountSubmatricesWithAllOnes.OtherSolution sol = new CountSubmatricesWithAllOnes().new OtherSolution();
		//OtherSolution
		int[][] mat1 = {
			{1,0,1 },
			{1,1,0 },
			{1,1,0 },
		};

		int[][] mat2 = {
			{0,1,1,0 },
			{0,1,1,1 },
			{1,1,1,0 },
		};
		int[][] mat3 = {
			{1,1,1,1,1,1 }
		};
		int[][] mat4 = {
			{1,0,1 },
			{0,1,0 },
			{1,0,1},
		};

		System.out.println(sol.numSubmat(mat1));
	}

	//my solution is not working "yet", need to understand first the approach to solved it
	//I thought using a commulative approach will work, however it doesn't.
	//it looks like the correct approach is to use an histogram
	class MySolution {
	    public int numSubmat(int[][] mat) {
	    	
	    	int sum = 0;
	    	for (int i=0; i<mat.length; i++) {
	    		for (int j=0; j<mat[i].length; j++) {
	    			if (mat[i][j] == 0) {
	    				continue;
	    			}
	    			sum++;
	    			sum += count(mat, i + 1, j, true);
	    			sum += count(mat, i, j + 1, false);
	    		}
	    	}
	    	
	        return sum;
	    }
	    
	    public int count(int[][] mat, int i, int j, boolean row) {
	    	if (i >= mat.length || j >= mat[i].length) {
	    		return 0;
	    	}
	    	if (mat[i][j] == 1) {
				return 1 + (row ? count(mat, i + 1, j, row) : count(mat, i, j + 1, row));
			} else {
				return (row ? count(mat, i + 1, j, row) : count(mat, i, j + 1, row));
			}
	    }
	}

	class OtherSolution {
	    public int numSubmat(int[][] mat) {
	        int row = mat.length;
	        int col = mat[0].length;
	         
	        for(int r= 0; r<row;r++){
	            for(int c = col-2; c>=0; c--){
	                if(mat[r][c] == 1){
	                    mat[r][c] += mat[r][c+1];
	                }
	            }
	        }
	        int count = 0;
	        for(int r= 0; r<row;r++){
	            for(int c = 0; c < col; c++){
	                
	                int min_width = mat[r][c];
	                for(int d = r;d<row;d++){
	                    if(mat[d][c] ==0){ break;}
	                    
	                    min_width = Math.min(min_width, mat[d][c]);
	                    count += min_width;
	                } 
	            }
	        }
	        return count;
	        
	    }
	}
}