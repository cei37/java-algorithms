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
public class CriticalConnectionsInNetwork {

	public static void main(String[] args) {

		CriticalConnectionsInNetwork ccn = new CriticalConnectionsInNetwork();
		
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
        
    	for (int i = 0; i < connections.size(); i++) {
    		int node1 = connections.get(i).get(0);
    		int node2 = connections.get(i).get(1);
    		
    		tree.get(node1).remove(node2);
    		tree.get(node2).remove(node1);
    		
    		Set<Integer> visited = new HashSet<>();
    		
    		dfs(tree, visited, 0);
    		
    		if (visited.size() != n) {
    			result.add(new ArrayList<Integer>() { {
    					add(node1);
    					add(node2);
    			}});
    		}

    		tree.get(node1).add(node2);
    		tree.get(node2).add(node1);
    	}
        
        return result;
    }

    public void dfs(Map<Integer, Set<Integer>> tree, Set<Integer> visited, int node) {
    	visited.add(node);

    	for (Integer n : tree.get(node)) {
    		if (!visited.contains(n)) {
    			dfs(tree, visited, n);
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