package cei37.matriz;

import java.util.*;

/*
 * 498. Diagonal Traverse

Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix 
in diagonal order as shown in the below image.

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:

 

Note:

The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {

	public static void main(String[] args) {
		
		int[][] m1 = new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		};
		
		int[][] m2 = new int[][] {
			{ 2, 3 },
		};

		int[][] m3 = new int[][] {
			{ },
		};
		
		int[][] m4 = new int[][] {
			{ 6, 9, 7},
		};
		
		DiagonalTraverse d = new DiagonalTraverse();
		
		for (int i : d.findDiagonalOrder(m4)) {
			System.out.print(i + ", ");
		}
	}

    public int[] findDiagonalOrder(int[][] matrix) {
    	if (matrix == null || matrix.length==0) return new int[]{};
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	int key = 0;
    	for (int i=0; i<matrix.length; i++) {
    		for (int j=0; j<matrix[i].length; j++) {
        		key = i + j;
        		if (!map.containsKey(key)) {
        			map.put(key, new ArrayList<Integer>());
        		}
        		map.get(key).add(matrix[i][j]);
        	}
    	}
    	
    	int length = matrix.length * (matrix.length==0 ? 0 : matrix[0].length);
    	int[] res = new int[length];
    	int pos = 0;
    	for (int k=0; k< 2*length; k++) {
    		if (map.get(k) == null) break;
    		if (k % 2 == 0) {
    			for (int j=map.get(k).size()-1; j >=0; j--) {
    				res[pos++] = map.get(k).get(j);
    			}
    		} else {
    			for (int j=0; j<map.get(k).size(); j++) {
    				res[pos++] = map.get(k).get(j);
    			}
    		}
    	}

        return res;
    }
}