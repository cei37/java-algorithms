package cei37.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		TreeUtils.TreeNode t1 = new TreeUtils.TreeNode(1);
		t1.left = new TreeUtils.TreeNode(3);
		t1.right = new TreeUtils.TreeNode(2);
		t1.left.left = new TreeUtils.TreeNode(5);
		
		t1.right.right = new TreeUtils.TreeNode(7);
		t1.right.right.right = new TreeUtils.TreeNode(12);
		t1.right.right.right.left = new TreeUtils.TreeNode(5);
		
		TreeUtils.TreeNode t2 = new TreeUtils.TreeNode(2);
		t2.left = new TreeUtils.TreeNode(1);
		t2.left.right = new TreeUtils.TreeNode(4);
		t2.right = new TreeUtils.TreeNode(3);
		t2.right.right = new TreeUtils.TreeNode(7);
		t2.right.right.right = new TreeUtils.TreeNode(12);
		t2.right.right.right.left = new TreeUtils.TreeNode(5);
		
		t1.prettyPrint();
		t2.prettyPrint();
		
		MergeTwoBinaryTrees me = new MergeTwoBinaryTrees();
		
		TreeUtils.TreeNode res = me.mergeTrees(t1, t2);
		
		res.prettyPrint();
	}
	
	public TreeUtils.TreeNode mergeTrees(TreeUtils.TreeNode t1, TreeUtils.TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		
		if (t1 == null && t2 != null) {
			t1 = new TreeUtils.TreeNode(0); 
		}
		
		if (t2 == null && t1 != null) {
			t2 = new TreeUtils.TreeNode(0);
		}
		
		t1.val += t2.val;
		
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		
		return t1;
	}

    public TreeUtils.TreeNode mergeTrees_BFS(TreeUtils.TreeNode t1, TreeUtils.TreeNode t2) {
    	if (t1 == null) return t2;
    	if (t2 == null) return t1;
    	
    	TreeUtils.TreeNode root = new TreeUtils.TreeNode(0);
    	
    	Queue<TreeUtils.TreeNode> q1 = new LinkedList<>();
    	Queue<TreeUtils.TreeNode> q2 = new LinkedList<>();
    	Queue<TreeUtils.TreeNode> qr = new LinkedList<>();
    	
    	q1.add(t1);
    	q2.add(t2);
    	qr.add(root);
    	
    	TreeUtils.TreeNode node1 = null;
		TreeUtils.TreeNode node2 = null;
		TreeUtils.TreeNode nodeR = null;
		
    	while(!q1.isEmpty() || !q2.isEmpty()) {
    		node1 = q1.poll();
			node2 = q2.poll();
			nodeR = qr.poll();
    		
			TreeUtils.TreeNode left = new TreeUtils.TreeNode(0);
    		TreeUtils.TreeNode right = new TreeUtils.TreeNode(0);
    		
    		if (node1 != null && node2 != null) {
    			nodeR.val = node1.val + node2.val;
    			
    			q1.offer(node1.left);
    			q1.offer(node1.right);
    			
    			q2.offer(node2.left);
    			q2.offer(node2.right);
        		
        		if (node1.left != null || node2.left != null) {
        			nodeR.left = left;
        			qr.offer(left);
        		} else {
        			qr.offer(null);
        		}
        		
        		if (node1.right != null || node2.right != null) {
        			nodeR.right = right;
        			qr.offer(right);
        		} else {
        			qr.offer(null);
        		}
    		} else if (node1 != null) {
    			nodeR.val = node1.val;
    			
    			q1.offer(node1.left);
    			q1.offer(node1.right);
    			
    			q2.offer(null);
    			q2.offer(null);
    			
        		
        		if (node1.left != null) {
        			nodeR.left = left;
        			qr.offer(left);
        		} else {
        			qr.offer(null);
        		}
        		
        		if (node1.right != null ) {
        			nodeR.right = right;
        			qr.offer(right);
        		} else {
        			qr.offer(null);
        		}
    		} else if (node2 != null) {
    			nodeR.val = node2.val;
    			
    			q1.offer(null);
    			q1.offer(null);
    			
    			q2.offer(node2.left);
    			q2.offer(node2.right);
    			
        		if (node2.left != null) {
        			nodeR.left = left;
        			qr.offer(left);
        		} else {
        			qr.offer(null);
        		}
        		
        		if (node2.right != null ) {
        			nodeR.right = right;
        			qr.offer(right);
        		} else {
        			qr.offer(null);
        		}
    		}
    	}

    	return root;
    }
}