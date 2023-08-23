
public class Time {
	//private data fields
	private int hour;
	
	private int minute;
	private int second;
	// constructor
	// default constructor
	public Time() {
		this(0, 0, 0);
	}
	public Time(int numHours) {
		this(numHours, 0, 0);
	}
	public Time(int numHours, int numMinutes) {
		this(numHours, numMinutes, 0);
	}
	public Time(int numHours, int numMinutes, int numSeconds) {
		setTime(numHours, numMinutes, numSeconds);
	}
	public void setTime(int numHours, int numMinutes, int numSeconds) {
		setHours (numHours);
		setMinutes (numMinutes);
		setSeconds (numSeconds);
	}
	public void setHours(int numHours) throws IllegalArgumentException {
		if (numHours < 0 || numHours > 23) {
			throw new IllegalArgumentException ("hour must be 0-23");
		}
		//set the value
		hour = numHours;
		
	}
	public void setMinutes(int numMinutes) throws IllegalArgumentException {
		if (numMinutes > 59 || numMinutes < 0) {
			throw new IllegalArgumentException ("minute must be 0-59");
		}
		//set the value
		minute = numMinutes;
		
	}
	public void  setSeconds(int numSeconds) throws IllegalArgumentException {
		if (numSeconds > 59 || numSeconds < 0) {
			throw new IllegalArgumentException ("second must be 0-59");
		}
		//set the value
		second = numSeconds;
		
	}
	public int getHour(){
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSeconds() {
		return second;
	}
	public toUniversalString() {
		String.format(format, args)
	}
	public String toString() {
		
	}
	
}
