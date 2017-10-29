package pacecalc.pacecalc;

public class PaceCalc {
	private int time; //time in seconds
	private double speed; //speed in km/h
	private int pace; // pace in seconds per km
	private int distance; //distance in meters
	
	// get methods returns fields' values
	
	protected int getTime(){
		return this.time;
	}
    protected int getPace(){
    	return this.pace;
    }
    protected double getSpeed(){
    	return this.speed;
    	}
    protected int getDistance(){
    	
    	return this.distance;
    }
    
    // set methods set fields' values
    protected void setTime(int newTime){
    	this.time=newTime;
    }
    protected void setDistance(int newDistance){
    	this.distance=newDistance;
    }
    protected void setPace(int newPace){
    	this.pace=newPace;
    }
    protected void setSpeed(double newSpeed){
    	this.speed=newSpeed;
    }
}
