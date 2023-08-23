import java.util.*;

// An IntTree object represents an entire binary tree of ints.

public class IntTree {
	private IntTreeNode overallRoot;
	private Random rand = new Random();
	private int result;

	// Constructs an empty binary tree.
	public IntTree() {
		overallRoot = null;
	}

	// Constructs a binary tree with the given node as its root.
	// Note: this is hacky and just useful for testing
	public IntTree(IntTreeNode root) {
		overallRoot = root;
	}

	// pre : max > 0
	// post: constructs a binary tree with given number of
	// nodes and random data values
	public IntTree(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("max: " + max);
		}
		overallRoot = buildTree(1, max);
	}

	// post: returns a binary tree with max nodes with random data value
	private IntTreeNode buildTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			return new IntTreeNode(rand.nextInt(100), buildTree(2 * n, max), buildTree(2 * n + 1, max));
		}
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
			integerQueue.add(array[i]);
		}

		IntTreeNode treeNode = new IntTreeNode(array[0]);
		treeNodeQueue.add(treeNode);

		int count = 0;
		while (!integerQueue.isEmpty()) {
			Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.remove();
			Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.remove();
			count = count + 2;
			if (leftVal != null || rightVal != null) {
				IntTreeNode current = treeNodeQueue.remove();

				if (leftVal != null) {
					IntTreeNode left = new IntTreeNode(leftVal);
					current.left = left;
					treeNodeQueue.add(left);
				}
				if (rightVal != null) {
					IntTreeNode right = new IntTreeNode(rightVal);
					current.right = right;
					treeNodeQueue.add(right);
				}
			} else {
				if (!integerQueue.isEmpty()) {
					int parent = (count - 1) / 2;
					if (array[parent] != null) {
						treeNodeQueue.remove();
					}
				}
			}
		}
		overallRoot = treeNode;
	}

	// Prints an in-order traversal of this tree.
	public void printInorder() {
		printInorder(overallRoot);
	}

	// Prints an in-order traversal of the tree starting at the specified root
	private void printInorder(IntTreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	// Prints a pre-order traversal of this tree.
	public void printPreorder() {
		printPreorder(overallRoot);
	}

	// Prints a pre-order traversal of the tree starting at the specified root
	private void printPreorder(IntTreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}

	// Prints a post-order traversal of this tree.
	public void printPostorder() {
		printPostorder(overallRoot);
	}

	// Prints a post-order traversal of the tree starting at the specified root
	private void printPostorder(IntTreeNode root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	// returns sum of the tree's data values
	public int sum() {
		return sum(overallRoot);
	}

	private int sum(IntTreeNode root) {
		if (root == null) {
			return 0;
		} else {
//			int currentSum = sum(root.left);
//			currentSum += sum(root.right);
//			currentSum += root.data;
//			return currentSum;
			return sum(root.left) + sum(root.right) + root.data;
		}
	}

	// returns count of the number of leaves
	public int countLeaves() {
		return countLeaves(overallRoot);
	}

	private int countLeaves(IntTreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			return countLeaves(root.left) + countLeaves(root.right);
		}

	}

	// returns sum of the tree's data values
	public int sumOddNodes() {
		return sumOddNodes(overallRoot);
	}

	private int sumOddNodes(IntTreeNode root) {
		if (root == null) {
			return 0;
		} else { // node has data value
			int num = 0;
			if (root.data % 2 == 1) {
				num = root.data;
			}
			return num + sumOddNodes(root.left) + sumOddNodes(root.right);

		}

	}

	// Returns whether this tree contains the given integer.
//	public boolean contains(int value) {
//		return contains(overallRoot, value);
//	}
//
//	private boolean contains(IntTreeNode root, int value) {
//		return false;
//	}

	// Returns the count of this tree's left nodes
	// A left node is a node that is a left child of another node
	public int countLeftNodes() {
		return countLeftNodes(overallRoot);
	}

	private int countLeftNodes(IntTreeNode root) {
		return 0;
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
		return countRightLeaves(overallRoot, false);

	}

	private int countRightLeaves(IntTreeNode root, boolean right) {
		if(root == null) {
			return 0; 
		}
		if(root.right == null && root.left == null && right == true) {
			return 1 ;
		}
		
		return countRightLeaves(root.left, false) + countRightLeaves(root.right, true);
	}

	public int sumOddBranches() {
		return sumOddBranches(overallRoot, 0);
	}

	private int sumOddBranches(IntTreeNode root, int total) {

		if (root == null) {
			return 0;
		}

		if ((root.right != null || root.left != null) && root.data % 2 != 0) {

			return sumOddBranches(root.right, total) + sumOddBranches(root.left, total) + root.data;

		} else {
			return sumOddBranches(root.right, total) + sumOddBranches(root.left, total);
		}

	}

	public boolean isFull() {
		return isFull(overallRoot);
	}

	private boolean isFull(IntTreeNode root) {

		if (root.right == null && root.left == null) {
			return true;
		}

		if (root.right != null && root.left != null) {
			return isFull(root.right) && isFull(root.left);
		}

		else {
			return false;
		}

	}

	public int weightedSum() {
		return weightedSum(overallRoot, 1);
	}

	private int weightedSum(IntTreeNode root, int level) {
		if (root == null) {
			return 0;
		}

		else {
			int currentSum = 0;

			currentSum = weightedSum(root.left, level + 1) + weightedSum(root.right, level + 1) + root.data * level;

			return currentSum;
		}
	}

	public void printDescending() {
		printDescending(overallRoot);
	}

	private void printDescending(IntTreeNode root) {
		if (root == null) {
			return;
		} else {
			printDescending(root.right);
			System.out.print(root.data + " ");
			printDescending(root.left);
		}
	}

	// IntTreeNode objects stores a single node of a binary tree of ints.

	private class IntTreeNode {
		private int data; // data stored at this node
		private IntTreeNode left; // reference to left subtree
		private IntTreeNode right; // reference to right subtree

		// Constructs a leaf node with the given data.
		private IntTreeNode(int data) {
			this(data, null, null);
		}

		// Constructs a leaf or branch node with the given data and links.
		private IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	public int sumRange(int low, int high) {
		if (low > high) {
			throw new IllegalArgumentException();
		}
		return sumRange(overallRoot, low, high);
	}

	private int sumRange(IntTreeNode root, int low, int high) {
		int sum = 0;
		
		if(root == null) {
			return 0;
		} else if(root.data >= low && root.data <=high) {
			return sum += root.data + sumRange(root.left, low, high) + sumRange(root.right, low, high);
			
		}
		else {
			return sumRange(root.left, low, high) + sumRange(root.right, low, high);
			
		}

	}

	public void removeOneChildNodes() {
		overallRoot = removeOneChildNodes(overallRoot);
	}

	private IntTreeNode removeOneChildNodes(IntTreeNode root) {
		if(root == null) {
			return null;
		} else {
			root.left = removeOneChildNodes(root.left);
			root.right = removeOneChildNodes(root.right);
			
			if(root.left == null && root.right != null) {
				IntTreeNode temp = root.right;
				return temp;
			} 
			if(root.left != null && root.right == null) {
				IntTreeNode temp = root.left;
				return temp;
			}
			
			return root;
		}
	}
	public List<List<Integer>> createListOfLevels() {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		resultList = createListOfLevels(overallRoot);

		return resultList;
	}

	private List<List<Integer>> createListOfLevels(IntTreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>();
		if (root == null) {
			return resultList;
		} else {
			Queue<IntTreeNode> myQueue = new LinkedList<>();
			myQueue.add(root);
			while (!myQueue.isEmpty()) {
				//int size = myQueue.size();
				List<Integer> tempList = new ArrayList<>();
				
					IntTreeNode current = myQueue.remove();
					tempList.add(current.data);

					if (current.left != null) {
						myQueue.add(current.left);
					}
					if (current.right != null) {
						myQueue.add(current.right);
					}
				
				resultList.add(new ArrayList<>(tempList));
			}
			return resultList;
		}
	}

	public void writeTree() {
		writeTree(overallRoot);

	}

	private void writeTree(IntTreeNode root) {
		if (root == null) {
			System.out.print("");

		} else {

			if (root.left == null && root.right == null) {
				System.out.println("0 " + root.data);
				writeTree(root.left);
				writeTree(root.right);
			}

			if (root.left != null && root.right == null) {
				System.out.println("1 " + root.data);
				writeTree(root.left);
				writeTree(root.right);
			}

			if (root.left == null && root.right != null) {
				System.out.println("2 " + root.data);
				writeTree(root.left);
				writeTree(root.right);
			}

			if (root.left != null && root.right != null) {
				System.out.println("3 " + root.data);
				writeTree(root.left);
				writeTree(root.right);
			}

		}

	}
	
	public void readTree(Scanner input) {
	    overallRoot = readTreeHelper(input);
	}

	private IntTreeNode readTreeHelper(Scanner input) {
	    // Read input
	    int type = input.nextInt();
	    int data = input.nextInt();

	    // Reconstruct node
	    IntTreeNode newNode = new IntTreeNode(data);
	    if (type == 1 || type == 3) {
	        newNode.left = readTreeHelper(input);
	    }
	    if (type == 2 || type == 3) {
	        newNode.right = readTreeHelper(input);
	    }
	    return newNode;
	}
	
	public int sumN() {
		return sumN(overallRoot);
	}

	private int sumN(IntTreeNode root) {
		int sum = 0;
		if(root == null) {
			return 0;
		}
		else {
			
			sum += root.data;
			
		}
		return sum;
	}
	
	public int sumNumbers() {
		
		result = 0;
		
		sumNumbers(overallRoot, 0);
		return result;
	}
	
	private void sumNumbers(IntTreeNode root, int current) {
		if(root == null) {
			 return;
		}
		
			int total = current*10 + root.data;
			
			if(root.left == null && root.right == null) {
				result += total;
				return;
			
			}
			
		
				sumNumbers(root.left, total);
			
			
				sumNumbers(root.right, total);
			
	
		}
	
	public int countNodes(int val) {
		return countNodes(overallRoot);
	}
	
	private int countNodes(IntTreeNode root) {
		if(root == null) {
			return 0;
		}
		else if(root.left != null && root.right !=null) {
			return 1;
		} else {
		return countNodes(root.left) + countNodes(root.right);
		
	}
	}
		
		
	public boolean containsN(int val) {
		return containsN(overallRoot, val);
	}
	
	private boolean containsN(IntTreeNode root, int val) {
		if(root == null) {
			return false;
		}
		else if(root.data == val) {
			return true;
		}
		
		      return containsN(root.left, val) ||
			   containsN(root.right, val);
		
	}
	
	
	public int countLeftNodes1() {
		return countLeftNodes1(overallRoot);
	}
	
	private int countLeftNodes1(IntTreeNode root) {
	if(root == null) {
		return 0;
	}
	
	else if(root.left != null) {
		return 1 + countLeftNodes1(root.left) + countLeftNodes1(root.right);
	}
	
	else {
		return countLeftNodes1(root.right);
	}
		
	}
	
	public void removeLeaf() {
		
		removeLeaf(overallRoot);
	}
	
	private IntTreeNode removeLeaf(IntTreeNode root) {
		if(root == null) {
			return null;
		}
		
	   root.left = removeLeaf(root.left);
	   root.right = removeLeaf(root.right);
	   
	    if(root.left != null && root.right == null) {
	    	
	    	root = root.left;
	    }
	    
	    else if(root.left == null && root.right != null) {
	    	root = root.right;
	    }
		
	    return root;
	}
	
	
	
//	public int getMin() {
//		if(overallRoot ==null) {
//			throw new NoSuchElementException();
//		}
//		
//		return getMin(overallRoot);
//		
//	}
//	
//	private int getMin(IntTreeNode root) {
//		if(root.left == null) {
//			return root.data;
//		} else {
//			
//			return getMin(root.left);
//		}
//		
//		
//	}
	
//	 public void remove1(int value) {
//    	 overallRoot = remove1(overallRoot, value);
//    }
//    
//    private IntTreeNode remove1(IntTreeNode root, int value ) {
//    	if(root == null) {
//    		return null;
//    	
//    	}
//    	else if(value < root.data) {
//    		root.left = remove1(root.left, value);
//    	}
//    	else if(value > root.data) {
//    		root.right =remove1(root.right, value);
//    	}
//    	else {
//    		if(root.right == null) {
//    			return root.left;
//    		} else if(root.left == null) {
//    			return root.right;
//    		} else {
//    			root.data = getMin(root.right);
//    			root.right = remove1(root.right, root.data);
//    		}
//    	}
//    	return root;
//    }
	
	
	}

	

