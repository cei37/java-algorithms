package cei37.automata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 1192. Critical Connections in a Network

There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections 
forming a network where connections[i] = [a, b] represents a connection between servers a and b. 
Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.

 */
public class CriticalConnectionsInNetworkTarjan {

	public static void main(String[] args) {

		CriticalConnectionsInNetworkTarjan ccn = new CriticalConnectionsInNetworkTarjan();
		
		int n = 6;
		List<List<Integer>> connections = new ArrayList<List<Integer>>() { {
			add(new ArrayList<Integer>() { {
				add(0);
				add(1);
			}});
			add(new ArrayList<Integer>() { {
				add(1);
				add(2);
			}});
			add(new ArrayList<Integer>() { {
				add(2);
				add(0);
			}});
			add(new ArrayList<Integer>() { {
				add(1);
				add(3);
			}});
			add(new ArrayList<Integer>() { {
				add(3);
				add(4);
			}});
			add(new ArrayList<Integer>() { {
				add(4);
				add(5);
			}});
			add(new ArrayList<Integer>() { {
				add(5);
				add(3);
			}});
		}};

		for (List<Integer> connection : ccn.criticalConnections(n, connections)) {
			for (Integer con : connection) {
				System.out.print(con + "  ");
			}
			System.out.println();
		}
	}

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (connections == null || connections.isEmpty()) return result;
        
        Map<Integer, Set<Integer>> tree = buildTree(connections);
        int[] disc = new int[n], low = new int[n];
        Arrays.fill(disc, -1);
        
    	for (int i = 0; i < n; i++) {
    		if (disc[i] == -1) {
    			dfs(tree, result, i, low, disc, i);
    		}
    	}
        
        return result;
    }

    int time = 0;
    public void dfs(Map<Integer, Set<Integer>> tree, List<List<Integer>> result, int node, 
    	int[] low, int[] disc, int pre) {

    	disc[node] = low[node] = ++time;

    	for (Integer v : tree.get(node)) {
    		if (v == pre) {
    			continue; // if parent vertex, ignore
    		}
    		
    		if (disc[v] == -1) { // if not discovered
    			dfs(tree, result, v, low, disc, node);
    			low[node] = Math.min(low[node], low[v]);
    			if (low[v] > disc[node]) {
    				// node - v is critical, there is no path for v to reach back to u 
    				//or previous vertices of node
    				result.add(Arrays.asList(node, v));
    			}
    		} else { 
    			// if v discovered and is not parent of node, update low[node], 
    			//cannot use low[node] because node is not subtree of v
    			low[node] = Math.min(low[node], disc[v]);
    		}
    	}
    }

    public Map<Integer, Set<Integer>> buildTree(List<List<Integer>> connections) {
    	Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (List<Integer> conn : connections) {
        	Integer node0 = conn.get(0);
        	Integer node1 = conn.get(1);
        			
        	if (tree.get(node0) == null) {
        		Set<Integer> list = new HashSet<>();
        		list.add(node1);
        		tree.put(node0, list);
        	} else {
        		tree.get(node0).add(node1);
        	}

        	if (tree.get(node1) == null) {
        		Set<Integer> list = new HashSet<>();
        		list.add(node0);
        		tree.put(node1, list);
        	} else {
        		tree.get(node1).add(node0);
        	}
        }
        return tree;
    }
}