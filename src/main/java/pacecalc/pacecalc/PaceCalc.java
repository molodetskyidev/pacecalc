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
    
    //parseFrom methods convert fields' values in usual format in Strings
    
    protected String  parseFromTime(int time){
    	String timeHours;
    	String timeMin;
    	String timeSec;
    	
    	String returnTime;
    	timeHours=LeadingZero(time/3600);
    	timeMin=LeadingZero((time%3600)/60);
    	timeSec=LeadingZero((time%3600)%60);
    	returnTime=timeHours + ":"+timeMin+":"+ timeSec;
    			
    	return returnTime;
    }
    
    protected String  parseFromDistance(int distance){
    	int returnDistanceKm;
    	int returnDistanceM;
    	String leadingZero;
    	String returnDistance;
    	returnDistanceKm=distance/1000;
    	returnDistanceM=distance%1000;
    	if(returnDistanceM>99){
    		leadingZero="";}
    	else if(returnDistanceM>9){
    		leadingZero="0";	
    	}
    	else if(returnDistanceM==0) {
    		leadingZero="";	
    	}
    	else {
    		leadingZero="00";
    	}
    	returnDistance=Integer.toString(returnDistanceKm)+"." + leadingZero +Integer.toString(returnDistanceM);
    	return returnDistance;
    }
    
    protected String  parseFromPace(int pace){
    	String returnPaceMin;
    	String returnPaceSec;
    	String returnPace;
    	returnPaceMin= LeadingZero(pace/60);
    	returnPaceSec=LeadingZero(pace%360);
    	returnPace=returnPaceMin + ":" + returnPaceSec;
    	return returnPace;
    }
    protected String parseFromSpeed(double speed){
    	String returnSpeed = Double.toString(speed);
    	return returnSpeed;
    }
    private String LeadingZero(int intNumber){
    	String strLeadingZero;
    	if(intNumber<10){
    		strLeadingZero="0"+Integer.toString(intNumber);
    	}
    	else{
    		strLeadingZero=Integer.toString(intNumber);
    	}
    	return strLeadingZero;
    }
    protected int calcPace(int distance, int time){
    	return 0;
    }
}
