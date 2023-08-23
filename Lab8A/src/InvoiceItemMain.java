/**
 * @author Izan Khan
 * @assign CSC212-Lab8A
 * @version (March 20, 2019)
 * 
 *          InvoiceItemMain is a simple test program for the InvoiceItem class
 * 
 */
public class InvoiceItemMain {

	public static void main(String[] args) {
		InvoiceItem purchaseOne = new InvoiceItem("XP-101", "Glidden paint, gallon", 4, 22.29);
		InvoiceItem purchaseTwo = new InvoiceItem("PB-203", "paint brush, 3 inch", 2, 10.99);

		System.out.println("Purchase One: " + purchaseOne);
		System.out.println("Purchase Two: " + purchaseTwo);
		System.out.println();

		purchaseOne.setQuantity(6);
		purchaseTwo.setItemPrice(9.59);

		System.out.println(purchaseOne.getQuantity() + " of " + purchaseOne.getPartNum() + " is $"
				+ purchaseOne.getInvoiceAmount());
		System.out.println(purchaseTwo.getQuantity() + " of " + purchaseTwo.getPartNum() + " is $"
				+ purchaseTwo.getInvoiceAmount());

		try {
			InvoiceItem purchaseThree = new InvoiceItem("CC-105", "hammer", 1, -4.19);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e);
		}

	}

}
