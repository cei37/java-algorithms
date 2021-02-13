package cei37.graph;

import java.util.*;

/*
 * 1059. All Paths from Source Lead to Destination
Medium

205

34

Add to List

Share
Given the edges of a directed graph where edges[i] = [ai, bi] indicates there is an edge between nodes ai and bi, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually, end at destination, that is:

At least one path exists from the source node to the destination node
If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
The number of possible paths from source to destination is a finite number.
Return true if and only if all roads from source lead to destination.

 

Example 1:


Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
Output: false
Explanation: It is possible to reach and get stuck on both node 1 and node 2.
Example 2:


Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
Output: false
Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
Example 3:


Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
Output: true
Example 4:


Input: n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
Output: false
Explanation: All paths from the source node end at the destination node, but there are an infinite 
number of paths, such as 0-1-2, 0-1-1-2, 0-1-1-1-2, 0-1-1-1-1-2, and so on.
Example 5:


Input: n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
Output: false
Explanation: There is infinite self-loop at destination node.
 

Constraints:

1 <= n <= 104
0 <= edges.length <= 104
edges.length == 2
0 <= ai, bi <= n - 1
0 <= source <= n - 1
0 <= destination <= n - 1
The given graph may have self-loops and parallel edges.
 */
public class AllPathsFromSourceLeadToDestination {

	public static void main(String[] args) {
		int[][] edges1 = {
			{0,1},
			{0,2},
			{1,3},
			{2,3},
		};
		int[][] edges2 = {
			{0,1},
			{0,3},
			{1,2},
			{2,1},
		};
		int[][] edges3 = {
			{0,1},
			{0,2},
		};
		int[][] edges4 = {
			{0,1},
			{0,2},
			{0,3},
			{0,3},
			{1,2},
			{1,3},
			{1,4},
			{2,3},
			{2,4},
			{3,4},
		};
		int[][] edges5 = {
		};
		int n = 1;
		int source = 0;
		int destination = 0;
		AllPathsFromSourceLeadToDestination all = new AllPathsFromSourceLeadToDestination();
		
		System.out.println(all.leadsToDestination(n, edges5, source, destination));

	}

    // We don't use the state WHITE as such anywhere. Instead, the "null" value in the states array below is a substitute for WHITE.
    enum Color { GRAY, BLACK };
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        List<Integer>[] graph = buildDigraph(n, edges);
        return leadsToDest(graph, source, destination, new Color[n]);
    }
    
    private boolean leadsToDest(List<Integer>[] graph, int node, int dest, Color[] states) {
        
        // If the state is GRAY, this is a backward edge and hence, it creates a loop.
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }
        
        // If this is a leaf node, it should be equal to the destination.
        if (graph[node].isEmpty()) {
            return node == dest;
        }
        
        // Now, we are processing this node. So we mark it as GRAY
        states[node] = Color.GRAY;
        
        for (int next : graph[node]) {
            
            // If we get a `false` from any recursive call on the neighbors, we short circuit and return from there.
            if (!leadsToDest(graph, next, dest, states)) {
                return false;
            }
        }
        
        // Recursive processing done for the node. We mark it BLACK
        states[node] = Color.BLACK;
        return true;
    }
    
    private List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        return graph;
    }
    
    

	/*
	 * This is my solution, however it is not passing the last test case in leetcode, it is a big one
	 * 
	 */
    public boolean leadsToDestination_2(int n, int[][] edges, int source, int destination) {
    	if (edges == null) return false;
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	for (int i=0; i<edges.length; i++) {
    		if (edges[i].length > 0) {
    			int s = edges[i][0];
        		int t = edges[i][1];

        		if (!map.containsKey(s)) {
        			map.put(s, new ArrayList<Integer>());
        		}
        		map.get(s).add(t);
    		}
    	}

    	Integer visited[] = new Integer[n];
    	return dfs(map, source, destination, visited, n);
    }
    
    
    public boolean dfs(Map<Integer, List<Integer>> map, int source, 
    		int destination, Integer visited[], int n) {
    	
    	if (visited[source] != null) {
    		return visited[source] == 2;
    	}
    	
    	List<Integer> children = map.get(source);
    	
    	if (children == null) {
    		return source == destination;
    	}

    	visited[source] = 1;
    	for (int child : children) {
    		if (!dfs(map, child, destination, visited, n)) {
    			return false;
    		}
    	}
    	
    	visited[source] = 2;
    	return true;
    }
}