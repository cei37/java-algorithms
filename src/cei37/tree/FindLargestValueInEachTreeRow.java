package cei37.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).


Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,null,2]
Output: [1,2]
Example 5:

Input: root = []
Output: []
 */
public class FindLargestValueInEachTreeRow {

	public static void main(String[] args) {
		TreeUtils.TreeNode n1 = new TreeUtils.TreeNode(1);
		n1.left = new TreeUtils.TreeNode(3);
		n1.left.left = new TreeUtils.TreeNode(5);
		n1.left.right = new TreeUtils.TreeNode(3);
		n1.right = new TreeUtils.TreeNode(2);
		n1.right.right = new TreeUtils.TreeNode(9);

		FindLargestValueInEachTreeRow fl = new FindLargestValueInEachTreeRow();
		n1.prettyPrint();
		
		List<Integer> list = fl.largestValues(n1);
		for (Integer e : list) {
			System.out.println(e);
		}
	}

    public List<Integer> largestValues(TreeUtils.TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	
    	if (root == null) return res;
    	
    	Deque<TreeUtils.TreeNode> q = new ArrayDeque<>();
    	TreeUtils.TreeNode node = root;
    	q.offer(node);
    	while(!q.isEmpty()) {
    		int size = q.size();
    		int max = Integer.MIN_VALUE;
    		for (int i=0; i<size; i++) {
    			TreeUtils.TreeNode ele = q.poll();
    			if (ele.val > max) {
    				max = ele.val;
    			}
    			if (ele.left != null) {
    				q.offer(ele.left);
    			}
    			if (ele.right != null) {
    				q.offer(ele.right);
    			}
    		}
    		res.add(max);
    	}
    	return res;
    }
}
