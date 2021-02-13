package cei37.graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * 429. N-ary Tree Level Order Traversal
Medium

716

50

Add to List

Share
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children 
is separated by the null value (See examples).

Example 1:

Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 

Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
 */

public class N_aryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		N_aryTreeLevelOrderTraversal t1 = new N_aryTreeLevelOrderTraversal();
		Node node = new Node(1);
		
		List<Node> node3 = new ArrayList<Node>();
		node3.add(new Node(5));
		node3.add(new Node(6));
		
		List<Node> node1 = new ArrayList<Node>();
		Node node33 = new Node(3);
		node33.children = node3;
		node1.add(node33);
		node1.add(new Node(2));
		node1.add(new Node(4));
		
		node.children = node1;
		//t1.levelOrder(node);
		
		for (List<Integer> p : t1.levelOrder(node)) {
			for (Integer i : p) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root == null) return result;
    	Deque<Node> q = new ArrayDeque<Node>();
    	q.offer(root);
    	
    	while(!q.isEmpty()) {
    		List<Integer> res = new ArrayList<Integer>();
			int size = q.size();
			for (int i=0; i<size; i++) {
				Node node = q.poll();
				res.add(node.val);
				if (node.children != null) {
					q.addAll(node.children);
				}
			}
			result.add(res);
    	}
        return result;
    }
    
	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
}