import java.text.*;

public class LawOffice {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.00");
		
		Employee john = new Employee();
		Double salary = john.getSalary();
		int hours = john.getHours();
		int vacationDays = john.getVacationDays();
		String formColor = john.getVacationForm();
		
		
		System.out.println("John works " + hours + " hours.");
		System.out.println("John's salary is $" + df.format(salary));
		System.out.println("John uses a " + formColor + " form to request vacation.");
		System.out.println("John gets " + vacationDays + " vacation days a year.");
		System.out.println("\n");
		
		Secretary steve = new Secretary();
		salary = steve.getSalary();
		hours = steve.getHours();
		vacationDays = steve.getVacationDays();
		formColor = steve.getVacationForm();
		
		System.out.println("Steve works " + hours + " hours.");
		System.out.println("Steve's salary is $" + df.format(salary));
		steve.takeDictation("Dear Sir,");
		System.out.println("Steve uses a " + formColor + " form to request vacation.");
		System.out.println("Steve gets " + vacationDays + " vacation days a year.");
		
	}

}
