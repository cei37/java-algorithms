package cei37.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
1110. Delete Nodes And Return Forest
Medium

1599

53

Add to List

Share
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 

Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
 */
public class DeleteNodesAndReturnForest {

	public static void main(String[] args) {
		//DeleteNodesAndReturnForest.MySolution de = new DeleteNodesAndReturnForest().new MySolution();
		//DeleteNodesAndReturnForest.BetterSolution de = new DeleteNodesAndReturnForest().new BetterSolution();
		DeleteNodesAndReturnForest.SimilarToMySolution de = new DeleteNodesAndReturnForest().new SimilarToMySolution();

		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(16);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(25);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(18);
		root.right.left.right = new TreeNode(22);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(14);
		
		root.prettyPrint();
		
		int[] to_delete = { 1, 3, 7 };
		
		System.out.println("To Delete");
		for (int n : to_delete) {
			System.out.print(n + ", ");
		}
		
		System.out.println("\n\n Result\n");
		System.out.println("-----------------------------------");
		List<TreeNode> forest = de.delNodes(root, to_delete);
		for (TreeNode node : forest) {
			node.prettyPrint();
			System.out.println("-----------------------------------");
		}
	}

	class MySolution {
	    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	    	List<TreeNode> res = new ArrayList<>();
	    	
	    	if (to_delete == null || to_delete.length == 0) {
	    		res.add(root);
	    		return res;
	    	}
	
	    	Set<Integer> set = new HashSet();
	    	for (int n : to_delete) {
	    		set.add(n);
	    	}
	
	    	Deque<TreeNode> q = new ArrayDeque<>();
	    	q.offer(root);
	
	    	while(!q.isEmpty()) {
	    		TreeNode node = q.poll();
	        	if (set.contains(node.val)) {
	        		if (node.left != null)
	        			q.offer(node.left);
	        		if (node.right != null)
	        			q.offer(node.right);
	        	} else {
	        		dfs(node, null, false, q, set);
	        		if (node != null) {
	        			res.add(node);
	        		}
	        	}
	    	}
	    	
	    	return res;
	    }
	    
	    
	    public void dfs(TreeNode node, TreeNode prev, boolean left, Deque<TreeNode> q, Set<Integer> set) {
	    	if (node == null) return;
	
	    	if (set.contains(node.val)) {
	    		if (node.left != null)
	    			q.offer(node.left);
	    		if (node.right != null)
	    			q.offer(node.right);
	    		
	    		if (prev == null) {
	    			node = null;
	    			return;
	    		}
	    		
	    		if (left) {
	    			prev.left = null;
	    		} else {
	    			prev.right = null;
	    		}
	
	    		return;
	    	}
	    	dfs(node.left, node, true, q, set);
	    	dfs(node.right, node, false, q, set);
	    }
	}

	class BetterSolution {
	    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        List<TreeNode> result = new ArrayList<>();
	        Set<Integer> deleted = new HashSet<>();
	        for (int item : to_delete) {
	            deleted.add(item);
	        }
	        delNodesUtil(root, true, deleted, result);
	        return result;
	    }
	    
	    private TreeNode delNodesUtil(TreeNode root, boolean isRoot, Set<Integer> deleted, List<TreeNode> result) {
	        if (root == null) return null;
	        boolean isDeleted = deleted.contains(root.val);
	        if (isRoot && !isDeleted) {
	            result.add(root);
	        }
	        root.left = delNodesUtil(root.left, isDeleted, deleted, result);
	        root.right = delNodesUtil(root.right, isDeleted, deleted, result);
	        return isDeleted == true ? null : root;
	    }
	    
	    
	}
	
	class SimilarToMySolution {
	    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        List<TreeNode> res = new ArrayList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        
	        HashSet<Integer> toDelete = new HashSet<>();
	        for (int i : to_delete) toDelete.add(i); //O(d) where d = to_del.len
	        
	        queue.add(root);
	        if (!toDelete.contains(root.val)) res.add(root);
	        // else root = null;

	        while (queue.size() > 0) { //O(V+E)
	            TreeNode cur = queue.remove();

	            if (cur.left != null) {
	                queue.add(cur.left); //anyway need to explore its child nodes
	                if (toDelete.contains(cur.left.val)) cur.left = null; //cut the connection parent->child
	                else if (toDelete.contains(cur.val)) res.add(cur.left); //add to res as a new root
	            }
	            if (cur.right != null) {
	                queue.add(cur.right);
	                if (toDelete.contains(cur.right.val)) cur.right = null;
	                else if (toDelete.contains(cur.val)) res.add(cur.right);
	            }
	            // if (toDelete.contains(cur.val)) cur = null; //didn't really need it.
	        } return res;
	    }
	}
}