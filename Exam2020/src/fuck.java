import java.util.Scanner;

public class fuck {

	public static void main(String[] args) {
		System.out.print("enter num");
		Scanner console = new Scanner(System.in);
		findStats(console);

	}
	public static void findStats(Scanner console) {
		// num values 
		int number = console.nextInt();
		int total = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i =0; i < number; i++) {
			int numbers = console.nextInt();
			total = total + numbers;
			if (numbers > max) {
				max = numbers;
			}
			if (numbers < min) {
				min = numbers;
			}
		}
		double average = total/number;
		System.out.printf("Average: %.2f\n", average);
		System.out.println("Maximum" + max);
	}
	//double average = total/number;
	

}
