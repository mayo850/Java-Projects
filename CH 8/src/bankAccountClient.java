/**
 * @author Izan Khan
 * @assignment CSC212- Routine Assignment Ch8
 * @version March 23, 2019
*/


public class bankAccountClient {

	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Million Aire", 5000000, 2.50);
		BankAccount obj1 = new BankAccount("College Student", 450);
		String s1 = obj.getName() + " has a balance of $" + obj.getBalance() + " and transaction fee of $"
				+ obj.getFee() + ".";
		System.out.println(s1);
		System.out.println(obj1.toString());
		obj.deposit(1500);
		obj.withdraw(20000);
		obj1.setFee(5);
		;
		obj1.withdraw(30);

		obj.transfer(obj1, obj1.getName(), 200000);
		System.out.println("After the transaction, " + obj.toString() + " and " + obj1.toString());

	}

}
