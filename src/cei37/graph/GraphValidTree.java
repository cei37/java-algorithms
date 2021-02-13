package cei37.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/*
 * 261. Graph Valid Tree
Medium

1128

39

Add to List

Share
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class GraphValidTree {

    static class Graph {
    	int nodes;
    	int[][] edges;
    	boolean expected = false;
    	public Graph(int nodes, int[][] edges, boolean expected) {
    		this.nodes = nodes;
    		this.edges = edges;
    		this.expected = expected;
    	}
    }

	public static void main(String[] args) {
		List<Graph> list = new ArrayList<>();
		/*list.add(new Graph(5, new int[][] {
			{0,1}, {0,2}, {0,3}, {1,4}
		}, true));
		list.add(new Graph(5, new int[][] {
			{0,1}, {1,2}, {2,3}, {1,3}, {1,4}
		}, false));*/
		list.add(new Graph(5, new int[][] {
			{0,1}, {0,4}, {1,4}, {2,3}
		}, false));
		list.add(new Graph(1, new int[][] {
		}, true));
		list.add(new Graph(4, new int[][] {
			{2,3}, {1,2}, {1,3}
		}, false));
		list.add(new Graph(3, new int[][] {
			{0,1}, {2,3}
		}, false));
		
		GraphValidTree gvt = new GraphValidTree();
		for (Graph g : list) {
			System.out.println(gvt.validTree(g.nodes, g.edges) + " expected -> "+ g.expected);
		}
	}

	/*
	 * Let's use the "union find" 
	 * 
	 */
    public boolean validTree(int n, int[][] edges) {
    	
    	//if we have 5 nodes, there should be 4 edges to be a valid tree
    	if (n - 1 != edges.length) {
    		return false;
    	}
    	
    	UnionFind uf = new UnionFind(new int[n + 1]);
    	for (int e[] : edges) {
    		if (!uf.union(e[0], e[1])) {
    			return false;
    		}
    	}
    	return true;
    }
    
    class UnionFind {
    	int[] arr;
    	public UnionFind(int arr[]) {
    		this.arr = arr;
    		for (int i=0; i<arr.length; i++) {
    			arr[i] = i;
    		}
    	}
    	
    	public boolean union(int u, int v) {
    		int a = find(u);
    		int b = find(v);
    		if (a == b) {
    			return false;
    		}
    		arr[a] = b;
    		return true;
    	}
    	
    	public int find(int u) {
    		if (arr[u] == u) {
    			return u;
    		} else {
    			return find(arr[u]);
    		}
    	}
    }
    
	/*
	 * Use a map to keep track of how we got into each node.
	 * let's use DFS with a stack
	 */
    public boolean validTree_4(int n, int[][] edges) {
    	
    	//if we have 5 nodes, there should be 4 edges to be a valid tree
    	if (n - 1 != edges.length) {
    		return false;
    	}
		if (edges.length == 0 && n == 1) {
			return true;
		}

    	Map<Integer, List<Integer>> g = new HashMap<>();
    	for (int e[] : edges) {
    		if (!g.containsKey(e[0])) {
    			g.put(e[0], new ArrayList<Integer>());
    		}
    		if (!g.containsKey(e[1])) {
    			g.put(e[1], new ArrayList<Integer>());
    		}
    		g.get(e[0]).add(e[1]);
    		g.get(e[1]).add(e[0]);
    	}
    	Map<Integer, Integer> parent = new HashMap<>();
    	parent.put(0, -1);
    	
		Stack<Integer> s = new Stack<>();
		s.add(0);
		while(!s.isEmpty()) {
			int node = s.pop();
			if (g.get(node) != null) {
				for (int neighbour : g.get(node)) {
					//don't look a the trivial cycle
					if (parent.get(node) == neighbour) {
						continue;
					}
					
					if (parent.containsKey(neighbour)) {
						return false;
					}
					s.push(neighbour);
					parent.put(neighbour, node);
				}
			}
		}

        return parent.size() == n;
    }

	/*
	 * For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't 
	 * possibly be fully connected. Any more, and it has to contain cycles. Additionally, if the 
	 * graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, 
	 * and therefore must be a tree!
	 * 
	 * let's use DFS with a stack
	 */
    public boolean validTree_3(int n, int[][] edges) {
    	
    	//if we have 5 nodes, there should be 4 edges to be a valid tree
    	if (n - 1 != edges.length) {
    		return false;
    	}
		if (edges.length == 0 && n == 1) {
			return true;
		}

    	Map<Integer, List<Integer>> g = new HashMap<>();
    	for (int e[] : edges) {
    		if (!g.containsKey(e[0])) {
    			g.put(e[0], new ArrayList<Integer>());
    		}
    		if (!g.containsKey(e[1])) {
    			g.put(e[1], new ArrayList<Integer>());
    		}
    		g.get(e[0]).add(e[1]);
    		g.get(e[1]).add(e[0]);
    	}

		Stack<Integer> s = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		s.add(0);
		while(!s.isEmpty()) {
			int node = s.pop();
			if (g.containsKey(node) && !visited.contains(node)) {
				visited.add(node);
				for (int e : g.get(node)) {
					s.push(e);
				}
			}
		}
		if (visited.size() == n) {
			return true;
		}

        return false;
    }
	
	/*
	 * For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't 
	 * possibly be fully connected. Any more, and it has to contain cycles. Additionally, if the 
	 * graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, 
	 * and therefore must be a tree!
	 * 
	 * let's use BFS
	 */
    public boolean validTree_2(int n, int[][] edges) {
    	
    	//if we have 5 nodes, there should be 4 edges to be a valid tree
    	if (n - 1 != edges.length) {
    		return false;
    	}
		if (edges.length == 0 && n == 1) {
			return true;
		}
    	Map<Integer, List<Integer>> g = new HashMap<>();
    	for (int e[] : edges) {
    		if (!g.containsKey(e[0])) {
    			g.put(e[0], new ArrayList<Integer>());
    		}
    		if (!g.containsKey(e[1])) {
    			g.put(e[1], new ArrayList<Integer>());
    		}
    		g.get(e[0]).add(e[1]);
    		g.get(e[1]).add(e[0]);
    	}
    	
    	
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		q.offer(0);
		while(!q.isEmpty()) {
			int node = q.poll();
			if (g.get(node) != null && !visited.contains(node)) {
				visited.add(node);
				for (int e : g.get(node)) {
					q.add(e);
    			}
			}
		}
		if (visited.size() == n) {
			return true;
		}

        return false;
    }
	
	/*
	 * For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't 
	 * possibly be fully connected. Any more, and it has to contain cycles. Additionally, if the 
	 * graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, 
	 * and therefore must be a tree!
	 * 
	 * let's use DFS recursive
	 */
    public boolean validTree_1(int n, int[][] edges) {
    	
    	//if we have 5 nodes, there should be 4 edges to be a valid tree
    	if (n - 1 != edges.length) {
    		return false;
    	}

    	Map<Integer, List<Integer>> g = new HashMap<>();
    	for (int e[] : edges) {
    		if (!g.containsKey(e[0])) {
    			g.put(e[0], new ArrayList<Integer>());
    		}
    		if (!g.containsKey(e[1])) {
    			g.put(e[1], new ArrayList<Integer>());
    		}
    		g.get(e[0]).add(e[1]);
    		g.get(e[1]).add(e[0]);
    	}
    	
    	for (int i=0; i<n; i++) {
    		Set<Integer> visited = new HashSet<>();
    		dfs(g, visited, i);
    		if (visited.size() == n) {
    			return true;
    		}
    	}

        return false;
    }
    
    public void dfs(Map<Integer, List<Integer>> g, Set<Integer> visited, int node) {
    	visited.add(node);
    	if (g.get(node) == null) {
    		return;
    	}
    	
    	for (Integer n : g.get(node)) {
    		if (!visited.contains(n)) {
    			dfs(g, visited, n);
    		}
    	}
    }
}