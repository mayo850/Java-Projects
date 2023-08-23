// This program tests the IntSearchTree class by constructing a
// binary search tree of integers and printing its contents as
// well as its structure.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IntSearchTreeClient {
    public static void main(String[] args) {
//        Scanner console = new Scanner(System.in);
//        IntSearchTree numbers = new IntSearchTree();
//        System.out.print("Next int (0 to quit)? ");
//        int number = console.nextInt();
//        while (number != 0) {
//            numbers.add(number);
//            System.out.print("Next int (0 to quit)? ");
//            number = console.nextInt();
//        }
//        System.out.println();
//
//        System.out.println("Tree Structure:");
//        numbers.printTree();
//        
//        console.close();
//    	Integer[] treeData = {5, 7, null, 6, null, 0, null };
//        IntTree tree1 = new IntTree();
//        tree1.createTree(treeData);
//    	
//        System.out.println("Before: ");
//        tree1.printTree();
//        tree1.remove1(7);
//        System.out.println("After: ");
//        tree1.printTree();
    	
//    	System.out.println("Tree: ");
//    	tree1.printTree();
//    	System.out.println(tree1.createListOfLevels());
        
//        System.out.println("Tree: ");
//        tree1.printTree();
//        System.out.println("Method output");
//        tree1.writeTree();
        
//        try{
//            Scanner input = new Scanner(new File("tree1.txt"));
//            IntTree tree1 = new IntTree();
//            tree1.readTree(input);
//            tree1.printTree();
//            tree1.getMin();
//        } catch (FileNotFoundException e){
//            System.out.println("File not found");
//        }
    	 //Integer[] treeData = {4, 2, 8, 1, 7, 6, 10};
         IntSearchTree tree1 = new IntSearchTree();
         tree1.add(6);
         tree1.add(4);
         tree1.add(7);
         tree1.add(3);
         tree1.add(5);
         tree1.add(9);
         tree1.add(2);
         
         tree1.printTree();
         tree1.remove1(2);
         tree1.printTree();
         
         
      
         
    	
    }
    
    
}
