/**
 * Name(s): Izan Khan --> referred to the Code in class. 
 * Date: 10/7/2020 CSC 371
 * Lab 4 -- Blob.java
 * 
 * Class that solves problem of counting abnormal cells.
 **/
public class Blob {

	/** The grid */
	private TwoDimGrid grid;

	/** Constructors */
	public Blob(TwoDimGrid grid) {
		this.grid = grid;
	}

	/**
	 * Finds the number of cells in the blob at (x,y).
	 * 
	 * @pre Abnormal cells are in GridColors.ABNORMAL color; Other cells are in
	 *      GridColors.BACKGROUND color.
	 * @post All cells in the blob are in the GridColors.TEMPORARY color.
	 * @param x The x-coordinate of a blob cell
	 * @param y The y-coordinate of a blob cell
	 * @return The number of cells in the blob that contains (x, y)
	 */
	public int countCells(int x, int y) {
		if (x < 0 || x >= grid.getNCols() || y < 0 || y >= grid.getNRows()) {
			return 0;
		} else if (!grid.getColor(x, y).equals(GridColors.ABNORMAL)) {
			return 0;
		}

		grid.recolor(x, y, GridColors.TEMPORARY);
		return 1

				+ countCells(x - 1, y + 1) + countCells(x, y + 1) + countCells(x + 1, y + 1) + countCells(x - 1, y)
				+ countCells(x + 1, y) + countCells(x - 1, y - 1) + countCells(x, y - 1) + countCells(x + 1, y - 1);

	}

	/** Restore the grid by returning all TEMPORARY cells to ABNORMAL */
	public void restore() {
		grid.recolor(GridColors.TEMPORARY, GridColors.ABNORMAL);
	}

}
