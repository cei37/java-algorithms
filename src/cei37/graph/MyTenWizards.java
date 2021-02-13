package cei37.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MyTenWizards {

	public static void main(String[] args) {
		MyTenWizards my = new MyTenWizards();

        int[][] ids = {
    		{1, 5, 4}, //0 
    		{2, 3}, //1
    		{3, 7}, //2
    		{4}, //3
    		{5}, //4
    		{6, 8}, //5
    		{7}, //6
    		{8}, //7
    		{9}, //8
    		{}//9
        };
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            List<Integer> wizard = new ArrayList<>();
            for (int j = 0; j < ids[i].length; j++) {
                wizard.add(ids[i][j]);
            }
            wizards.add(wizard);
        }
        List<Integer> res = my.getShortestPath(wizards, 0, 9);
        my.printList(res);

	}

	public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
		List<Integer> res = new ArrayList<>();
		if (wizards == null || wizards.size() == 0) {
			return res;
		}
		
		int[] parents = new int[wizards.size()];
		for (int i=0; i<parents.length; i++) {
			parents[i] = i;
		}
		
		Set<Integer> visited = new HashSet<>();
		boolean found = bfs_visited(wizards, source, target, parents, visited);
		
		if (found) {
			return getPath(parents, source, target);
		}

		
		return res;
	}
	
	/**
	 * This is just a simple BFS
	 * @param wizards
	 * @param list
	 * @param target
	 */
	public boolean bfs_no_visited(List<List<Integer>> wizards, int source, int target, int[] parents) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(source);

		while(!q.isEmpty()) {
			int parent = q.poll();
			for (Integer child : wizards.get(parent)) {
				if (child == target) {
					parents[child] = parent;
					//System.out.println("Number found with BFS!");
					//return true;
					printList(getPath(parents, source, target));
				}
				parents[child] = parent;
				q.offer(child);
			}
		}
		return false;
	}

	/**
	 * This is just a simple BFS
	 * @param wizards
	 * @param list
	 * @param target
	 */
	public boolean bfs_visited(List<List<Integer>> wizards, int source, int target, 
			int[] parents, Set<Integer> visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(source);

		while(!q.isEmpty()) {
			int parent = q.poll();
			visited.add(parent);
			for (Integer child : wizards.get(parent)) {
				
				if (child == target) {
					parents[child] = parent;
					//System.out.println("Number found with BFS!");
					return true;
					//printList(getPath(parents, source, target));
				} else if (!visited.contains(child)){
					parents[child] = parent;
					q.offer(child);
				}
			}
		}
		return false;
	}

	public List<Integer> getPath(int[] parents, int source, int target) {
		List<Integer> res = new ArrayList<>();
		int t = target;
		while(t != source) {
			res.add(t);
			t = parents[t];
		}
		res.add(source);
		Collections.reverse(res);
		return res;
	}
	
	public void printList(List<Integer> list) {
		System.out.println("\n+++++++\n");
        for (int n : list) {
        	System.out.print(n + " -> ");
        }
	}

	/**
	 * This is just a simple DFS, this is not ideal to get the shortest path
	 * @param wizards
	 * @param list
	 * @param target
	 */
	public void dfs(List<List<Integer>> wizards, int source, int target, Set<Integer> visited) {
		if (visited.contains(source)) {
			return;
		}
		
		for (int i=0; i<wizards.get(source).size(); i++) {
			int num = wizards.get(source).get(i);
			if (num == target) {
				System.out.println("Number found with DFS!");
			} else {
				dfs(wizards, num, target, visited);
			}
		}
		visited.add(source);
	}
}