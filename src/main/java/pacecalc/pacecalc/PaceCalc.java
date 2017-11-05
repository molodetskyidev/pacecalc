package pacecalc.pacecalc;

public class PaceCalc {
	private int time; // time in seconds
	private double speed; // speed in km/h
	private int pace; // pace in seconds per km
	private int distance; // distance in meters

	// get methods returns fields' values

	protected int getTime() {
		return this.time;
	}

	protected int getPace() {
		return this.pace;
	}

	protected double getSpeed() {
		return this.speed;
	}

	protected int getDistance() {

		return this.distance;
	}

	// set methods set fields' values
	protected void setTime(int newTime) {
		this.time = newTime;
	}

	protected void setDistance(int newDistance) {
		this.distance = newDistance;
	}

	protected void setPace(int newPace) {
		this.pace = newPace;
	}

	protected void setSpeed(double newSpeed) {
		this.speed = newSpeed;
	}

	// method for Pace calculation based on distance and time

	protected int calcPace(int distance, int time) {
		int resultPace;
		resultPace = (int) (1000 * time / distance);
		return resultPace;
	}

	// method for Distance calculation based on pace and time

	protected int calcDistance(int pace, int time) {
		int resultDistance;
		resultDistance = (int) (1000 * time / pace);
		return resultDistance;
	}

	// method for Time calculation based on distance and pace

	protected int calcTime(int pace, int distance) {
		int resultTime;
		resultTime = (int) (pace * distance / 1000);
		return resultTime;
	}

	// method for Speed calculation based on pace

	protected double calcSpeed(int pace) {
		double resultSpeed;
		resultSpeed = (double) (3600) / (double) (pace);
		return resultSpeed;
	}

	// default empty constructor

	public PaceCalc() {

	}

	// second constructor which sets all fields on create Object

	public PaceCalc(int pace, int distance, int time, double speed) {
		this.setDistance(distance);
		this.setPace(pace);
		this.setTime(time);
		this.setSpeed(speed);
	}

}
