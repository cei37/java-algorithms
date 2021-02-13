package cei37.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class NumberofConnectedComponentsUndirected {

    static class Graph {
    	int nodes;
    	int[][] edges;
    	int expected = 0;
    	public Graph(int nodes, int[][] edges, int expected) {
    		this.nodes = nodes;
    		this.edges = edges;
    		this.expected = expected;
    	}
    }

	public static void main(String[] args) {
		List<Graph> list = new ArrayList<>();

		list.add(new Graph(5, new int[][] {
			{0,1}, {1,2}, {3,4}
		}, 2));
		
		list.add(new Graph(5, new int[][] {
			{0,1}, {1,2}, {2,3}, {3,4}
		}, 1));
		
		NumberofConnectedComponentsUndirected gvt = new NumberofConnectedComponentsUndirected();
		for (Graph g : list) {
			System.out.println(gvt.countComponents(g.nodes, g.edges) + " expected -> "+ g.expected);
		}
	}
	
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length ==0) return n;
        
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
    	
    	int count = 0;
    	Set<Integer> visited = new HashSet<>();
    	for (int i=0; i<n; i++) {
    		if (!visited.contains(i)) {
    			dfs(g, visited, i);
    			count++;
    		}
    	}
    	
    	return count;
    }
    
    void dfs(Map<Integer, List<Integer>> g, Set<Integer> visited, int node) {
    	visited.add(node);
    	if (g.get(node) == null) {
    		return;
    	}
    	for (Integer child : g.get(node)) {
    		if (!visited.contains(child)) {
    			dfs(g, visited, child);
    		}
    	}
    }
    
    
    /*
     * this is the best solution,
     * let's practice doing something different with DFS
     */
    public int countComponents_1(int n, int[][] edges) {
        if (edges == null || edges.length ==0) return n;
        
        UnionFind uf = new UnionFind(new int[n+1]);
        int count = 0;
        for (int e[] : edges) {
        	if (uf.union(e[0], e[1])) {
        		count++;
        	}
        }
    	return n - count;
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
}
