package cei37.tree;
import java.util.*;

/*
 * 113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

public class PathSumII {

	public static void main(String[] args) {
		//Test 1
		TreeUtils.TreeNode n1 = new TreeUtils.TreeNode(5);
		n1.left = new TreeUtils.TreeNode(4);
		n1.left.left = new TreeUtils.TreeNode(11);
		n1.left.left.left = new TreeUtils.TreeNode(7);
		n1.left.left.right = new TreeUtils.TreeNode(2);
		n1.right = new TreeUtils.TreeNode(8);
		n1.right.left = new TreeUtils.TreeNode(13);
		n1.right.right = new TreeUtils.TreeNode(4);
		n1.right.right.left = new TreeUtils.TreeNode(5);
		n1.right.right.right = new TreeUtils.TreeNode(1);
		n1.prettyPrint();
		PathSumII p1 = new PathSumII();
		System.out.println(p1.pathSum(n1, 22));
		System.out.println("\n");

	}

    public List<List<Integer>> pathSum(TreeUtils.TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<>();
    	List<Integer> path = new ArrayList<>();
    	if (root == null) return res;
    	int total = 0;
    	pathSum(root, res, path, sum, total);
    	return res;
    }
    
    public void pathSum(TreeUtils.TreeNode node, List<List<Integer>> res, List<Integer> path, int sum, int total) {
    	if (node == null) return;

    	path.add(node.val);
    	total += node.val;

    	if (node.left == null && node.right == null) {
    		if (total == sum) {
    			res.add(new ArrayList(path));
    		}
    	}
    	pathSum(node.left, res, path, sum, total);
    	pathSum(node.right, res, path, sum, total);
    	if (!path.isEmpty()) {
    		path.remove(path.size() - 1);
    	}
    }
}
