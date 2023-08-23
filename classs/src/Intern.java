/**
 * A class representing an Intern in our law office hierarchy scenario
 */
public class Intern extends Employee {
	public Intern() {
		super(0);
	}

	@Override
	public double getSalary() {
		return super.getSalary() * 0.25;
	}

	@Override
	public int getVacationDays() {
		if ((super.getVacationDays() - 5) < 1) {
			return 1;
		}

		return super.getVacationDays() - 5;
	}

	@Override
	public String getVacationForm() {
		return "green";
	}

	public void followOrders() {
		System.out.println("Yes sir!");
	}
}
