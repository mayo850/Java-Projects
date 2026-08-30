
public class RetailItem {
	// private data fieds
	private String description;
	private int unitsOnHands;
	private double price;
// constructor method
	
	public RetailItem(String description, int unitsOnHands, double price) {
		if (unitsOnHands < 0 || price < 0) throw new IllegalArgumentException();
		this.description = description;
		this.unitsOnHands = unitsOnHands;
		this.price = price;
	}
	public RetailItem(String description, double price) {
		this(description, 0, price);
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
		if (numItems < 0 || numItems > unitsOnHands) throw new IllegalArgumentException();
		unitsOnHands -= numItems;
	}
	public void addToinventory (int numAdded) {
		if (numAdded < 0) throw new IllegalArgumentException();
		unitsOnHands += numAdded;
	}
	public boolean isWorthMore(RetailItem param) {
		if (param == null) throw new IllegalArgumentException();
		return getValue() > param.getValue();
	}
	

	

}
