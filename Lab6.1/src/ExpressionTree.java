import java.util.NoSuchElementException;

/**
 * Name: Anas and Izan 
 * Date: 26/10/2020 CSC 371 Lab 6--ExpressionTree.java
 * 
 * Constructs a binary expression tree from a postfix expression. The postfix
 * expression must have only the binary operations +, -, *, / and operands that
 * are single digits '0' - '9'. The prefix and infix expression can be created,
 * as well as the evaluation of the expression.
 */
public class ExpressionTree {

	public static final char SPACE = ' ';

	private TreeNode expressionRoot;

	public ExpressionTree() {
		expressionRoot = null;
	}

	/**
	 * An expression tree
	 * 
	 * @param expression
	 */
	public void constructTree(String expression) {
		if (expression.isEmpty() || expression.equals(null)) {
			throw new IllegalArgumentException("Invalid postfix string");
		}
		StackADT<TreeNode> stack = new ArrayStack<TreeNode>();
		char[] list = expression.toCharArray();
		for (int i = 0; i < list.length; i++) {
			if (isOperator(list[i])) {
				TreeNode rightChild;
				TreeNode leftChild;
				try {
					rightChild = stack.pop();
					leftChild = stack.pop();
				} catch (NoSuchElementException e) {
					throw new IllegalArgumentException("Invalid postfix string");
				}
				TreeNode operator = new TreeNode(list[i], leftChild, rightChild);
				stack.push(operator);
				if (i == list.length - 1) {
					expressionRoot = operator;
				}
			} else {
				TreeNode operand = new TreeNode(list[i]);
				stack.push(operand);
			}
		}
	}

	/**
	 * 
	 * @return - a String which is the fully parenthesized infix notation version of
	 *         the expression tree.
	 */
	public String getInfixExpression() {
		return expressionRoot.printInorder(expressionRoot);
	}

	/**
	 * 
	 * @return - a String which is the prefix notation version of the expression
	 *         tree.
	 */
	public String getPrefixExpression() {
		return expressionRoot.getPreorder(expressionRoot);
	}

	/**
	 * 
	 * @return - the value of the numeric expression
	 */
	public double evaluate() {
		return expressionRoot.evaluate(expressionRoot);
	}

	/**
	 * prints the tree sideways including indenting and connecters between nodes
	 */
	public void printTree() {
		if (expressionRoot == null) {
			return;
		}
		if (expressionRoot.right != null) {
			printTree(expressionRoot.right, true, "");
		}
		System.out.println(expressionRoot.data);
		if (expressionRoot.left != null) {
			printTree(expressionRoot.left, false, "");
		}
	}

	// use string and not stringbuffer on purpose as we need to change the indent at
	// each recursion
	private void printTree(TreeNode root, boolean isRight, String indent) {
		if (root.right != null) {
			printTree(root.right, true, indent + (isRight ? "        " : " |      "));
		}
		System.out.print(indent);
		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}
		System.out.print("----- ");
		System.out.println(root.data);
		if (root.left != null) {
			printTree(root.left, false, indent + (isRight ? " |      " : "        "));
		}
	}

	/**
	 * checks if char is a binary operator +, -, *, /
	 * 
	 * @param ch - the char to check if it is an operator
	 * @return true if the specified character is one of the four basic binary
	 *         arithmetic operations
	 */
	private boolean isOperator(char ch) {
		return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
	}

	/**
	 * TreeNode represents one node of an expression tree whose data is a character
	 * representing a binary operation or single digit data
	 */
	private static class TreeNode {
		// data fields
		private char data;
		private TreeNode left;
		private TreeNode right;

		// TODO Add two constructors
		public TreeNode(char data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public TreeNode(char data) {
			this.data = data;
			left = null;
			right = null;
		}

		/**
		 * 
		 * @param root
		 * @return
		 */
		private String printInorder(TreeNode root) {
			String temp = "";
			if (root != null) {
				temp += printInorder(root.left) + " " + root.data + " " + printInorder(root.right);
				if (root.data == '+' || root.data == '-' || root.data == '*' || root.data == '/') {
					temp = "(" + temp.trim() + ")";
				}
				return temp;

			}
			return temp;
		}

		/**
		 * 
		 * @param root - root
		 * @return
		 */
		private String getPreorder(TreeNode root) {
			if (root != null) {
				return root.data + " " + getPreorder(root.left) + getPreorder(root.right);

			}
			return "";
		}

		/**
		 * 
		 * @param expressionRoot - root
		 * @return the value of the numeric expression
		 */
		public double evaluate(TreeNode root) {
			if (root != null) {
				if (Character.isDigit(root.data)) {
					return (double) Character.getNumericValue(root.data);
				}
				if (root.data == '+') {
					return evaluate(root.left) + evaluate(root.right);
				}
				if (root.data == '*') {
					return evaluate(root.left) * evaluate(root.right);
				}
				if (root.data == '-') {
					return evaluate(root.left) - evaluate(root.right);
				}
				if (root.data == '/') {
					return evaluate(root.left) / evaluate(root.right);
				}
			}
			return 0;
		}
	}
}
