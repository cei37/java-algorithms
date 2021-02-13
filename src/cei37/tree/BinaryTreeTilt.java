package cei37.tree;

/*
 * 563. Binary Tree Tilt

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree 
node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.
 */
public class BinaryTreeTilt {

	public static void main(String[] args) {
		TreeUtils.TreeNode node = new TreeUtils.TreeNode(3);
		node.left = new TreeUtils.TreeNode(2);
		node.left.left = new TreeUtils.TreeNode(3);
		node.left.right = new TreeUtils.TreeNode(1);
		node.right = new TreeUtils.TreeNode(4);
		node.right.left = new TreeUtils.TreeNode(6);
		node.right.right = new TreeUtils.TreeNode(5);
		
		BinaryTreeTilt bt = new BinaryTreeTilt();
		node.prettyPrint();
		
		System.out.println(bt.findTilt(node));
		
	}

	int tilt = 0;
    public int findTilt(TreeUtils.TreeNode root) {
        helper(root);
    	return tilt;
    }
    public int helper(TreeUtils.TreeNode root) {
     
    	if (root == null) return 0;
    	
    	int left = helper(root.left);
    	int right = helper(root.right);
    	
    	tilt += Math.abs(left-right);
    	
    	return left + right + root.val; 
    }
}
