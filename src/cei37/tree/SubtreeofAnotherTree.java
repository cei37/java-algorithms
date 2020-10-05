package cei37.tree;

public class SubtreeofAnotherTree {

	public static void main(String[] args) {
		TreeNode s = new TreeNode();
        /* 
		     3
		    / \
		   4   5
		  / \
		 1   2
		*/
		s.insert(3);
		s.insert(4);
		s.insert(5);
		s.insert(1);
		s.insert(2);
		
		TreeNode t = new TreeNode();
        /* 
		     3
		    / \
		   4   5
		  / \
		 1   2
		*/
		t.insert(4);
		t.insert(2);
		t.insert(1);

		t.printTreePaths();
		
		
	}

    public boolean isSubtree(TreeNode s, TreeNode t) {
    	StringBuffer sbS = new StringBuffer();
    	StringBuffer sbT = new StringBuffer();
    	
    	preOrder(s, sbS);
    	preOrder(t, sbT);

    	return sbS.toString().contains(sbT.toString());
    }
    
    public void preOrder(TreeNode node, StringBuffer sb) {
    	//sb.append("#").append(node.)
    }
}
