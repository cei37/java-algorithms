package cei37.tree;

/*
 * 437. Path Sum III
Medium

4397

309

Add to List

Share
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSumIII {

	public static void main(String[] args) {
		PathSumIII p = new PathSumIII();
		TreeUtils.TreeNode node = new TreeUtils.TreeNode(10);
		node.left = new TreeUtils.TreeNode(5);
		node.left.left = new TreeUtils.TreeNode(3);
		node.left.left.left = new TreeUtils.TreeNode(3);
		node.left.left.right = new TreeUtils.TreeNode(-2);
		node.left.right = new TreeUtils.TreeNode(2);
		node.left.right.right = new TreeUtils.TreeNode(1);
		node.right = new TreeUtils.TreeNode(-3);
		node.right.right = new TreeUtils.TreeNode(11);
		node.prettyPrint();
		System.out.println(p.pathSum(node, 8));
	}

    public int pathSum(TreeUtils.TreeNode root, int sum) {
    	if (root == null) return 0;

    	return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int dfs(TreeUtils.TreeNode node, int sum) {
    	if (node == null) return 0;
    	
    	int res = sum - node.val;
    	
    	return (res == 0 ? 1 : 0) + dfs(node.left, res) + dfs(node.right, res);
    }
}