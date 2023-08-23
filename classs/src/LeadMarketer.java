/**
 * A LeadMarketer in our law office hierarchy scenario
 */
public class LeadMarketer extends Marketer {
	// constructor
	public LeadMarketer(int years) {
		super(years);
	}

	@Override
	public double getSalary() {
		// double baseSalary = super.getSalary();
		// return baseSalary + 10000.0;

		return (super.getSalary() + 10000.0) * 1.1;
	}

	@Override
	public int getVacationDays() {
		return (super.getVacationDays()) * 2;
	}

	@Override
	public String getVacationForm() {
		return "blue";
	}

	/**
	 * prints a marketer's special line
	 */
	public void advertise() {
		System.out.println("I'm the boss!");
	}
}
