package cei37.topologicalSort;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * 207. Course Schedule
Medium

4500

190

Add to List

Share
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about 
how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 */
public class CourseScheduleBackTracking {
    static class Schedule {
    	int numCourses;
    	int[][] prerequisites;
    	boolean expected = false;
    	public Schedule(int numCourses, int[][] prerequisites, boolean expected) {
    		this.numCourses = numCourses;
    		this.prerequisites = prerequisites;
    		this.expected = expected;
    	}
    }

	public static void main(String[] args) {
		List<Schedule> list = new ArrayList<>();
		list.add(new Schedule(2, new int[][] {
			{1, 0 }
		}, true));
		list.add(new Schedule(2, new int[][] {
			{1, 0 },
			{0, 1 }
		}, false));
		list.add(new Schedule(4, new int[][] {
			{1,0},{2,0},{3,1},{3,2}
		}, true));

		
		CourseScheduleBackTracking cs = new CourseScheduleBackTracking();		
		for (Schedule s : list) {
			System.out.println(cs.canFinish(s.numCourses, s.prerequisites) + " expected --> " + s.expected);
		}
	}
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        
        //build my graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
        	if (!graph.containsKey(p[1])) {
        		graph.put(p[1], new ArrayList<Integer>());
        	}
        	graph.get(p[1]).add(p[0]);
        }
        
    	Set<Integer> backTrack = new HashSet<Integer>();
        for (int n=0; n<numCourses; n++) {
        	if (dfs(graph, n, backTrack)) {
        		//there is a cycle, it is impossible to finish the courses
        		return false;
        	}
        }
    	return true;
    }
    
    public boolean dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> backTrack) {
    	if (backTrack.contains(node)) {
    		return true;
    	}
    	if (graph.get(node) == null) {
    		return false;
    	}

    	backTrack.add(node);
    	boolean res = false;
		for (Integer n : graph.get(node)) {
    		if (dfs(graph, n, backTrack)) {
    			res = true;
    			break;
    		}
    	}
		backTrack.remove(node);
    	return res;
    }
}


