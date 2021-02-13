package cei37.tree;

public class FromArrayRepresentation {

	public static void main(String[] args) {
		FromArrayRepresentation far = new FromArrayRepresentation();
		int[] arr = new int[] {
				3,9,20,15,7
		};
		
		TreeNode root = far.createTreeFromArray(arr);
		far.dfs(root);
	}
	
	public TreeNode createTreeFromArray(int tree[]) {
		if (tree == null || tree.length == 0) return null;
		//left child 2*i + 1
		//right child 2*i + 2
		
		return createTreeFromArray(tree, 0);
	}
	
	public TreeNode createTreeFromArray(int tree[], int i) {
		
		if (i >= tree.length) return null;
		
		TreeNode root = new TreeNode(tree[i]);
		root.left = createTreeFromArray(tree, 2*i + 1);
		root.right = createTreeFromArray(tree, 2*i + 2);
		
		return root;
	}
	
	public void dfs(TreeNode root) {
		if (root == null) return;
		
		dfs(root.left);
		System.out.println(root.val);
		dfs(root.right);
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