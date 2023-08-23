import java.util.LinkedList;
import java.util.Queue;

class IntTree {
	// Using add method will create a BST. Using the createTree method passing in
	// an Integer array can make any binary tree.
	private class IntTreeNode {
		private int data;
		private IntTreeNode left;
		private IntTreeNode right;

		// constructs a leaf node with given data
		private IntTreeNode(int data) {
			this(data, null, null);
		}

		// constructs a branch node with given data, left subtree,
		// right subtree
		private IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private  IntTreeNode overallRoot;

	/**
	 * constructs an empty search tree
	 */
	public IntTree() {
		overallRoot = null;
	}

	/**
	 * adds a node with the desired value to the search tree preserving it as a
	 * search tree
	 * 
	 * @param value - the value to be added in a new node in the search tree
	 */
	public void add(int value) {
		overallRoot = add(overallRoot, value);
	}

	private IntTreeNode add(IntTreeNode root, int value) {
		if (root == null) {
			root = new IntTreeNode(value);
		} else if (value <= root.data) {
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
		}
		return root;
	}

	/**
	 * Create a binary tree from an array where left child is at index 2 * n and
	 * right child is at index 2 * n + 1. If no child, use null as the array
	 * element.
	 */
	public void createTree(Integer[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException();
		}

		Queue<IntTreeNode> treeNodeQueue = new LinkedList<>();
		Queue<Integer> integerQueue = new LinkedList<>();
		for (int i = 1; i < array.length; i++) {
			integerQueue.offer(array[i]);
		}

		IntTreeNode treeNode = new IntTreeNode(array[0]);
		treeNodeQueue.offer(treeNode);

		int count = 0;
		while (!integerQueue.isEmpty()) {
			Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
			Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
			count = count + 2;
			if (leftVal != null || rightVal != null) {
				IntTreeNode current = treeNodeQueue.poll();

				if (leftVal != null) {
					IntTreeNode left = new IntTreeNode(leftVal);
					current.left = left;
					treeNodeQueue.offer(left);
				}
				if (rightVal != null) {
					IntTreeNode right = new IntTreeNode(rightVal);
					current.right = right;
					treeNodeQueue.offer(right);
				}
			} else {
				if (!integerQueue.isEmpty()) {
					int parent = (count - 1) / 2;
					if (array[parent] != null) {
						treeNodeQueue.poll();
					}
				}
			}
		}
		overallRoot = treeNode;
	}

	/**
	 * prints the tree contents, one per line, following an inorder traversal and
	 * using indentation to indicate node depth; prints right to left so that it
	 * looks correct when the output is rotated.
	 */
	public void printSideways() {
		printSideways(overallRoot, "");
	}

	private void printSideways(IntTreeNode root, String indent) {
		if (root != null) {
			printSideways(root.right, indent + "    ");
			System.out.println(indent + root.data);
			printSideways(root.left, indent + "    ");
		}
	}

	/*
	 * prints the tree sideways including indenting and connecters between nodes
	 */
	public void printTree() {
		if (overallRoot == null) {
			return;
		}
		if (overallRoot.right != null) {
			printTree(overallRoot.right, true, "");
		}
		System.out.println(overallRoot.data);
		if (overallRoot.left != null) {
			printTree(overallRoot.left, false, "");
		}
	}

	// use string and not stringbuffer on purpose as we need to change the indent at
	// each recursion
	private void printTree(IntTreeNode root, boolean isRight, String indent) {
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

	public int countRightLeaves() {
		return countRigthLeavesHelper(overallRoot, false);

	}

	private int countRigthLeavesHelper(IntTreeNode root, boolean right) {
		if (root == null) {
			return 0;
		}
		if (root.right == null && root.left == null && right == true) {

			return 1;

		}

		else {
			return countRigthLeavesHelper(root.right, true) + countRigthLeavesHelper(root.left, false);
		}
	}
	
	public int sumOddBranches() {
		return sumOddBranches(overallRoot);
	}
	
	private int sumOddBranches(IntTree root) {
		
		return 1;
		
	}
	
	
	
	

}

public class IntTreeClient {

	public static void main(String[] args) {
		IntTreeClient main = new IntTreeClient();
		main.runTests();
	}

	public void runTests() {
		IntTree tree1 = new IntTree();
		Integer[] array = { 1, 12, 5, 9, 4, 2, 0, -3, 10, 14, 8, 20, 3, 7, 11 };
		tree1.createTree(array);
		;
		System.out.println("Tree: ");
		tree1.printTree();
		System.out.println("Sum: " + tree1.sumOddBranches());
		;
	}
}