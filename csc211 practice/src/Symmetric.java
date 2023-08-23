import java.util.Arrays;

public class Symmetric {

	public static void main(String[] args) {
		int[][] board = new int[4][6];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = (row + 1) * (col + 2);
			}
		}
		System.out.println(Arrays.toString(board[3]));
	}

	public static int countColOccurrences(String[][] degrees, int colIndex, String target)
			throws IllegalArgumentException {
		if (colIndex < 0 || colIndex >= degrees[0].length)
			throw new IllegalArgumentException("Not Valid");
		int count = 0;

		for (int i = 0; i < degrees.length; i++)
			if (degrees[i][colIndex].compareToIgnoreCase(target) == 0)
				count++;

		return count;
	}

	public static int[] rowSums(int[][] matrix) {
		int array[] = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			int sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
				array[i] = sum;
			}
		}
		return array;
	}

}
