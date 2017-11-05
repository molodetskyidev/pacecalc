package pacecalc.pacecalc;

import java.util.Scanner;

import util.Parser;

public class PaceCalcController {

	public void CalcFlow(PaceCalc pacecalc, CLIuserInterface cli) {
		int timeInt;
		int distanceInt;
		int paceInt;
		String timeStr;
		String distanceStr;
		String paceStr;
		String answer;
		
		cli.showWelcomeMsg();
		cli.showSelectionMsg();
		Scanner userInput = new Scanner(System.in);
		// PaceCalc pacecalc=new PaceCalc();
		Parser parser = new Parser();
		int userSelection = userInput.nextInt();
		// TODO looks like I don't need setters in this function should think
		// about their deletion
		switch (userSelection) {
		case 1:
			cli.showCalculatePaceMsg();
			cli.showEnterTimeMsg();
			timeStr = userInput.next();
			timeInt = parser.timeStringToInt(timeStr);
			while(timeInt<0){
				cli.showErrorMsg();
				cli.showEnterTimeMsg();
				timeStr = userInput.next();
				timeInt = parser.timeStringToInt(timeStr);
			}
			// pacecalc.setTime(timeInt);
			cli.showEnterDistanceMsg();
			distanceStr = userInput.next();
			distanceInt = parser.distanceStringToInt(distanceStr);
			while(distanceInt<0){
				cli.showErrorMsg();
				cli.showEnterDistanceMsg();
				distanceStr = userInput.next();
				distanceInt = parser.distanceStringToInt(distanceStr);
			}
			// pacecalc.setTime(distanceInt);
			paceInt = pacecalc.calcPace(distanceInt, timeInt);
			paceStr = parser.parseFromPace(paceInt);
			cli.showCalculatedPace(paceStr);
			cli.showContinueMsg();
			answer = userInput.next();
			if (answer.equals("yes")) {
				CalcFlow(pacecalc, cli);
			} else if (answer.equals("no")) {
				cli.showExitMsg();
				System.exit(0);
			}
			break;
		case 2:
			cli.showCalculateTimeMsg();
			cli.showEnterDistanceMsg();
			distanceStr = userInput.next();
			distanceInt = parser.distanceStringToInt(distanceStr);
			while(distanceInt<0){
				cli.showErrorMsg();
				cli.showEnterDistanceMsg();
				distanceStr = userInput.next();
				distanceInt = parser.distanceStringToInt(distanceStr);
			}
			
			// pacecalc.setDistance(distanceInt);
			cli.showEnterPaceMsg();
			paceStr = userInput.next();
			paceInt = parser.paceStringToInt(paceStr);
			while(paceInt<0){
				cli.showErrorMsg();
				cli.showEnterPaceMsg();
				paceStr = userInput.next();
				paceInt = parser.paceStringToInt(paceStr);
			}
			// pacecalc.setPace(paceInt);
			timeInt = pacecalc.calcTime(paceInt, distanceInt);
			timeStr = parser.parseFromTime(timeInt);
			cli.showCalculatedTime(timeStr);
			cli.showContinueMsg();
			answer = userInput.next();
			if (answer.equals("yes")) {
				CalcFlow(pacecalc, cli);
			} else if (answer.equals("no")) {
				cli.showExitMsg();
				System.exit(0);
			}
			
			break;
		case 3:
			cli.showCalculateDistanceMsg();
			cli.showEnterPaceMsg();
			paceStr = userInput.next();
			paceInt = parser.paceStringToInt(paceStr);
			while(paceInt<0){
				cli.showErrorMsg();
				cli.showEnterPaceMsg();
				paceStr = userInput.next();
				paceInt = parser.paceStringToInt(paceStr);
			}
			
			// pacecalc.setPace(paceInt);
			cli.showEnterTimeMsg();
			timeStr = userInput.next();
			timeInt = parser.timeStringToInt(timeStr);
			while(timeInt<0){
				cli.showErrorMsg();
				cli.showEnterTimeMsg();
				timeStr = userInput.next();
				timeInt = parser.timeStringToInt(timeStr);
			}
			// pacecalc.setTime(timeInt);
			distanceInt = pacecalc.calcDistance(paceInt, timeInt);
			distanceStr = parser.parseFromDistance(distanceInt);
			cli.showCalculatedDistance(distanceStr);
			cli.showContinueMsg();
			answer = userInput.next();
			if (answer.equals("yes")) {
				CalcFlow(pacecalc, cli);
			} else if (answer.equals("no")) {
				cli.showExitMsg();
				System.exit(0);
			}
			
			break;
		case 0:
			cli.showExitQuestionMsg();
			answer = userInput.next();
			if (answer.equals("no")) {
				CalcFlow(pacecalc, cli);
			} else if (answer.equals("yes")) {
				cli.showExitMsg();
				System.exit(0);
			}
			break;
		default:
			cli.showErrorMsg();
			CalcFlow(pacecalc, cli);
			break;
		}
		userInput.close();
	}

}
