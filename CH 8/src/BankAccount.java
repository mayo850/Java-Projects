/**
 * @author Izan Khan
 * @assignment CSC212- Routine Assignment Ch8
 * @version March 23, 2019
*/


public class BankAccount {

	private String name;
	private double balance = 0;
	private double transactionFee;

	public BankAccount(String name, double balance, double transactionFee) {

		if ((balance < 100) || (transactionFee < 0))
			throw new IllegalArgumentException();
		else {
			this.name = name;
			this.balance = balance;
			this.transactionFee = transactionFee;
		}

	}

	public BankAccount(String name, double balance) {
		this(name, balance, 1.25);
	}

	public String getName() {
		return this.name;
	}

	public double getBalance() {
		return this.balance;
	}

	public double getFee() {
		return this.transactionFee;
	}

	public void setFee(double fee) {
		if (fee <= 0)
			throw new IllegalArgumentException();
		else
			this.transactionFee = fee;
	}

	public double deposit(double amount) {
		if (amount <= 0)
			throw new IllegalArgumentException();
		else
			this.balance += amount;

		return this.balance;
	}

	public double withdraw(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException();
		else
			this.balance -= amount;

		if (this.balance < 0)
			throw new IllegalArgumentException("Cannot Withdraw");

		return this.balance;
	}

	public void transfer(BankAccount obj, String account, double amount) {
		if (amount < 0)
			throw new IllegalArgumentException();
		else {
			this.balance -= amount - this.transactionFee;
			obj.balance += amount;
			obj.name = account;
		}
		if (this.balance < 0)
			throw new IllegalArgumentException("Cannot Withdraw");

	}

	public String toString() {
		return this.name + ", $" + this.balance;
	}

}
