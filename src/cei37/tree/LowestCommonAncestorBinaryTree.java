package cei37.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		LowestCommonAncestorBinaryTree t = new LowestCommonAncestorBinaryTree();
		
		TreeUtils.TreeNode root = new TreeUtils.TreeNode(3);
		root.left = new TreeUtils.TreeNode(5);
		root.left.left = new TreeUtils.TreeNode(6);
		root.left.right = new TreeUtils.TreeNode(2);
		root.left.right.left = new TreeUtils.TreeNode(7);
		root.left.right.right = new TreeUtils.TreeNode(4);
		root.right = new TreeUtils.TreeNode(1);
		root.right.left = new TreeUtils.TreeNode(0);
		root.right.right = new TreeUtils.TreeNode(8);
		
		root.prettyPrint();
		
		TreeUtils.TreeNode node = t.lowestCommonAncestor(root,root.left, root.left.right.right);
		if (node != null) {
			System.out.println(node);
		}
	}

    public TreeUtils.TreeNode lowestCommonAncestor(TreeUtils.TreeNode root, TreeUtils.TreeNode p, 
    		TreeUtils.TreeNode q) {

    	Map<TreeUtils.TreeNode, TreeUtils.TreeNode> parent = new HashMap<>();
    	Deque<TreeUtils.TreeNode> stack = new ArrayDeque<>();
        
    	stack.push(root);
    	parent.put(root, null);
    	
    	while(!parent.containsKey(p) || !parent.containsKey(q)) {
    		TreeUtils.TreeNode node = stack.pop();
    		if (node.left != null) {
    			stack.push(node.left);
    			parent.put(node.left, node);
    		}
    		if (node.right != null) {
    			stack.push(node.right);
    			parent.put(node.right, node);
    		}
    	}
    	
    	Set<TreeUtils.TreeNode> set = new HashSet<>();
    	while(p != null) {
    		set.add(p);
    		p = parent.get(p);
    	}
    	
    	while(parent.get(q) != null) {
    		if (set.contains(q)) {
    			break;
    		}
    		q = parent.get(q);
    	}
    	
    	return q;
    }
}
