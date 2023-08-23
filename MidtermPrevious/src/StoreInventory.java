/**
 * @author (Your name goes here!)
 * Client Code to test the RetailItem class.
 */

public class StoreInventory {

	public static void main(String[] args) {

RetailItem item1 = new RetailItem("jacket", 15 ,29.95);
RetailItem item2 = new RetailItem("shirt", 0, 15.99);

 item1.sold(3);
 item2.addToInventory(20);
 
 //System.out.println("The inventory of " + item1.isWorthMore(item2)+ "is worth more than the inventory of " + item1.isWorthMore(item2)  );

 System.out.println(item2);
	}

}
