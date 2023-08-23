
// Creates a tree of integer and prints its elements in different orders.

public class IntTreeClient {
    public static void main(String[] args) {
 //       IntTree tree = new IntTree(4);
        
        //Integer[] treeData = {4, 2, -1, 7, null, 9, 5};
    	 Integer[] treeData = {4, 2, 8, 1, 7, 6, 10,11};
        IntTree tree1 = new IntTree();
        tree1.createTree(treeData);
        
        tree1.printTree();
       tree1.removeOneChildNodes(); 
       tree1.printTree();
        
        
//        System.out.print("\nPreorder: ");
//        tree.printPreorder();
//        System.out.println();
//
//        System.out.print("\nInorder: ");
//        tree.printInorder();
//        System.out.println();
//
//        System.out.print("\nPostorder: ");
//        tree.printPostorder();
//        System.out.println();
//        
//        System.out.println("\nSum: " + tree.sumOddNodes());
        
//        System.out.println("\nLeaf count: " + tree.countLeaves());
        
//		System.out.println("42: " + tree.contains(42));
//		System.out.println("3: " + tree.contains(3));
//		System.out.println("12: " + tree.contains(12));
//		System.out.println("2: " + tree.contains(2));
		
//      System.out.println("\nLeft node count: " + tree.countLeftNodes());
        
//        System.out.println("Tree: ");
//        tree1.printTree();
//        System.out.println("Sum: " + tree1.sumOddBranches());
//        
//        System.out.println("Tree: ");
//        tree1.printTree();
//        System.out.println("isFull? " + tree1.isFull());
        
//        System.out.println("Tree: ");
//        tree1.printTree();
//        System.out.println("Sum: " + tree1.weightedSum());
        
//        System.out.println("Tree: ");
//        tree1.printTree();
//        System.out.println(tree1.countLeftNodes1());
        //tree1.countNodes();
    }
}