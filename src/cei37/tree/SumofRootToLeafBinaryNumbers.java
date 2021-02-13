package cei37.tree;

import java.util.HashMap;
import java.util.Map;

/*
 * 1022. Sum of Root To Leaf Binary Numbers

You are given the root of a binary tree where each node has a value 0 or 1.  
Each root-to-leaf path represents a binary number starting with the most 
significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then 
this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from 
the root to that leaf.

Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.


Example 1:

Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
Example 2:

Input: root = [0]
Output: 0
Example 3:

Input: root = [1]
Output: 1
Example 4:

Input: root = [1,1]
Output: 3
 */
public class SumofRootToLeafBinaryNumbers {

	public static void main(String[] args) {
		TreeUtils.TreeNode n = new TreeUtils.TreeNode(1);
		n.left = new TreeUtils.TreeNode(0);
		n.left.left = new TreeUtils.TreeNode(0);
		n.left.right = new TreeUtils.TreeNode(1);
		n.right = new TreeUtils.TreeNode(1);
		n.right.left = new TreeUtils.TreeNode(0);
		n.right.right = new TreeUtils.TreeNode(1);
		
		n.prettyPrint();
		
		SumofRootToLeafBinaryNumbers sum = new SumofRootToLeafBinaryNumbers();
		System.out.println(sum.sumRootToLeaf(n));
	}
	
	public int sumRootToLeaf(TreeUtils.TreeNode root) {
        
        return sumRootToLeaf(root, 0);
    }

	public int sumRootToLeaf(TreeUtils.TreeNode root, int sum) {
        
		if (root == null) return 0;
		
		sum = 2 * sum + root.val;
		
		if (root.left == null && root.right == null) {
			return sum;
		}
	    
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }
	
	
	
	
	
    public int sumRootToLeaf_3(TreeUtils.TreeNode root) {
    	if (root == null) return 0;
    	
    	sumRootToLeaf(root, "");
    	return total;
    }
    
    public void sumRootToLeaf(TreeUtils.TreeNode root, String bit) {
    	if (root == null) return;
    	
    	if (root.left == null && root.right == null) {
    		total += binaryToDecimal(bit + root.val);
    		return;
    	}
    	
    	sumRootToLeaf(root.left, bit + root.val);
    	sumRootToLeaf(root.right, bit + root.val);
    }
	
	int total;
    public int sumRootToLeaf_2(TreeUtils.TreeNode root) {
    	if (root == null) return 0;
    	
    	StringBuilder sb = new StringBuilder();
    	sumRootToLeaf(root, sb);
    	return total;
    }
    
    public void sumRootToLeaf(TreeUtils.TreeNode root, StringBuilder sb) {
    	
    	if (root == null) return;

    	sb.append(root.val);
    	sumRootToLeaf(root.left, sb);
    	sumRootToLeaf(root.right, sb);

    	if (root.left == null && root.right == null) {
    		total += binaryToDecimal(sb.toString());
    	}
    	sb.deleteCharAt(sb.length() - 1);
    }

    private int binaryToDecimal(String n) {
    	int pow = 1;
    	int sum = 0;
    	for (int i=n.length()-1; i>=0; i--) {
    		if (n.charAt(i) == '1') {
    			sum += pow;
    		}
    		pow *= 2;
    	}
    	
    	return sum;
    }
}
