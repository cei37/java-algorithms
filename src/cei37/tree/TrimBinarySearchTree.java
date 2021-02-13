package cei37.tree;

/*
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

 

Example 1:


Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]

Example 2:


Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
Example 3:

Input: root = [1], low = 1, high = 2
Output: [1]
Example 4:

Input: root = [1,null,2], low = 1, high = 3
Output: [1,null,2]
Example 5:

Input: root = [1,null,2], low = 2, high = 4
Output: [2]
 

Constraints:

The number of nodes in the tree in the range [1, 104].
0 <= Node.val <= 104
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 104

 */
public class TrimBinarySearchTree {

	public static void main(String[] args) {
		TreeUtils.TreeNode root = new TreeUtils.TreeNode(3);
		root.right = new TreeUtils.TreeNode(4);
		root.left = new TreeUtils.TreeNode(0);
		root.left.right = new TreeUtils.TreeNode(2);
		root.left.right.left = new TreeUtils.TreeNode(1);
		root.prettyPrint();

		int low = 1;
		int high = 3;
		TrimBinarySearchTree trim = new TrimBinarySearchTree();
		trim.trimBST(root, low, high);
		
		root.prettyPrint();
	}

    public TreeUtils.TreeNode trimBST(TreeUtils.TreeNode root, int low, int high) {
    	
    	removeLow(root, low);
    	
    	return root;
    }

    private void removeLow(TreeUtils.TreeNode root, int low) {
    	TreeUtils.TreeNode node = root;
    	TreeUtils.TreeNode prev = root;
    	while(node != null) {
    		if (low < node.val) {
    			node = node.left;
    		} else {
    			if (node.left == null && node.right == null || node.left != null && node.right == null) {
    				node = null;
    			} else {
    				prev.right = node.right;
    				return;
    			}
    		}
    		prev = node;
    	}
    }
}