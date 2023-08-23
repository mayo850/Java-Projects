
public class LawOfficeTwo {

	public static void main(String[] args) {
		
		System.out.println("Lawyer: ");
		Lawyer lucy = new Lawyer(5);
		System.out.print(lucy.getHours() + ", ");
		System.out.printf("$%.2f, ", lucy.getSalary());
		System.out.print(lucy.getVacationDays() + ", ");
		System.out.println(lucy.getVacationForm());
		lucy.sue();
		
		System.out.println("\nLegal Secretary: ");
		LegalSecretary leo = new LegalSecretary();
		System.out.print(leo.getHours() + ", ");
		System.out.printf("$%.2f, ", leo.getSalary());
		System.out.print(leo.getVacationDays() + ", ");
		System.out.println(leo.getVacationForm());
		leo.takeDictation("Sincerely");
		leo.fileLegalBriefs();
		
		System.out.println("\nMarketer: ");
		Marketer mary = new Marketer(4);
		System.out.print(mary.getHours() + ", ");
		System.out.printf("$%.2f, ", mary.getSalary());
		System.out.print(mary.getVacationDays() + ", ");
		System.out.println(mary.getVacationForm());
		mary.advertise();
		
		System.out.println("\nIntern: ");
		Intern John = new Intern();
		System.out.print(John.getHours() + ", ");
		System.out.printf("$%.2f, ", John.getSalary());
		System.out.print(John.getVacationDays() + ", ");
		System.out.println(John.getVacationForm());
		John.followOrders();
		
	}

}
