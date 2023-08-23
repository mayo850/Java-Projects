/**
 * A lawyer in our law office hierarchy scenario
 */
public class Lawyer extends Employee {
	// constructor
	public Lawyer(int years) {
		super(years);
	}
	
	
	
   @Override
	public String getVacationForm() {
        return "pink";
    }
    
   @Override
   public int getVacationDays() {
    	return super.getVacationDays() + 5;
    }


    /**
     *  prints an encouraging lawyer statement
     */
    public void sue() {
    	System.out.println("I'll see you in court!");
    }
    
    @Override
    public double getSalary() {
    	return super.getSalary() + 5000 * getYears();
    }

}

