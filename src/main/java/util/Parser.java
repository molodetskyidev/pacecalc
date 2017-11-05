package util;

// this class is util class to make parsing or other string manipulation
public class Parser {
	// parseFrom methods convert fields' values in usual format in Strings

	// parseFromTime converts int to format String hh:mm:ss

	public String parseFromTime(int time) {
		String timeHours;
		String timeMin;
		String timeSec;

		String returnTime;
		timeHours = LeadingZero(time / 3600);
		timeMin = LeadingZero((time % 3600) / 60);
		timeSec = LeadingZero((time % 3600) % 60);
		returnTime = timeHours + ":" + timeMin + ":" + timeSec;

		return returnTime;
	}

	// parseFromDistance converts int to format String km.mmm

	public String parseFromDistance(int distance) {
		int returnDistanceKm;
		int returnDistanceM;
		String leadingZero;
		String returnDistance;
		returnDistanceKm = distance / 1000;
		returnDistanceM = distance % 1000;
		if (returnDistanceM > 99) {
			leadingZero = "";
		} else if (returnDistanceM > 9) {
			leadingZero = "0";
		} else if (returnDistanceM == 0) {
			leadingZero = "";
		} else {
			leadingZero = "00";
		}
		returnDistance = Integer.toString(returnDistanceKm) + "." + leadingZero + Integer.toString(returnDistanceM);
		return returnDistance;
	}

	// parseFromPace converts int to format String hh:mm:ss

	public String parseFromPace(int pace) {
		String returnPaceHrs;
		String returnPaceMin;
		String returnPaceSec;
		String returnPace;
		returnPaceHrs = LeadingZero(pace / 3600);
		returnPaceMin = LeadingZero((pace % 3600) / 60);
		returnPaceSec = LeadingZero((pace % 3600) % 60);
		if (returnPaceHrs.compareTo("00") != 0) {
			returnPace = returnPaceHrs + ":" + returnPaceMin + ":" + returnPaceSec;
		} else {

			returnPace = returnPaceMin + ":" + returnPaceSec;
		}
		return returnPace;
	}

	// parseFromSpeed converts double to format String km.mm

	public String parseFromSpeed(double speed) {
		String returnSpeed = Double.toString(speed);
		return returnSpeed;
	}
	public int timeStringToInt(String timeString) {
		String delims = ":";
		String[] time = timeString.split(delims);
		
		int timeInt = Integer.parseInt(time[0])*3600+Integer.parseInt(time[1])*60+Integer.parseInt(time[2]);
		
		return timeInt;
	}
	public int paceStringToInt(String timeString) {
		String delims = ":";
		String[] time = timeString.split(delims);
		
		int timeInt = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
		
		return timeInt;
	}


	public int distanceStringToInt(String distanceEnteredP) {
		int distanceInt=Integer.parseInt(distanceEnteredP);
		return distanceInt;
	}
	
	// method to cover situation with leading 0 in parseFrom strings

	public String LeadingZero(int intNumber) {
		String strLeadingZero;
		if (intNumber < 10) {
			strLeadingZero = "0" + Integer.toString(intNumber);
		} else {
			strLeadingZero = Integer.toString(intNumber);
		}
		return strLeadingZero;
	}

}
