package cei37.tree;

import java.util.HashMap;

/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		int[] inorder = new int[] {
			9,3,15,20,7	
		};
		int[] postorder = new int[] {
			9,15,7,20,3
		};
		ConstructBinaryTreefromInorderandPostorderTraversal c = new ConstructBinaryTreefromInorderandPostorderTraversal();
		c.buildTree(inorder, postorder).prettyPrint();
	}

	
	
	int post_idx;
	int[] postorder;
	int[] inorder;
	HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

	public TreeUtils.TreeNode buildTree(int[] inorder, int[] postorder) {
		this.postorder = postorder;
		this.inorder = inorder;
		// start from the last postorder element
		post_idx = postorder.length - 1;

		// build a hashmap value -> its index
		int idx = 0;
		for (Integer val : inorder)
			idx_map.put(val, idx++);
		return helper(0, inorder.length - 1);
	}

	public TreeUtils.TreeNode helper(int in_left, int in_right) {
		// if there is no elements to construct subtrees
		if (in_left > in_right)
			return null;

		// pick up post_idx element as a root
		int root_val = postorder[post_idx];
		TreeUtils.TreeNode root = new TreeUtils.TreeNode(root_val);

		// root splits inorder list
		// into left and right subtrees
		int index = idx_map.get(root_val);

		// recursion
		post_idx--;
		// build right subtree
		root.right = helper(index + 1, in_right);
		// build left subtree
		root.left = helper(in_left, index - 1);
		return root;
	}
}
