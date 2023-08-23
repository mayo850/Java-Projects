
public class RetailItem {
	// private data fieds
	private String description;
	private int unitsOnHands;
	private double price;
// constructor method
	
	public RetailItem(String description, int unitsOnHands, double price) {
		if (unitsOnHands < 0 || price < 0) throw new IllegalArgumentException();
		
	}
	public RetailItem(String description, double price) {
		this.unitsOnHands = 0;
	}
// acessor method
	public String getDescription() {
		return description;
		
	}
	public double getValue() {
		double totalValue = (unitsOnHands * price);
		return totalValue;
	}
	public void sold(int numItems) {
		unitsOnHands = numItems - unitsOnHands;
		if (unitsOnHands < 0) throw new IllegalArgumentException();
		
	}
	public void addToinventory (int numAdded) {
		if (numAdded < 0) throw new IllegalArgumentException();
		
		
	}
	public boolean isWorthMore(RetailItem param) {
		if (param > totalValue) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

	

}
