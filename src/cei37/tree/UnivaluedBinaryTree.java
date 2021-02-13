package cei37.tree;

/*
 * 965. Univalued Binary Tree

A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

 

Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false
 

Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].
 */
public class UnivaluedBinaryTree {

	public static void main(String[] args) {
		//Test 1
		TreeUtils.TreeNode n1 = new TreeUtils.TreeNode(1);
		n1.left = new TreeUtils.TreeNode(1);
		n1.left.right = new TreeUtils.TreeNode(1);
		n1.right = new TreeUtils.TreeNode(1);
		n1.prettyPrint();
		UnivaluedBinaryTree f1 = new UnivaluedBinaryTree();
		System.out.println(f1.isUnivalTree(n1));
		System.out.println("\n");
		
		//Test 2
		TreeUtils.TreeNode n2 = new TreeUtils.TreeNode(1);
		n2.left = new TreeUtils.TreeNode(1);
		n2.left.left = new TreeUtils.TreeNode(1);
		n2.right = new TreeUtils.TreeNode(1);
		n2.right.left = new TreeUtils.TreeNode(1);
		n2.right.right = new TreeUtils.TreeNode(1);
		n2.right.right.right = new TreeUtils.TreeNode(1);
		n2.prettyPrint();
		UnivaluedBinaryTree f2 = new UnivaluedBinaryTree();
		System.out.println(f2.isUnivalTree(n2));
		System.out.println("\n");
		
		//Test 3
		TreeUtils.TreeNode n3 = new TreeUtils.TreeNode(1);
		n3.left = new TreeUtils.TreeNode(1);
		n3.left.left = new TreeUtils.TreeNode(1);
		n3.left.left.left = new TreeUtils.TreeNode(55);
		n3.left.left.left.left = new TreeUtils.TreeNode(1);
		n3.right = new TreeUtils.TreeNode(1);
		n3.right.right = new TreeUtils.TreeNode(1);
		n3.right.right.right = new TreeUtils.TreeNode(1);
		n3.right.right.right.right = new TreeUtils.TreeNode(1);
		n3.prettyPrint();
		UnivaluedBinaryTree f3 = new UnivaluedBinaryTree();
		System.out.println(f3.isUnivalTree(n3));

	}
	
	int value = 0;
    public boolean isUnivalTree(TreeUtils.TreeNode root) {
    	if (root == null) return true;
    	value = root.val;
        return isUnivalTreeHelper(root);
    }
    
    public boolean isUnivalTreeHelper(TreeUtils.TreeNode root) {
    	if (root == null) return true;
    	if (root.val != value) return false;
        return isUnivalTreeHelper(root.left) && isUnivalTreeHelper(root.right);
    }
}
