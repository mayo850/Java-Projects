/**
 * A class representing a legal secretary in our law office hierarchy scenario
 */
public class LegalSecretary extends Secretary {
	
	@Override
	public double getSalary() {
		 return super.getSalary() + 5000.0;
	}
	
	/**
	 * prints a legal secretary's cheery note
	 */
	public void fileLegalBriefs() {
		System.out.println("I could file all day!");
	}

}
