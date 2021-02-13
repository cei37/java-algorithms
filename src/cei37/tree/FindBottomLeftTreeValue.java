package cei37.tree;


/*
 * 513. Find Bottom Left Tree Value

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.


 */
public class FindBottomLeftTreeValue {

	public static void main(String[] args) {
		
		TreeUtils.TreeNode node1 = new TreeUtils.TreeNode(2);
		node1.left = new TreeUtils.TreeNode(2);
		node1.right = new TreeUtils.TreeNode(3);
		node1.right.right = new TreeUtils.TreeNode(4);
		
		node1.prettyPrint();
		FindBottomLeftTreeValue f1 = new FindBottomLeftTreeValue();
		System.out.println(f1.hasPathSum(node1, 4));
		//*****************

		
		TreeUtils.TreeNode node2 = new TreeUtils.TreeNode(1);
		node2.left = new TreeUtils.TreeNode(2);
		node2.left.left = new TreeUtils.TreeNode(4);
		node2.right = new TreeUtils.TreeNode(3);
		node2.right.right = new TreeUtils.TreeNode(6);
		node2.right.left = new TreeUtils.TreeNode(5);
		node2.right.left.left = new TreeUtils.TreeNode(7);
		
		node2.prettyPrint();
		FindBottomLeftTreeValue f2 = new FindBottomLeftTreeValue();
		System.out.println(f2.hasPathSum(node2, 16));
		//*****************
		
		TreeUtils.TreeNode node3 = new TreeUtils.TreeNode(3);
		node3.left = new TreeUtils.TreeNode(2);
		node3.left.left = new TreeUtils.TreeNode(3);
		node3.left.right = new TreeUtils.TreeNode(1);
		node3.right = new TreeUtils.TreeNode(4);
		node3.right.left = new TreeUtils.TreeNode(6);
		node3.right.left.left = new TreeUtils.TreeNode(3);
		node3.right.right = new TreeUtils.TreeNode(5);
		
		node3.prettyPrint();
		FindBottomLeftTreeValue f3 = new FindBottomLeftTreeValue();
		System.out.println(f3.hasPathSum(node3, 16));
		//*****************
		
		TreeUtils.TreeNode node4 = new TreeUtils.TreeNode(1);
		node4.prettyPrint();
		FindBottomLeftTreeValue f4 = new FindBottomLeftTreeValue();
		System.out.println(f4.hasPathSum(node4, 1));
		//*****************
		
		TreeUtils.TreeNode node5 = new TreeUtils.TreeNode(0);
		node5.right = new TreeUtils.TreeNode(-1);
		node5.prettyPrint();
		FindBottomLeftTreeValue f5 = new FindBottomLeftTreeValue();
		System.out.println(f5.hasPathSum(node5, 0));
		//*****************

		TreeUtils.TreeNode node6 = new TreeUtils.TreeNode(5);
		node6.left = new TreeUtils.TreeNode(4);
		node6.left.left = new TreeUtils.TreeNode(11);
		node6.left.left.left = new TreeUtils.TreeNode(7);
		node6.left.left.right = new TreeUtils.TreeNode(2);
		node6.right = new TreeUtils.TreeNode(8);
		node6.right.left = new TreeUtils.TreeNode(13);
		node6.right.right = new TreeUtils.TreeNode(4);
		node6.right.right.right = new TreeUtils.TreeNode(1);
		
		node6.prettyPrint();
		FindBottomLeftTreeValue f6 = new FindBottomLeftTreeValue();
		System.out.println(f6.hasPathSum(node6, 22));
		
		//*****************

		TreeUtils.TreeNode node7 = new TreeUtils.TreeNode(1);
		node7.left = new TreeUtils.TreeNode(2);
		
		node7.prettyPrint();
		FindBottomLeftTreeValue f7 = new FindBottomLeftTreeValue();
		System.out.println(f7.hasPathSum(node7, 1));

	}
	
    public boolean hasPathSum(TreeUtils.TreeNode root, int sum) {
    	if (root == null) return false;
    	return hasPathSum(root, sum, 0);
    }
    
    public boolean hasPathSum(TreeUtils.TreeNode root, int sum, int newSum) {
    	if (root == null) {
    		return false;
    	}
    	newSum += root.val;
    	if (root.left == null && root.right == null) {
    		return sum == newSum;
    	}

    	return hasPathSum(root.left, sum, newSum) || hasPathSum(root.right, sum, newSum);
    }
}
