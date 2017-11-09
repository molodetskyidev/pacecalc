package pacecalc.pacecalc;

public class CLIuserInterface {

	// return line separator depending on the system settings
	private String lineseparator = System.getProperty("line.separator");

	public void showSelectionMsg() {
		// this string is shown in order inform user about possible choices to
		// calculate
		String selectionMsg = "Please select what you would like to do:" + lineseparator
				+ "* If you would like to calculate pace based on time and distance enter 1;" + lineseparator
				+ "* If you would like to time based on pace and distance enter 2;" + lineseparator
				+ "* If you would like to distance based on time and pace enter 3;" + lineseparator
				+ "* If you would like to exit enter 0;" + lineseparator + lineseparator + "Enter your choice here:";
		System.out.println(selectionMsg);
	}

	public void showContinueMsg() {
		String continueMsg = "Continue to work with Pace Calculator? Please type yes or no";
		System.out.println(continueMsg);
	}

	public void showWelcomeMsg() {
		// this string is shown for user at the start of applicaton
		String welcomeMsg = "************* Welcome to Pace Calculator! *************";
		System.out.println(welcomeMsg);
	}

	public void showErrorMsg() {
		// this string is shown while user entered a wrong value in user input
		String errorMsg = "You entered a wrong value!";
		System.out.println(errorMsg);
	}

	public void showCalculatePaceMsg() {
		String calculatePaceMsg = "You selected to calculate pace.";
		System.out.println(calculatePaceMsg);
	}

	public void showCalculateDistanceMsg() {
		String calculateDistanceMsg = "You selected to calculate distance.";
		System.out.println(calculateDistanceMsg);
	}

	public void showCalculateTimeMsg() {
		String calculateTimeMsg = "You selected to calculate time.";
		System.out.println(calculateTimeMsg);
	}

	public void showCalculateSpeedMsg() {
		String calculateSpeedMsg = "You selected to calculate speed.";
		System.out.println(calculateSpeedMsg);
	}

	public void showEnterTimeMsg() {
		String enterTimeMsg = "Please enter time you are going to run in following format hh:mm:ss:";
		System.out.println(enterTimeMsg);
	}

	public void showEnterDistanceMsg() {
		String enterDistanceMsg = "Please enter distance you are going to run in integer meters:";
		System.out.println(enterDistanceMsg);
	}

	public void showEnterPaceMsg() {
		String calculatePaceEnterTimeMsg = "Please enter pace you are going to run in following format mm:ss";
		System.out.println(calculatePaceEnterTimeMsg);
	}

	public void showExitQuestionMsg() {
		String exitQuestionMsg = "You selected exit the application. Are you sure? Please type yes or no";
		System.out.println(exitQuestionMsg);
	}

	public void showExitMsg() {
		String exitMsg = "Thank you for using Pace Calculator. Bye bye!";
		System.out.println(exitMsg);
	}

	public void showCalculatedPace(String pace) {
		System.out.println("Calculated! Based on your input pace should be " + pace);
	}

	public void showCalculatedTime(String time) {
		System.out.println("Calculated! Based on your input time should be " + time);
	}

	public void showCalculatedDistance(String distance) {
		System.out.println("Calculated! Based on your input distance should be " + distance + " km");
	}

}
