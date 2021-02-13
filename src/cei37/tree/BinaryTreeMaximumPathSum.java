package cei37.tree;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		TreeUtils.TreeNode node = new TreeUtils.TreeNode(-10);
		node.left = new TreeUtils.TreeNode(9);
		node.right = new TreeUtils.TreeNode(20);
		node.right.left = new TreeUtils.TreeNode(15);
		node.right.right = new TreeUtils.TreeNode(7);

		node.prettyPrint();
		
		BinaryTreeMaximumPathSum btm = new BinaryTreeMaximumPathSum();
		System.out.println(btm.maxPathSum(node));
	}

    public int maxPathSum(TreeUtils.TreeNode root) {
    	int a = maxPathSum(root, 0);
    	int b = maxPathSum(root.left, 0);
    	int c = maxPathSum(root.right, 0);
    	int x = Math.max(a, b);

    	return Math.max(x, c);
    }
    
    public int maxPathSum(TreeUtils.TreeNode root, int sum) {
    	
    	return 0;
    }
}