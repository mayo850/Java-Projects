/**
 * @author Izan Khan
 * @assignment CSC212-Lab8A
 * @version (March 20,2019)
 * 
 *          InvoiceItem represents the information for a purchase of an item
 *          from a store.
 *
 */
public class InvoiceItem {

	// fields
	private String partNum;
	private String partDescription;
	private int quantity;
	private double itemPrice;

	// constructor
	/**
	 * Constructs an invoice item with the given part number, part description,
	 * quantity of the item purchased, and the price to purchase one such item
	 * 
	 * @partNum - the part number of this invoice item
	 * @partDescription - a description of this invoice item in words
	 * @quantity - the number of this invoice item purchased
	 * @itemPrice - the price to purchase one such invoice item
	 */
	public InvoiceItem(String partNum, String partDescription, int quantity, double itemPrice) {
		this.partNum = partNum;
		this.partDescription = partDescription;
		setQuantity(quantity);
		setItemPrice(itemPrice);
	}

	// instance methods
	/**
	 * Returns a String representation of this invoice item including this item's
	 * part number, part description, quantity purchased, and the price purchase one
	 * such item
	 * 
	 * @return a String representation of this invoice item
	 */
	public String toString() {
		return ("Part " + partNum + ", " + partDescription + " purchase " + quantity + " items at $" + itemPrice
				+ " each");
	}

	/**
	 * Returns the part number of this invoice item
	 * 
	 * @return the part number of this invoice item
	 */
	public String getPartNum() {
		return partNum;
	}

	/**
	 * Returns the description of this invoice item
	 * 
	 * @return the description of this invoice item
	 */
	public String getDescription() {
		return partDescription;
	}

	/**
	 * Returns the quantity purchased of this invoice item
	 * 
	 * @return the quantity purchased of this invoice item
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Returns the price to purchase one of these invoice items
	 * 
	 * @return the price to purchase one of these invoice items
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * Returns the dollar amount to purchase the quantity of this item
	 * 
	 * @return the amount to purchase the quantity of this item
	 */
	public double getInvoiceAmount() {
		return quantity * itemPrice;
	}

	/**
	 * changes this invoice item's part number
	 * 
	 * @param partNum - the desired part number for this invoice item
	 */

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	/**
	 * changes this invoice item's description
	 * 
	 * @param partDescription - the desired description for this invoice item
	 */
	public void setDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	/**
	 * changes this invoice item's quantity
	 * 
	 * @param quantity - the desired quantity for this invoice item
	 * @throws IllegalArgumentException when quantity is invalid
	 */

	public void setQuantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("quantity is invalid");
		}
		this.quantity = quantity;

	}

	/**
	 * changes this invoice item's price
	 * 
	 * @param itemPrice - the desired price for this invoice item
	 * @throws IllegalArgumentException when price is invalid
	 */

	public void setItemPrice(double itemPrice) {
		if (itemPrice < 0) {
			throw new IllegalArgumentException("price per item is invalid");
		}
		this.itemPrice = itemPrice;

	}
}
