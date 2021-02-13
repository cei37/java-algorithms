package cei37.tree;

/*
 * 129. Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		//Test 1
		TreeUtils.TreeNode n1 = new TreeUtils.TreeNode(11);
		n1.left = new TreeUtils.TreeNode(3);
		n1.left.right = new TreeUtils.TreeNode(2);
		n1.right = new TreeUtils.TreeNode(4);
		n1.prettyPrint();
		SumRoottoLeafNumbers f1 = new SumRoottoLeafNumbers();
		System.out.println(f1.sumNumbers(n1));
		System.out.println("\n");
		
		//Test 2
		TreeUtils.TreeNode n2 = new TreeUtils.TreeNode(1);
		n2.left = new TreeUtils.TreeNode(2);
		n2.left.left = new TreeUtils.TreeNode(3);
		n2.right = new TreeUtils.TreeNode(4);
		n2.right.left = new TreeUtils.TreeNode(5);
		n2.right.right = new TreeUtils.TreeNode(6);
		n2.right.right.right = new TreeUtils.TreeNode(7);
		n2.prettyPrint();
		SumRoottoLeafNumbers f2 = new SumRoottoLeafNumbers();
		System.out.println(f2.sumNumbers(n2));
		System.out.println("\n");
		
		//Test 3
		TreeUtils.TreeNode n3 = new TreeUtils.TreeNode(2);
		n3.left = new TreeUtils.TreeNode(1);
		n3.left.left = new TreeUtils.TreeNode(3);
		n3.left.left.left = new TreeUtils.TreeNode(4);
		n3.left.left.left.left = new TreeUtils.TreeNode(6);
		n3.right = new TreeUtils.TreeNode(7);
		n3.right.right = new TreeUtils.TreeNode(8);
		n3.right.right.right = new TreeUtils.TreeNode(9);
		n3.right.right.right.right = new TreeUtils.TreeNode(10);
		n3.prettyPrint();
		SumRoottoLeafNumbers f3 = new SumRoottoLeafNumbers();
		System.out.println(f3.sumNumbers(n3));
		
		//Test 4
		TreeUtils.TreeNode n4 = new TreeUtils.TreeNode(1);
		n4.left = new TreeUtils.TreeNode(2);
		n4.right = new TreeUtils.TreeNode(3);
		n4.prettyPrint();
		SumRoottoLeafNumbers f4 = new SumRoottoLeafNumbers();
		System.out.println(f4.sumNumbers(n4));

	}
	
	int totalSum = 0;
    public int sumNumbers(TreeUtils.TreeNode root) {
        if (root == null) return 0;
        sumNumbers(root, 0);
    	return totalSum;
    }
    
    public void sumNumbers(TreeUtils.TreeNode root, int sb) {
    	if (root == null) return;
        sb = sb * 10 + root.val;
        if (root.left == null && root.right == null) {
        	totalSum += sb;
        	return;
        }
        sumNumbers(root.left, sb);
        sumNumbers(root.right, sb);
    }
	
	
/*
	int totalSum = 0;
    public int sumNumbers_1(TreeUtils.TreeNode root) {
        if (root == null) return 0;
        sumNumbers(root, "");
    	return totalSum;
    }
    
    public void sumNumbers(TreeUtils.TreeNode root, String sb) {
    	if (root == null) return;
        sb += root.val;
        if (root.left == null && root.right == null) {
        	if (sb != null && sb.length() > 0)
        		totalSum+= Integer.valueOf(sb.toString());
        	return;
        }
        sumNumbers(root.left, sb);
        sumNumbers(root.right, sb);
    }
    */
}
