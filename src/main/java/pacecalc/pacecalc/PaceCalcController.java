package pacecalc.pacecalc;

import java.util.Scanner;

import util.Parser;


public class PaceCalcController {

	public PaceCalcController() {
		// TODO Auto-generated constructor stub
	}
   public static void main(String[] args) {
	CLIuserInterface cli =new CLIuserInterface();
	cli.showWelcomeMsg();
	cli.showSelectionMsg();
	//TODO put all variables declaration at start so I don't need to declare different variables in each case block
	Scanner userInput=new Scanner(System.in);
	PaceCalc pacecalc=new PaceCalc();
	Parser parser=new Parser();
	int userSelection=userInput.nextInt();
	switch(userSelection){
	case 1:
		cli.showCalculatePaceMsg();
		cli.showEnterTimeMsg();
		String timeEnteredP=userInput.next();
		int newTimeP=parser.timeStringToInt(timeEnteredP);
		pacecalc.setTime(newTimeP);
		cli.showEnterDistanceMsg();
		String distanceEnteredP=userInput.next();
		int newDistanceP=parser.distanceStringToInt(distanceEnteredP);
		pacecalc.setTime(newDistanceP);
		int newPaceInt =pacecalc.calcPace(newDistanceP, newTimeP);
		String newPaceStr=parser.parseFromPace(newPaceInt);
		cli.showCalculatedPace(newPaceStr);
		cli.showContinueMsg();
		break;
	case 2:
		cli.showCalculateTimeMsg();
		cli.showEnterDistanceMsg();
		String distanceEnteredT=userInput.next();
		System.out.println("You entered "+distanceEnteredT);
		cli.showEnterPaceMsg();
		String paceEnteredT=userInput.next();
		System.out.println("You entered "+paceEnteredT);
		cli.showCalculatedTime("03:23:34");
		cli.showContinueMsg();
		break;
	case 3:
		cli.showCalculateDistanceMsg();
		cli.showEnterPaceMsg();
		String paceEnteredD=userInput.next();
		System.out.println("You entered "+paceEnteredD);
		cli.showEnterTimeMsg();
		String timeEnteredD=userInput.next();
		System.out.println("You entered "+timeEnteredD);
		cli.showCalculatedDistance("42195");
		cli.showContinueMsg();
		break;
	case 0:
		cli.showExitQuestionMsg();
		cli.showExitMsg();
		break;
	default: 
		cli.showErrorMsg();
		cli.showSelectionMsg();
		break;	
	}
	userInput.close();
}
}
