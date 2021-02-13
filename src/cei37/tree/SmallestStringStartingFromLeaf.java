package cei37.tree;

/*
988. Smallest String Starting From Leaf

Given the root of a binary tree, each node has a value from 0 to 25 representing the 
letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, 
"ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

 

Example 1:



Input: [0,1,2,3,4,3,4]
Output: "dba"
Example 2:



Input: [25,1,3,1,3,0,2]
Output: "adz"
Example 3:



Input: [2,2,1,null,1,0,null,0]
Output: "abc"
 

Note:

The number of nodes in the given tree will be between 1 and 8500.
Each node in the tree will have a value between 0 and 25.
 */
public class SmallestStringStartingFromLeaf {

	public static void main(String[] args) {
		//Test 4
		TreeUtils.TreeNode n1 = new TreeUtils.TreeNode(0);
		n1.left = new TreeUtils.TreeNode(1);
		n1.left.left = new TreeUtils.TreeNode(3);
		n1.left.right = new TreeUtils.TreeNode(4);
		n1.right = new TreeUtils.TreeNode(2);
		n1.right.left = new TreeUtils.TreeNode(3);
		n1.right.right = new TreeUtils.TreeNode(4);
		n1.prettyPrint();
		SmallestStringStartingFromLeaf f1 = new SmallestStringStartingFromLeaf();
		System.out.println(f1.smallestFromLeaf(n1));

	}

	String small = "~";
    public String smallestFromLeaf(TreeUtils.TreeNode root) {
        if (root == null) return "";
        smallestFromLeaf(root, new StringBuilder());
    	return small;
    }
    
    public void smallestFromLeaf(TreeUtils.TreeNode node, StringBuilder sb) {
        if (node == null) return;
        
        sb.append((char)('a' + node.val));
        if (node.left == null && node.right == null) {
        	String s = sb.reverse().toString();
        	sb.reverse();
        	if (s.compareTo(small) <= -1) {
        		small = s;
        	}
        }
        
        smallestFromLeaf(node.left, sb);
        smallestFromLeaf(node.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
