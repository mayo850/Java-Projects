/**
 * This program is test code for the implementation of the NameRecord class.
 * To thoroughly test the program, change the ranking numbers.
 * 
 *
 */
public class NameRecordTest {
	public static void main(String[] args){
		String name = "Theresa";
		int[] rankings = {94, 96, 76, 74, 90, 41, 43, 82, 135, 256, 420};
		NameRecord record = new NameRecord(name, rankings);
		System.out.println("The stored name is " + record.getName());
		int decade = 1970;
		System.out.println("In " + decade + ", the rank was " + record.getDecadeRank(decade));
		System.out.println("The best decade for this name was " + record.getBestDecade());
		System.out.println("This name was ranked in " + record.getNumberOfRankedDecades() + " decades.");
		if (record.isRankedEachDecade()){
			System.out.println("This name was ranked every decade");
		} else {
			System.out.println("This name was not ranked every decade");
		}
		if (record.isGettingMorePopular()){
			System.out.println("This name was always getting more popular");
		} else {
			System.out.println("This name was not always getting more popular");
		}
		if (record.isGettingLessPopular()){
			System.out.println("This name was always getting less popular");
		} else {
			System.out.println("This name was not always getting less popular");
		}
		System.out.println();
		System.out.println(record.recordInfoByDecade());
		System.out.println(record);
		
	}
}
