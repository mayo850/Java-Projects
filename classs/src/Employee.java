/**
 * A class representing an employee in our law office hierarchy scenario.
 */
public class Employee {
	// fields
	private int years;
	
	
	
	// constructor
	public Employee(int years) {
		this.years = years;
	}
	
	public int getYears() {
		return years;
	}
	/**
	 * Provides the hours worked by this employee
	 * @return the hours worked
	 */
    public int getHours() {
        return 40;           
    }
    
    /**
     * Provides this employee's yearly salary
     * @return the yearly salary
     */
    public double getSalary() {
        return 50000.0;     
    }
    
    /**
     * Provides this employee's total number of vacation days per year
     * @return the total number of vacation days
     */
    public int getVacationDays() {
        return 10 + 2 * years; 
    }

    /**
     * Provides this employee's form for requesting vacation days
     * @return the required vacation form
     */
    public String getVacationForm() {
        return "yellow";
    }
}
