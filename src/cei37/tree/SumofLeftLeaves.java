package cei37.tree;

public class SumofLeftLeaves {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);

		SumofLeftLeaves sl = new SumofLeftLeaves();
		
		System.out.println(sl.sumOfLeftLeaves(node));
		
	}

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        return sumOfLeftLeaves(root, false);
    }
    
    public int sumOfLeftLeaves(TreeNode root, boolean left) {
        if (root == null) return sum;
        
        sumOfLeftLeaves(root.left, true);
        if (left && root.left == null && root.right == null) {
        	sum += root.val;
        }
        sumOfLeftLeaves(root.right, false);
        return sum;
    }
	
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
