package cei37.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 1361. Validate Binary Tree Nodes
Medium

304

108

Add to List

Share
You have n binary tree nodes numbered from 0 to n - 1 where node i has two children 
leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.

 

Example 1:



Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true
Example 2:



Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
Output: false
Example 3:



Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
Output: false
Example 4:



Input: n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
Output: false
 

Constraints:

1 <= n <= 10^4
leftChild.length == rightChild.length == n
-1 <= leftChild[i], rightChild[i] <= n - 1

 */
public class ValidateBinaryTreeNodes {

	public static void main(String[] args) {
		ValidateBinaryTreeNodes va = new ValidateBinaryTreeNodes();
		List<Data> list = new ArrayList<Data>();
		
		list.add(new Data(4, 
				new int[] {1, -1, 3, -1}, 
				new int[] {2, -1, -1, -1}
		));

		list.add(new Data(4, 
				new int[] {1,-1,3,-1}, 
				new int[] {2,3,-1,-1}
		));
		
		list.add(new Data(2, 
				new int[] {1,0}, 
				new int[] {-1,-1}
		));

		list.add(new Data(6, 
				new int[] {1,-1,-1,4,-1,-1}, 
				new int[] {2,-1,-1,5,-1,-1}
		));
		
		list.add(new Data(4, 
				new int[] {3,-1,1,-1}, 
				new int[] {-1,-1,0,-1}
		));
		
		for (Data d : list) {
			System.out.println(va.validateBinaryTreeNodes(d.n, d.leftChild, d.rightChild));
		}
	}
	
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    	Set<Integer> visited = new HashSet<>();

    	int root = getRoot(n, leftChild, rightChild);
    	
    	return validateBinaryTreeNodes(root, leftChild, rightChild, visited) && visited.size() == n;
    }

    private boolean validateBinaryTreeNodes(int parent, int[] leftChild, int[] rightChild, Set<Integer> visited) {
    	if (parent == -1) {
    		return true;
    	}
    	if (visited.contains(parent)) {
    		return false;
    	}
    	visited.add(parent);
    	
    	return validateBinaryTreeNodes(leftChild[parent], leftChild, rightChild, visited) &&
    			validateBinaryTreeNodes(rightChild[parent], leftChild, rightChild, visited);
    }

    //after looking why? my approach was super slow I understood this,
    //the root node could be anything
    //THIS METHOD IS A COPY FROM ANOTHER EXAMPLE
    // We find a node that has children but no parents and use it
    // as a root
    private int getRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> roots = new HashSet<>();
        // 0 to n-1, anyone can be root
        for (int node=0; node<n; node++) {
            roots.add(node);
        }
        // if a node is a left or a right child then it cannot be root
        for (int node=0; node<n; node++) {
            roots.remove(leftChild[node]);
            roots.remove(rightChild[node]);
        }
        // there can be only one root
        return (roots.size() == 1) ? roots.iterator().next() : -1;
    }
}


class Data {
	int n;
	int[] leftChild;
	int[] rightChild;
	public Data(int n, int[] leftChild, int[] rightChild) {
		this.n = n;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}