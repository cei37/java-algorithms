package cei37.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/*
 * 230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest 
frequently? How would you optimize the kthSmallest routine?

 

Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 */
public class KthSmallestElementBST {

	public static void main(String[] args) {
		TreeUtils.TreeNode root = new TreeUtils.TreeNode(3);
		root.left = new TreeUtils.TreeNode(1);
		root.left.right = new TreeUtils.TreeNode(2);
		root.right = new TreeUtils.TreeNode(4);
		
		root.prettyPrint();
		KthSmallestElementBST k = new KthSmallestElementBST();
		System.out.println(k.kthSmallest(root, 2));
	}

	public int kthSmallest(TreeUtils.TreeNode root, int k) {
    	List<Integer> list = new ArrayList<>();
    	kthSmallest2(root, k, list);
    	if (k >= 0 && k <= list.size()) {
    		return list.get(k-1);
    	} else {
    		return -1;
    	}
    }
    
    public void kthSmallest2(TreeUtils.TreeNode root, int k, List<Integer> list) {
    	if (root == null) return;
    	kthSmallest2(root.left, k, list);
    	list.add(root.val);
    	kthSmallest2(root.right, k, list);
    }
	
    public int kthSmallest_1(TreeUtils.TreeNode root, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    	kthSmallest(root, k, pq);
    	return pq.peek();
    }
    
    public void kthSmallest(TreeUtils.TreeNode root, int k, PriorityQueue<Integer> pq) {
    	if (root == null) return;
    	
    	pq.add(root.val);
    	if (pq.size() > k) {
    		pq.poll();
    	}
    	kthSmallest(root.left, k, pq);
    	kthSmallest(root.right, k, pq);
    }
}