package cei37.tree;


/*
 * 1008. Construct Binary Search Tree from Preorder Traversal

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant 
of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, 
then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search 
tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		ConstructBinarySearchTreeFromPreorderTraversal c = new ConstructBinarySearchTreeFromPreorderTraversal();
		int[] arr = new int[] {
			8,5,1,7,10,12
		};
		
		TreeNode root = c.bstFromPreorder(arr);
		c.preDFS(root);
	}

	public TreeNode bstFromPreorder(int tree[]) {
		if (tree == null || tree.length == 0) return null;
		//left child 2*i + 1
		//right child 2*i + 2
		
		return bstFromPreorder(tree, 0);
	}
	
	public TreeNode bstFromPreorder(int tree[], int i) {
		
		if (i >= tree.length) return null;
		
		TreeNode root = new TreeNode(tree[i]);
		int l_idx = 2*i + 1;
		int r_idx = 2*i + 2;
		if (l_idx < tree.length && tree[l_idx] < root.val)
			root.left = bstFromPreorder(tree, l_idx);
		if (r_idx < tree.length && tree[r_idx] > root.val)
			root.right = bstFromPreorder(tree,r_idx);
		
		return root;
	}
	
	public void preDFS(TreeNode node) {
		if (node == null) return;
		
		System.out.println(node.val);
		preDFS(node.left);
		preDFS(node.right);
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
}