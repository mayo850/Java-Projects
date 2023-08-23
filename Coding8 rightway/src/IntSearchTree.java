import java.util.NoSuchElementException;

// This class stores int values in a binary search tree.
// Duplicates are allowed.  Each node of the tree has the binary
// search tree property.

public class IntSearchTree {
    private IntTreeNode overallRoot;

    // post: constructs an empty tree
    public IntSearchTree() {
        overallRoot = null;
    }

    // post: value is added to overall tree so as to preserve the
    //       binary search tree property
    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value is added to given tree so as to preserve the
    //       binary search tree property
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

    // post: returns true if overall tree contains value
    public boolean contains(int value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value
    private boolean contains(IntTreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return contains(root.left, value);
        } else {  // value > root.data
            return contains(root.right, value);
        }
    }


	/*
    prints the tree sideways including indenting and connecters between nodes
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

    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(IntTreeNode root, boolean isRight, String indent){
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
    
   

    
    
    public int sumRange(int high, int low) {
    	return sumRange(overallRoot, high, low);
    }
    
    private int sumRange(IntTreeNode root, int high, int low) {
    	if(root == null) {
    		return 0;
    	}
    	
    	int sum = 0;
    	
    	if(root.data <= high && root.data >= low) {
    		sum += root.data;
    	}
    	if(root.data < high) {
    		 sumRange(root.right, high, low);
    	}
    	if(root.data > low) {
    		 sumRange(root.left, high, low);
    	}
    	
    	return sum;
    }
    
    public int getMin() {
		if(overallRoot ==null) {
			throw new NoSuchElementException();
		}
		
		return getMin(overallRoot);
		
	}
	
	private int getMin(IntTreeNode root) {
		if(root.left == null) {
			return root.data;
		} else {
			
			return getMin(root.left);
		}
		
		
	}
    
    public void remove1(int value) {
   	 overallRoot = remove1(overallRoot, value);
   }
   
   private IntTreeNode remove1(IntTreeNode root, int value ) {
   	if(root == null) {
   		return null;
   	
   	}
   	else if(value < root.data) {
   		root.left = remove1(root.left, value);
   	}
   	else if(value > root.data) {
   		root.right =remove1(root.right, value);
   	}
   	else {
   		if(root.right == null) {
   			return root.left;
   		} else if(root.left == null) {
   			return root.right;
   		} else {
   			root.data = getMin(root.right);
   			root.right = remove1(root.right, root.data);
   		}
   	}
   	return root;
   }
    
    
	
	
	// Class for storing a single node of a binary tree of ints

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
	   private IntTreeNode(int data, IntTreeNode left, 
	                       IntTreeNode right) {
	        this.data = data;
	        this.left = left;
	        this.right = right;
	    }
	}
}