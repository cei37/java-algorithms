package cei37.tree;

public class ExpressionTree {

	public static void main(String[] args) {
		ExpressionTree exp = new ExpressionTree();
		/*Node root = new Node('*');
		root.left = new Node('+');
		root.right = new Node('-');
		root.left.left = new Node(6);
		root.left.right = new Node(2);
		root.right.left = new Node(4);
		root.right.right = new Node(2);*/
		
		Node root = new Node('+');
		root.left = new Node(3);
		root.right = new Node('*');
		root.right.left = new Node('+');
		root.right.left.left = new Node(5);
		root.right.left.right = new Node(9);
		root.right.right = new Node(2);
		
		System.out.println(exp.evaluate(root));
	}


	public int evaluate(Node node) {
		if (node == null)
			return 0;

		if (node.isOperator()) {
			if (node.oper == '*') {
				return evaluate(node.left) * evaluate(node.right);
			} else if (node.oper == '/') {
				return evaluate(node.left) / evaluate(node.right);
			} else if (node.oper == '+') {
				return evaluate(node.left) + evaluate(node.right);
			} else {
				return evaluate(node.left) - evaluate(node.right);
			}
		} else {
			return node.value;
		}
	}

	static class Node {
		Node left;
		Node right;
		int value;
		char oper;
		boolean operator;
		
		public Node(char oper) {
			this.oper = oper;
			operator = true;
		}
		
		public Node(int value) {
			this.value = value;
		}

		public boolean isOperator() {
			return operator;
		}
	}
}
