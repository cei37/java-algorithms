package cei37.tree;

/*

671. Second Minimum Node In a Binary Tree
Easy

744

1000

Add to List

Share
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

 

 

Example 1:


Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:


Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 

Constraints:

The number of nodes in the tree is in the range [1, 25].
1 <= Node.val <= 231 - 1
root.val == min(root.left.val, root.right.val) for each internal node of the tree.

 */
public class SecondMinimumNode {

	public static void main(String[] args) {
		//[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
		TreeUtils.TreeNode node = new TreeUtils.TreeNode(2);
		node.left = new TreeUtils.TreeNode(2);
		node.right = new TreeUtils.TreeNode(2);
		//node.right.left = new TreeUtils.TreeNode(5);
		//node.right.right = new TreeUtils.TreeNode(7);

		node.prettyPrint();
		
		SecondMinimumNode se = new SecondMinimumNode();
		System.out.println(se.findSecondMinimumValue(node));
	}

    
    
    
    int min1;
    long ans = Long.MAX_VALUE;
    public void dfs(TreeUtils.TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeUtils.TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}
