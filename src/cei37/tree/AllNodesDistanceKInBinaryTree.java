package cei37.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 863. All Nodes Distance K in Binary Tree

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  
The answer can be returned in any order.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.


Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 
Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.

 */
public class AllNodesDistanceKInBinaryTree {

	public static void main(String[] args) {
		TreeUtils.TreeNode node = new TreeUtils.TreeNode(3);
		node.left = new TreeUtils.TreeNode(5);
		node.left.left = new TreeUtils.TreeNode(6);
		node.left.right = new TreeUtils.TreeNode(2);
		node.left.right.left = new TreeUtils.TreeNode(7);
		node.left.right.right = new TreeUtils.TreeNode(4);
		node.right = new TreeUtils.TreeNode(1);
		node.right.left = new TreeUtils.TreeNode(0);
		node.right.right = new TreeUtils.TreeNode(8);
		node.prettyPrint();
		
		AllNodesDistanceKInBinaryTree all = new AllNodesDistanceKInBinaryTree();
		for (Integer n : all.distanceK(node, node.left, 3)) {
			System.out.println(n);
		}
	}

	Map<TreeUtils.TreeNode, TreeUtils.TreeNode> map = new HashMap<>();
	Set<TreeUtils.TreeNode> visited = new HashSet<>();
    public List<Integer> distanceK(TreeUtils.TreeNode root, TreeUtils.TreeNode target, int K) {
    	List<Integer> res = new ArrayList<>();
    	if (root == null || target == null) return res;
    	
    	dfs(root, null);

		Deque<TreeUtils.TreeNode> q = new ArrayDeque<>();
		q.offer(target);
		int k2 = 0;

		while(!q.isEmpty()) {
			int size = q.size();
			if (k2 == K) {
				for (int i=0; i<size; i++) {
    				TreeUtils.TreeNode node = q.poll();
    				res.add(node.val);
    			}
			} else {
				for (int i=0; i<size; i++) {
    				TreeUtils.TreeNode node = q.poll();
    				visited.add(node);
    				addToQueue(node, q);
    			}
			}
			k2++;
		}
    	
        return res;
    }
    
    public void addToQueue(TreeUtils.TreeNode node, Deque<TreeUtils.TreeNode> q) {
    	if (node != null) {
    		if (node.left != null && !visited.contains(node.left)) {
    			q.offer(node.left);
    		}
    		if (node.right != null && !visited.contains(node.right)) {
    			q.offer(node.right);
    		}
    		if (map.get(node) != null && !visited.contains(map.get(node))) {
    			q.offer(map.get(node));
    		}
    	}
    }
    
    public void dfs(TreeUtils.TreeNode node, TreeUtils.TreeNode parent) {
    	if (node == null) return;

    	map.put(node, parent);
    	dfs(node.left, node);
    	dfs(node.right, node);
    }
    
}