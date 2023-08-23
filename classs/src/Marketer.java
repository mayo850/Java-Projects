/**
 * A marketer in our law office hierarchy scenario
 */

public class Marketer extends Employee {
	
	// constructor
	public Marketer(int years) {
		super(years);
	}
	
	
	

	@Override
	public double getSalary() {
		//double baseSalary = super.getSalary();
		//return baseSalary + 10000.0;
		
		return super.getSalary() + 10000.0;
	}
	
	/**
	 * prints a marketer's special line
	 */
	public void advertise() {
		System.out.println("Act now while supplies last!");
	}
	
	
	
}
