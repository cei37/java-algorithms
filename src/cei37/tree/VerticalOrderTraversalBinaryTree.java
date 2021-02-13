package cei37.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import cei37.tree.MinimalTree.TreeNode;

/*
 * 987. Vertical Order Traversal of a Binary Tree
Medium

952

1949

Add to List

Share
Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:



Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 */
public class VerticalOrderTraversalBinaryTree {

	public static void main(String[] args) {
		VerticalOrderTraversalBinaryTree t = new VerticalOrderTraversalBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		for (List<Integer> list : t.verticalTraversal(root)) {
			for (Integer n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

    public List<List<Integer>> verticalTraversal(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if (root == null) return res;
    	
    	Map<Integer, List<Data>> map = new TreeMap<Integer, List<Data>>();
    	verticalTraversal(root, map, 0, 0);

    	for (Map.Entry<Integer, List<Data>> e : map.entrySet()) {
    		List<Data> d = e.getValue();
    		Collections.sort(d, (a, b) -> a.row == b.row ? a.val - b.val : a.row - b.row);
    		List<Integer> r = new ArrayList<Integer>();
    		for (Data n : d) {
    			r.add(n.val);
    		}
    		res.add(r);
    	}
    	
    	return res; 
    }
    
    public void verticalTraversal(TreeNode node, Map<Integer, List<Data>> map, int row, int col) {
    	if (node == null) return;
    	if (map.get(col) == null) {
    		map.put(col, new ArrayList<Data>());
    	}
    	map.get(col).add(new Data(node.val, row));
    	verticalTraversal(node.left, map, row+1, col-1);
    	verticalTraversal(node.right, map, row+1, col+1);
    }
    
    class Data {
    	int val;
    	int row;
    	public Data(int val, int row) {
    		this.val = val;
    		this.row = row;
    	}
    }
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
}
