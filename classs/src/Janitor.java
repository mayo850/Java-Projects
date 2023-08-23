/**
 * A class representing a janitor in our law office hierarchy scenario
 */
public class Janitor extends Employee {

	public Janitor() {
		super(0);
	}

	public int getHours() {
		return 2 * super.getHours();
	}

	public double getSalary() {
		return super.getSalary() - 10000;
	}

	public int getVacationDays() {
		return super.getVacationDays() / 2;
	}

	public void statement() {
		System.out.println("Workin' for the man");
	}
}
