import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Set<Integer> mySet1 = new HashSet<Integer>();
//		mySet1.add(2);
//		mySet1.add(4);
//		mySet1.add(7);
//		mySet1.add(8);
//		mySet1.add(9);
//		mySet1.add(4);
//		System.out.println("Before: " + mySet1);
//		removeOdds(mySet1);
//		System.out.println("Before: " + mySet1);
//		
//		System.out.println("");
//		
//		Set<Integer> mySet2 = new HashSet<Integer>();
//		mySet2.add(5);
//		mySet2.add(11);
//		mySet2.add(7);
//		mySet2.add(15);
//		mySet2.add(9);
//		System.out.println("Before: " + mySet2);
//		removeOdds(mySet2);
//		System.out.println("Before: " + mySet2);
		
//		Set<String> mySet1 = new HashSet<String>();
//		mySet1.add("Hermione");
//		mySet1.add("Harry");
//		mySet1.add("Ron");
//		mySet1.add("Alberforth");
//		mySet1.add("Wilhelminia");
//		mySet1.add("Draco");
//		System.out.println(longestLength(mySet1));
//		
//		System.out.println("");
//		
//		Set<String> mySet2 = new HashSet<String>();
//		mySet2.add("Gryffindor");
//		mySet2.add("Slytherin");
//		mySet2.add("Ravenclaw");
//		mySet2.add("Hufflepuff");
//		System.out.println(longestLength(mySet2));
		
//		String[] words = {"cat", "dog", "cat", "rat", "bird", "cat", "dog", "bird", "bird", "bird", "pig"};
//		List<String> wordList = Arrays.asList(words);
//		System.out.println(containsAtLeast3(wordList));
//		System.out.println(wordList);
//		
//		String[] words2 = {"cat", "dog", "rat", "bird", "cat", "dog", "bird", "pig"};
//		List<String> wordList2 = Arrays.asList(words2);
//		System.out.println(containsAtLeast3(wordList2));
//		System.out.println(wordList2);
		
		try {
		    Scanner fileIn = new Scanner(new File("student1.txt"));
		    System.out.println(createStudentToMajorMap(fileIn));
		} catch (FileNotFoundException e){
		    System.out.println("File not found");
		}
		
//		try {
//		    Scanner fileIn = new Scanner(new File("student2.txt"));
//		    System.out.println(createStudentToMajorMap(fileIn));
//		} catch (FileNotFoundException e){
//		    System.out.println("File not found");
//		}
//		
		
		
//		
		

//		for (int i = 100; i<1001; i = i + 50) {
//			System.out.println("Order: " + (i));
//			
//		}
		
//		int i = length("muuuubh");
//		
//		System.out.println(i);
		

		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		Set<String> myS = new TreeSet<String>();
		
		myS.add("CSC");
		
		
		map.put("hermione", myS);
		
		
		
		System.out.println(getStudentsWithMajor(map, "CSC"));
		
	
		
		
	}
	
	
	
	
	
	public static int length(String str) {
		  if (str == null || str.equals(""))
		     return 0;
		  else
		     return 1 + length(str.substring(1));
		}
	
	
	public static void removeOdds(Set<Integer> mySet) {
		Iterator<Integer> itr = mySet.iterator();
		
		while(itr.hasNext()) {
			if(itr.next() % 2 !=0) {
				itr.remove();
			}
		}
		
	
	}
	
	public static int longestLength(Set<String> mySet) {
		
		Iterator<String> itr = mySet.iterator();
		
		int max = Integer.MIN_VALUE;
		
		while(itr.hasNext()) {
			if(itr.next().length() > max) {
				max = itr.next().length();
			}
		}
		return max;
	}
	
	public static boolean containsAtLeast3(List<String> myList) {
		
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		Iterator<String> itr = myList.iterator();
		
		while(itr.hasNext()) {
			String word = itr.next();
			if(myMap.containsKey(word)) {
				int count = myMap.get(word);
				
				myMap.put(word, count + 1);
			} else {
				myMap.put(word, 1);
			}
			
			if(myMap.get(word) >= 3) {
				return true;
			}
			
		}
		
		return false;
		
	}
		
	public static Map<String, Set<String>> createStudentToMajorMap(Scanner file){
		Map<String, Set<String>> myMap = new HashMap<String, Set<String>>();
		
		while(file.hasNextLine()) {
			String current = file.nextLine();
			
			StringTokenizer tokenizer = new StringTokenizer(current, ";");
			
			String name = tokenizer.nextToken();
			String major = tokenizer.nextToken();
			
			if(!myMap.containsKey(name)) {
				Set<String> majorList = new TreeSet<String>();
				majorList.add(major);
				myMap.put(name, majorList);
			} else {
				Set<String> exist = myMap.get(name);
				exist.add(major);
				
				myMap.put(name, exist);
			}
			
			
		}
		return myMap;
		
	}

	public static Set<String> getStudentsWithMajor(Map<String, Set<String>> myMap, String major){
		Set<String> mySet = new TreeSet<String>();
		Set<String> key = myMap.keySet();
		
		Iterator<String> itr = key.iterator();
		
		while(itr.hasNext()) {
			String tempKey = itr.next();
			
			if(myMap.get(tempKey).contains(major)) {
				mySet.add(tempKey);
			}
		}
		return mySet;
		
	}
		
}
