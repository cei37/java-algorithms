package cei37.tree;


public class FindMaximumDepth {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(1);
		node.left.right.right = new TreeNode(11);
		node.left.right.right.right = new TreeNode(11);
		node.right = new TreeNode(4);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(5);
		node.right.right.left = new TreeNode(9);
		
		FindMaximumDepth fm = new FindMaximumDepth();
		
		System.out.println(fm.findMaxDepth(node));

	}
	//"Bottom-up" Solution
	public int findMaxDepth(TreeNode node) {
		if (node == null) return 0;
		/*
		int left = findMaxDepth(node.left) + 1;
		int right = findMaxDepth(node.right) + 1;
		return Math.max(left, right);
		*/
		return Math.max(findMaxDepth(node.left), findMaxDepth(node.right)) + 1;
	}
	
	/*
	 //"Top-down" Solution
	int max = 0;
	public int findMaxDepth(TreeNode node) {
		findMaxDepth(node, 0);
		return max;
	}
	
	public void findMaxDepth(TreeNode node, int n) {
		
		if (node == null)  {
			max = Math.max(max, n);
			return;
		}
		
		findMaxDepth(node.left, n + 1);
		findMaxDepth(node.right, n + 1);
	}*/

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
