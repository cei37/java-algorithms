package cei37.tree;

/*
 * Given a sorted (incresing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class MinimalTree {

	public static void main(String[] args) {

		int[] data = new int[] {
		 1, 2, 3, 4, 5, 6, 7, 8, 9, 10		
		};

		MinimalTree mt = new MinimalTree();
		
		TreeNode node = mt.createMinimalBST(data);
		
		mt.dfs(node);
		
	}

	public TreeNode createMinimalBST(int[] data) {
		if (data == null || data.length == 0) return null;
		return createMinimalBST(data, 0, data.length-1);
	}
	
	public TreeNode createMinimalBST(int[] data, int start, int end) {

		if (start > end) return null;
		
		int mid = (end + start)/2;
		TreeNode node = new TreeNode(data[mid]);
		node.left = createMinimalBST(data, start, mid - 1);
		node.right = createMinimalBST(data, mid + 1, end);
		
		return node;
	}
	
	public void dfs(TreeNode node) {
		if (node == null) return;
		dfs(node.left);
		System.out.println(node.val);
		dfs(node.right);
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