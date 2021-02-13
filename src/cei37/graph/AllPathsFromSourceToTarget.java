package cei37.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 797. All Paths From Source to Target
Medium

1569

85

Add to List

Share
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all 
possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node
 i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
Example 3:

Input: graph = [[1],[]]
Output: [[0,1]]
Example 4:

Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
Example 5:

Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
The input graph is guaranteed to be a DAG.

 */
public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		AllPathsFromSourceToTarget all = new AllPathsFromSourceToTarget();
		int[][] g1 = new int[][] {
			{1,2},
			{3},
			{3},
			{},
		};

		int[][] g2 = new int[][] {
			{4,3,1},
			{3,2,4},
			{3},
			{4},
			{}
		};

		int[][] g3 = new int[][] {
			{1,2,3},
			{2},
			{3},
			{},
		};

		int[][] g4 = new int[][] {
			{1,3},
			{2},
			{3},
			{}
		};
		

		List<List<Integer>> res = all.allPathsSourceTarget(g1);
		
		for (List<Integer> parent : res) {
			for (Integer child : parent) {
				System.out.print(child + " -> ");
			}
			System.out.println("\n");
		}
	}

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	List<List<Integer>> res = new ArrayList<>();
    	
    	int source = 0;
    	int target = graph.length - 1;

    	dfs(graph, res, new ArrayList<Integer>(), source, target);
    	
    	return res;
    }
    
    public void dfs(int[][] graph, List<List<Integer>> res, List<Integer> path, int source, int target) {
    	path.add(source);
    	if (source == target) {
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	int[] children = graph[source];
    	for (int child : children) {
    		dfs(graph, res, path, child, target);
    		path.remove(path.size() - 1);
    	}
    }

    public List<List<Integer>> allPathsSourceTarget_1(int[][] graph) {
    	List<List<Integer>> res = new ArrayList<>();
    	
    	int source = 0;
    	int target = graph.length - 1;

    	Queue<List<Integer>> q = new LinkedList<>();
    	q.add(Arrays.asList(source));

    	while (!q.isEmpty()) {
    		List<Integer> parent = q.poll();
    		int current = parent.get(parent.size() - 1);
    		if (current == target) {
				res.add(new ArrayList<Integer>(parent));
				continue;
			}
    		for (int child : graph[current]) {
    			List<Integer> l = new ArrayList<>(parent);
    			l.add(child);
    			q.offer(l);
    		}
    	}
    	
    	return res;
    }
}