package cei37.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//this is not done YET

/*
 (▰︶︹︺▰)
 
 * 
 * Uncrossed Lines

We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:
1  4  2
|  \
|   \
|    \
1  2  4

Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:

Input: A = [2, 5, 1, 2, 5], 
       B = [10,5, 2, 1, 5, 2]
Output: 3
Example 3:

Input: A = [1,3,7,1,7,5], 
       B = [1,9,2,5,1]
Output: 2
 

Note:

1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000


 */
public class UncrossedLines {

	public static void main(String[] args) {
		UncrossedLines un = new UncrossedLines();
		

	}

    public int maxUncrossedLines(int[] A, int[] B) {
    	
    	if (A == null || A.length == 0 ||B == null || B.length == 0) return 0;
    	
    	Map<Integer, Integer> setA = new HashMap<>();
    	Map<Integer, Integer> setB = new HashMap<>();
    	
    	for (int i=0; i<A.length; i++) {
    		setA.put(A[i], i);
    	}
    	for (int i=0; i<B.length; i++) {
    		setB.put(B[i], i);
    	}
    	
    	int aLen = A.length, indexA = 0;
    	int bLen = B.length, indexB = 0;
    	int connections = 0;

    	while(indexA < aLen || indexB < bLen) {
    		int aDis = getConnection(A[indexA], setB);
    		int bDis = getConnection(B[indexB], setA);
    		
    		if (aDis >= 0 && bDis >= 0) {
    			if (aDis == bDis) {
    				connections++;
    				indexA++;
    				indexB++;
    			} else if (aDis > bDis) {
    				connections++;
    				indexA++;
    				indexB++;
    			}
    		} else if (aDis >= 0 && bDis == -1) {
    			
    		} else if (bDis >= 0 && aDis == -1) {
    			
    		}
    	}
    	
    	return connections;
    }
    
    public int getConnection(int num, Map<Integer, Integer> map) {
    	return map.getOrDefault(num, -1);
    }
}
