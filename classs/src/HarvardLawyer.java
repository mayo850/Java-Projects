/**
 * A class representing a Harvard lawyer in our law office hierarchy scenario
 */
public class HarvardLawyer extends Lawyer {

	public HarvardLawyer() {
		super(0);
	}

	public double getSalary() {
		return super.getSalary() * 1.2;
	}

	public int getVacationDays() {
		return super.getVacationDays() + 3;
	}

	public String getVacationForm() {
		String form = super.getVacationForm();
		return form + form + form + form;
	}

}
