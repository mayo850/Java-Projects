/**
 * @author Izan Khan
 * @assignment CSC212-Routine13
 * @version (10 May, 2019)
 * 
 *          Description: Heath Profile defines a data type for the basic health
 *          information of a patient including name, birth date, age, height,
 *          weight, heart rate information, and bmi information.
 * 
 */

public class HealthProfile implements Comparable<HealthProfile> {
	// class constants
	private static final int MAX_RATE = 220;
	private static final double MIN_RANGE_PERCENT = .50;
	private static final double MAX_RANGE_PERCENT = .85;
	private static final double BMI_LOW_CUT = 18.5;
	private static final double BMI_MID_CUT = 25;
	private static final double BMI_HIGH_CUT = 30;
	private static final int CONVERSION_FACTOR = 703;

	// fields
	private String idNum;
	private String lastName;
	private String firstName;
	private SimpleDate birthDate;
	private int height;
	private int weight;

	public HealthProfile() {

	}

	/**
	 * Constructs a HealthProfile object representing the health information of one
	 * patient
	 * 
	 * @param idNum- id number of this health profile
	 * @param lastName- last name of this health profile
	 * @param firstName- first name of this health profile
	 * @param birthDate- birthday of this health profile
	 * @param height- height of this health profile
	 * @param weight- weight of this health profile
	 */
	public HealthProfile(String idNum, String lastName, String firstName, SimpleDate birthDate, int height,
			int weight) {
		this.idNum = idNum;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		setHeight(height);
		setWeight(weight);
	}

	/**
	 * @return the id number of this health profile
	 */
	public String getIdNum() {
		return idNum;
	}

	/**
	 * @return the last name of this health profile
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the first name of this health profile
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the birthday of this health profile
	 */
	public SimpleDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the height of this health profile
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the weight of this health profile
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Stores the height for this health profile
	 * 
	 * @param height - height of the patient to be stored
	 * @throws IllegalArgumentException when height is not positive
	 */
	public void setHeight(int height) {
		if (height <= 0) {
			throw new IllegalArgumentException();
		}
		this.height = height;
	}

	/**
	 * Stores the weight for this health profile
	 * 
	 * @param weight - weight of the patient to be stored
	 * @throws IllegalArgumentException when weight is not positive
	 */
	public void setWeight(int weight) {
		if (weight <= 0) {
			throw new IllegalArgumentException();
		}
		this.weight = weight;
	}

	/**
	 * @return the age of this patient
	 */
	public int getAge() {
		SimpleDate today = new SimpleDate();

		int age = today.getYear() - birthDate.getYear();

		if (today.getMonth() < birthDate.getMonth()) {
			age--;
		} else if (today.getMonth() == birthDate.getMonth() && today.getDay() < birthDate.getDay()) {
			age--;
		}
		return age;
	}

	/**
	 * @return the maximum heart rate for this patient
	 */
	public int getMaxHeartRate() {
		return MAX_RATE - getAge();
	}

	/**
	 * @return the minimum of this patient's target heart range
	 */
	public int getMinTargetRange() {
		return (int) Math.round(MIN_RANGE_PERCENT * getMaxHeartRate());
	}

	/**
	 * @return the maximum of this patient's target heart range
	 */
	public int getMaxTargetRange() {
		return (int) Math.round(MAX_RANGE_PERCENT * getMaxHeartRate());
	}

	/**
	 * @return this patient's body mass index
	 */
	public double getBmi() {
		double bmi = (double) (weight * CONVERSION_FACTOR) / (height * height);
		return Math.round(bmi * 10) / 10.0;
	}

	/**
	 * @return this patient's body mass index category description
	 */
	public String getBmiCategory() {
		double bmi = getBmi();
		if (bmi < BMI_LOW_CUT) {
			return "Underweight";
		} else if (bmi < BMI_MID_CUT) {
			return "normal";
		} else if (bmi < BMI_HIGH_CUT) {
			return "Overweight";
		} else {
			return "Obese";
		}
	}

	/**
	 * @return a String representation of this health profile
	 */
	public String toString() {
		return "HealthProfile [" + idNum + " " + lastName + ", " + firstName + " " + birthDate + " " + height + " in. "
				+ weight + " lbs.]";
	}

	@Override
	public int compareTo(HealthProfile st) {

		if (Integer.parseInt(this.idNum) == Integer.parseInt((st.idNum)))
			return 0;
		else if ((Integer.parseInt(this.idNum)) > (Integer.parseInt(st.idNum)))
			return 1;
		else
			return -1;

	}

}
