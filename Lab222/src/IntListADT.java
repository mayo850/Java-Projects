/**
 * 
 * Interface for a simplified list with int data
 *
 */
public interface IntListADT extends Iterable<Integer>{
	/**
	 * @return the number of elements in the list
	 */
	public int size();
	
	/**
	 * returns the value in the list at this index
	 * @param index - a position in the list
	 * @return the value at this index in this list
	 * @throws IllegalArgumentException when index < 0 or index >= size
	 */
	public int get(int index);
	
	/**
	 * @return a bracketed, comma separated string representation of the list
	 */
	public String toString();
	
	/**
	 * returns the position of this value in this list
	 * @param value - the value to be found in this list
	 * @return the position of this value or -1 if the value is not in this list
	 */
	public int indexOf(int value);
	
	/**
	 * appends the value to the end of this list
	 * @param value - the value to be appended to this list
	 */
	public void add(int value);
	
	/**
	 * adds this value at the given position in the list
	 * @param index - the position in this list where value should be added
	 * @param value - the value to be added to this list
	 * @throws IllegalArgumentException when index < 0 or index > size
	 */
	public void add(int index, int value);
	
	/**
	 * removes the value at this index in this list
	 * @param index - the position of the value to be removed from this list
	 * @throws IllegalArgumentException when index < 0 or index >= size
	 */
	public void remove(int index);

}
