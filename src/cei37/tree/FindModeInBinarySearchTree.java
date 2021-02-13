package cei37.tree;

import java.util.ArrayList;
import java.util.List;

/*

501. Find Mode in Binary Search Tree
Easy

1207

396

Add to List

Share
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

 */
public class FindModeInBinarySearchTree {

	public static void main(String[] args) {
		TreeUtils.TreeNode root = new TreeUtils.TreeNode(1);
		root.right = new TreeUtils.TreeNode(2);
		root.right.left = new TreeUtils.TreeNode(2);
		
		FindModeInBinarySearchTree find = new FindModeInBinarySearchTree();
		
		for (Integer n : find.findMode(root)) {
			System.out.println(n);
		}

	}

	int maxCount = 0;
	int curCount = 0;
	int prev = Integer.MIN_VALUE;
    public int[] findMode(TreeUtils.TreeNode root) {
    	if (root == null) return new int[] {};
    	List<Integer> res = new ArrayList<>();
    	dfs(root, res);
    	
    	return res.stream().mapToInt(i -> i).toArray();
    }
    
    public void dfs(TreeUtils.TreeNode root, List<Integer> res) {
    	if (root == null) return;
    	
    	dfs(root.left, res);

    	if (prev == root.val) {
    		curCount++;
    	} else {
    		curCount = 1;
    	}
    	
    	if (curCount == maxCount) {
			res.add(root.val);
		} else if (curCount > maxCount) {
			res.clear();
			res.add(root.val);
			maxCount = curCount;
		}  
   
    	prev = root.val;
    	dfs(root.right, res);
    }
}