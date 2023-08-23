
/**
 * @author Izan Khan
 * @assign CSC212-Program8
 * @version (April 4, 2019)
 * 
 * Description: NameRecord is a data type to store baby names and their
 * popularity rankings by decade according to the Social Security Administration
 * of the United States. 
 * 
 * Citations of Assistance (who and what): Professor Mueller (Corrections) 
 */

import java.util.*;

public class NameRecord {
	// constant
	public static final int NOT_RANKED = 1001;

	// data fields
	private String name;
	private int rank[] = new int[BabyNameProcessor.NUM_DECADES];

	// constructor
	public NameRecord(String name, int[] rankingData) {
		this.name = name;
		for (int i = 0; i < rankingData.length; i++) {
			if (rankingData[i] == 0) {
				this.rank[i] = NOT_RANKED;
			} else {
				this.rank[i] = rankingData[i];
			}
		}
	}

	// other instance methods

	public String getName() {
		return this.name;
	}

	public int getDecadeRank(int decade) {
		if (decade < (BabyNameProcessor.MIN_DECADE) || (decade > BabyNameProcessor.MAX_DECADE) || (decade % 10 != 0)) {
			throw new IllegalArgumentException();
		}

		int index = (decade - BabyNameProcessor.MIN_DECADE) / 10;
		return rank[index];
	}

	public int getBestDecade() {

		int high = Integer.MAX_VALUE;
		int value = 0;
		for (int i = 0; i < rank.length; i++) {
			if (high >= rank[i]) {
				high = rank[i];
				value = i * 10 + BabyNameProcessor.MIN_DECADE;
			}

		}
		return value;
	}

	public int getNumberOfRankedDecades() {
		int count = 0;
		for (int i = 0; i < rank.length; i++) {
			if (rank[i] != NOT_RANKED) {
				count++;
			}
		}
		return count;
	}

	public boolean isRankedEachDecade() {
		boolean flag = true;
		for (int i = 0; i < rank.length; i++) {
			if (rank[i] == NOT_RANKED) {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isGettingMorePopular() {
		boolean flag = true;
		for (int i = 0; i < rank.length - 1; i++) {
			if (this.rank[i + 1] >= rank[i]) {
				flag = false;
			}
		}
		return flag;
	}

	public boolean isGettingLessPopular() {
		boolean flag = true;
		for (int i = 0; i < rank.length - 1; i++) {
			if (this.rank[i + 1] <= rank[i]) {
				flag = false;
			}
		}
		return flag;
	}

	public String recordInfoByDecade() {

		String data = "Name: " + this.name + "\n";

		for (int i = 0; i < rank.length; i++) {
			if (rank[i] == NOT_RANKED) {
				data = data + (i * 10 + BabyNameProcessor.MIN_DECADE) + ": " + "not ranked in top 100\n";

			} else {
				data = data + (i * 10 + BabyNameProcessor.MIN_DECADE) + ": " + rank[i] + "\n";
			}
		}
		return data;

	}

	public String toString() {
		String data = "NameRecord[Name: " + this.name + ", Rankings = " + Arrays.toString(rank) + "]";
		return data;
	}
}
