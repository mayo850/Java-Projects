
public class Car {
	//private data fields
	private String modelYear;
	private String model;
	private String make;
	private int speed;
	// constructor
	public Car (String modelYear, String model, String make) {
		this.modelYear = modelYear;
		this.model = model;
		this.make = make;
		this.speed = 0;
		
	}
	// calling constructor one hint look at the parameters
	public Car (String model, String make) {
		this("2020", model, make);
	}
	public String getModelYear() {
		return modelYear;
	}
	public String getModel() {
		return model;
	}
	public String getMake() {
		return make;
	}
	public int getSpeed() {
		return speed;
	
	}
	public void accelerate(int amount) {
		speed = speed + (amount);
		
	}
	public int brake() {
		speed = speed - 5;
		if (speed < 0) {
			speed = 0;
		}
		return speed;
	}
	public boolean isFasterThan(Car second) {
		//formal is the param
		//implicit is on the top to access use this.
		if(this.speed > second.speed) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public String toStrin() {
		return("");
	}
}
