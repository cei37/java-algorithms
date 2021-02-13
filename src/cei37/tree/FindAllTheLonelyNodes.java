package cei37.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * 1469. Find All The Lonely Nodes

In a binary tree, a lonely node is a node that is the only child of its parent node. 
The root of the tree is not lonely because it does not have a parent node.

Given the root of a binary tree, return an array containing the values of all lonely 
nodes in the tree. Return the list in any order.

 

Example 1:


Input: root = [1,2,3,null,4]
Output: [4]
Explanation: Light blue node is the only lonely node.
Node 1 is the root and is not lonely.
Nodes 2 and 3 have the same parent and are not lonely.
Example 2:


Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
Output: [6,2]
Explanation: Light blue nodes are lonely nodes.
Please remember that order doesn't matter, [2,6] is also an acceptable answer.
Example 3:



Input: root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
Output: [77,55,33,66,44,22]
Explanation: Nodes 99 and 88 share the same parent. Node 11 is the root.
All other nodes are lonely.
Example 4:

Input: root = [197]
Output: []
Example 5:

Input: root = [31,null,78,null,28]
Output: [78,28]
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
Each node's value is between [1, 10^6].
 */
public class FindAllTheLonelyNodes {

	public static void main(String[] args) {
		//Test 1
		TreeUtils.TreeNode n1 = new TreeUtils.TreeNode(1);
		n1.left = new TreeUtils.TreeNode(2);
		n1.left.right = new TreeUtils.TreeNode(4);
		n1.right = new TreeUtils.TreeNode(3);
		n1.prettyPrint();
		FindAllTheLonelyNodes f1 = new FindAllTheLonelyNodes();
		for (Integer n : f1.getLonelyNodes(n1)) {
			System.out.print(n + ",  ");
		}
		System.out.println("\n");
		
		//Test 2
		TreeUtils.TreeNode n2 = new TreeUtils.TreeNode(7);
		n2.left = new TreeUtils.TreeNode(1);
		n2.left.left = new TreeUtils.TreeNode(6);
		n2.right = new TreeUtils.TreeNode(4);
		n2.right.left = new TreeUtils.TreeNode(5);
		n2.right.right = new TreeUtils.TreeNode(3);
		n2.right.right.right = new TreeUtils.TreeNode(2);
		n2.prettyPrint();
		FindAllTheLonelyNodes f2 = new FindAllTheLonelyNodes();
		for (Integer n : f2.getLonelyNodes(n2)) {
			System.out.print(n + ",  ");
		}
		System.out.println("\n");
		
		//Test 3
		TreeUtils.TreeNode n3 = new TreeUtils.TreeNode(11);
		n3.left = new TreeUtils.TreeNode(99);
		n3.left.left = new TreeUtils.TreeNode(77);
		n3.left.left.left = new TreeUtils.TreeNode(55);
		n3.left.left.left.left = new TreeUtils.TreeNode(33);
		n3.right = new TreeUtils.TreeNode(88);
		n3.right.right = new TreeUtils.TreeNode(66);
		n3.right.right.right = new TreeUtils.TreeNode(44);
		n3.right.right.right.right = new TreeUtils.TreeNode(22);
		n3.prettyPrint();
		FindAllTheLonelyNodes f3 = new FindAllTheLonelyNodes();
		for (Integer n : f3.getLonelyNodes(n3)) {
			System.out.print(n + ",  ");
		}
		System.out.println("\n");
		
	}

    public List<Integer> getLonelyNodes(TreeUtils.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        getLonelyNodes(root, list);
    	return list;
    }
    
    public void getLonelyNodes(TreeUtils.TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        if (node.left != null && node.right == null) {
        	list.add(node.left.val);
        }
        
        if (node.left == null && node.right != null) {
        	list.add(node.right.val);
        }
        getLonelyNodes(node.left, list);
        getLonelyNodes(node.right, list);
    }
}