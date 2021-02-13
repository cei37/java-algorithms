package cei37.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeOriginal {

	class Node {
		int key;
		Node left, right, next;

		public Node(int item) {
			key = item;
			left = right = null;
		}
		public String toString() {
			return String.valueOf(key);
		}
	}

	// Root of BST
	Node root;

	// Constructor
	public  TreeNodeOriginal() {
		root = null;
	}

	// This method mainly calls insertRec()
	public void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	private Node insertRec(Node root, int key) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec()
	public  void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
	
	public void bfs() {
		if (root != null) {
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty()) {
				Node node = q.remove();
				System.out.println(node.key);
				
				if (node.left!=null)
					q.add(node.left);
				
				if (node.right!=null)
					q.add(node.right);
			}
		}
	}
	
    public Node connect() {
        
        if (root == null) {
            return root;
        }
        
        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> Q = new LinkedList<Node>(); 
        Q.add(root);
        
        // Outer while loop which iterates over 
        // each level
        while (Q.size() > 0) {
            
            // Note the size of the queue
            int size = Q.size();
            
            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {
                
                // Pop a node from the front of the queue
                Node node = Q.poll();
                
                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only 
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) {
                    node.next = Q.peek();
                }
                
                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        
        // Since the tree has now been modified, return the root node
        return root;
    }
    
    public List<String> binaryTreePaths() {
        List<String> paths = new ArrayList<String>();
        if (root == null) return paths;
        buildPaths(root, paths, "");
        return paths;
    }
    
    private void buildPaths(Node node, List<String> list, String path) {
        if (node.right == null && node.left == null) {
            path += node.key;
            list.add(path);
            return;
        }
        
        path+= String.valueOf(node.key) + "->";
        if (node.left !=null)
            buildPaths(node.left, list, path);
        if (node.right !=null)
            buildPaths(node.right, list, path);
    }

    public void printTreePaths() {
		List<String> list = this.binaryTreePaths();
		for (String s : list) {
			System.out.println(s);
		}
    }
	// Driver Program to test above functions
	public static void main(String[] args) {
		TreeNodeOriginal tree = new TreeNodeOriginal();

        /* Let us create following BST 
		        50 
		     /     \ 
		    30      70 
		   /  \    /  \ 
		 20   40  60   80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		

		// print inorder traversal of the BST
		//tree.connect();
		List<String> list = tree.binaryTreePaths();
		for (String s : list) {
			System.out.println(s);
		}
	}

}
