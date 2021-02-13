package cei37.topologicalSort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
/*
 * 210. Course Schedule II
Medium

2789

146

Add to List

Share
There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you 
must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering 
of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return 
an empty array.


Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1
 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 
Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */
public class CourseScheduleII {

	public static void main(String[] args) {
		CourseScheduleII cs = new CourseScheduleII();
		int[][] prerequisites = new int[][] {
			//{1,0},{2,0},{3,1},{3,2}
			//{1, 0}, {0,1}
			{1,0}
		};
		int numCourses = 3;
		for(int i : cs.findOrder(numCourses, prerequisites)) {
			System.out.print(i + " ");
		}
	}
	
	

	static int WHITE = 1;
	static int GRAY = 2;
	static int BLACK = 3;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	if (prerequisites == null || prerequisites.length == 0) {
    		int[] res = new int[numCourses];
    		for (int i=0, j=numCourses-1; i<numCourses; i++, j--) {
    			res[i] = j;
    		}
    		return res;
    	}

        Map<Integer, List<Integer>> graf = new HashMap<Integer, List<Integer>>();
        for (int[] p : prerequisites) {
        	if (!graf.containsKey(p[1])) {
        		graf.put(p[1], new ArrayList<Integer>());
        	}
        	graf.get(p[1]).add(p[0]);
        }
        
        Map<Integer, Integer> status = new HashMap<Integer,Integer>();
        for (int i=0; i<numCourses; i++) {
        	status.put(i, WHITE);
        }

        Stack<Integer> stack = new Stack<>();
        for (int n=0; n<numCourses; n++) {
        	if (status.get(n) == WHITE ) {
        		dfs(graf, n, stack, status);
        	}
        }

        if (isPossible) {
        	int[] res = new int[numCourses];
        	for (int i=0; !stack.isEmpty(); i++) {
            	res[i] = stack.pop();
            }
        	return res;
        } else {
        	return new int[0];
        }
    }
    
    boolean isPossible = true;
    public void dfs(Map<Integer, List<Integer>> tree, int node, Stack<Integer> stack, Map<Integer, Integer> status) {
    	
    	if (!isPossible) {
    		return;
    	}
    	
    	status.put(node, GRAY);

    	if (tree.get(node) != null) {
    		for (Integer n : tree.get(node)) {
        		if (status.get(n) == WHITE) {
        			dfs(tree, n, stack, status);
        		} else if (status.get(n) == GRAY) {
        			isPossible = false;
        		}
        	}
    	}

		stack.add(node);
		status.put(node, BLACK);
    }

}
