package cei37.tree;

public class CountUnivalueSubtrees {

	public static void main(String[] args) {
		TreeUtils.TreeNode t1 = new TreeUtils.TreeNode(5);
		t1.left = new TreeUtils.TreeNode(1);
		t1.left.left = new TreeUtils.TreeNode(5);
		t1.left.right = new TreeUtils.TreeNode(5);
		t1.right = new TreeUtils.TreeNode(5);
		t1.right.right = new TreeUtils.TreeNode(5);
		t1.prettyPrint();
		CountUnivalueSubtrees c1 = new CountUnivalueSubtrees();
		System.out.println(c1.countUnivalSubtrees(t1));
		
		
		
		TreeUtils.TreeNode t2 = new TreeUtils.TreeNode(5);
		t2.left = new TreeUtils.TreeNode(5);
		t2.right = new TreeUtils.TreeNode(5);
		t2.left.left = new TreeUtils.TreeNode(5);
		t2.left.right = new TreeUtils.TreeNode(5);
		t2.right.right = new TreeUtils.TreeNode(5);
		t2.prettyPrint();
		CountUnivalueSubtrees c2 = new CountUnivalueSubtrees();
		System.out.println(c2.countUnivalSubtrees(t2));
		
	}

    public int countUnivalSubtrees(TreeUtils.TreeNode root) {
        
    	return 0;
    }
}