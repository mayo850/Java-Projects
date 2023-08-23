/**
 * @author (Your name goes here!)
 * 
 * This class defines a data type for a retail item  to
 * keep track of its inventory for a retail store
 */


public class RetailItem {
	
	private String description;
	private int unitsOnHand;
	private double price;


	
	
	// constructors
	public RetailItem(String description, int unitsOnHand, double price ) {
		
	if(unitsOnHand<0) {
		throw new IllegalArgumentException("");
	}
	this.description = description;
	this.unitsOnHand = unitsOnHand;
	this.price = price;
	}
	
	
	public RetailItem(String description, double price) {
		RetailItem myRetail = new RetailItem(description,0,price);
	}
	
	public String getDescription() {
		return description;
	}
	public double getValue() {
		return unitsOnHand*price;
	}
	
	public void sold(int item) {
		if(item < 0 || (this.unitsOnHand - item) < 0) {
			throw new IllegalArgumentException("negative");
		}
		this.unitsOnHand = unitsOnHand-item;
	}
	
	public void addToInventory(int item) {
		if(item<0) {
			throw new IllegalArgumentException();
		}
		this.unitsOnHand = unitsOnHand + item;
	}
	public boolean isWorthMore(RetailItem type) {
		if(this.unitsOnHand > unitsOnHand) {
			return true;
		}
		return false;
	}
	public String toString() {
		return "[item = " + description + ", units on hand = " + unitsOnHand + ", price = $" + price + "]";
	}
}
	
	
	
	// other instance methods
	
	
	
	
	


