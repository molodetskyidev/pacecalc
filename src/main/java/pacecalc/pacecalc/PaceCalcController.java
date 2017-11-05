package pacecalc.pacecalc;

import java.util.Scanner;

import util.Parser;


public class PaceCalcController {

	public PaceCalcController() {
		// TODO Auto-generated constructor stub
	}
	public static void CalcFlow(){
		int timeInt;
		int distanceInt;
		int paceInt;
		String timeStr;
		String distanceStr;
		String paceStr;
		String answer;
		CLIuserInterface cli =new CLIuserInterface();
		cli.showWelcomeMsg();
		cli.showSelectionMsg();
		//TODO put all variables declaration at start so I don't need to declare different variables in each case block
		Scanner userInput=new Scanner(System.in);
		PaceCalc pacecalc=new PaceCalc();
		Parser parser=new Parser();
		int userSelection=userInput.nextInt();
		//TODO looks like I don't need setters in this function should think about their deletion
		switch(userSelection){
		case 1:
			cli.showCalculatePaceMsg();
			cli.showEnterTimeMsg();
			timeStr=userInput.next();
			timeInt=parser.timeStringToInt(timeStr);
			//pacecalc.setTime(timeInt);
			cli.showEnterDistanceMsg();
			distanceStr=userInput.next();
			distanceInt=parser.distanceStringToInt(distanceStr);
			//pacecalc.setTime(distanceInt);
			paceInt =pacecalc.calcPace(distanceInt, timeInt);
			paceStr=parser.parseFromPace(paceInt);
			cli.showCalculatedPace(paceStr);
			cli.showContinueMsg();
			answer=userInput.next();
			if(answer.equals("yes")){
				CalcFlow();
			}else if(answer.equals("no")){
			cli.showExitMsg();
			System.exit(0);
			}
			break;
		case 2:
			cli.showCalculateTimeMsg();
			cli.showEnterDistanceMsg();
		    distanceStr=userInput.next();
		    distanceInt=parser.distanceStringToInt(distanceStr);
			//pacecalc.setDistance(distanceInt);
			cli.showEnterPaceMsg();
			paceStr=userInput.next();
			paceInt=parser.paceStringToInt(paceStr);
			//pacecalc.setPace(paceInt);
			timeInt=pacecalc.calcTime(paceInt, distanceInt);
			timeStr=parser.parseFromTime(timeInt);
			cli.showCalculatedTime(timeStr);
			cli.showContinueMsg();
			answer=userInput.next();
			if(answer.equals("yes")){
				CalcFlow();
			}else if(answer.equals("no")){
			cli.showExitMsg();
			System.exit(0);
			}
			break;
		case 3:
			cli.showCalculateDistanceMsg();
			cli.showEnterPaceMsg();
			paceStr=userInput.next();
			paceInt=parser.paceStringToInt(paceStr);
			//pacecalc.setPace(paceInt);
			cli.showEnterTimeMsg();
			timeStr=userInput.next();
			timeInt=parser.timeStringToInt(timeStr);
			//pacecalc.setTime(timeInt);
	        distanceInt=pacecalc.calcDistance(paceInt, timeInt);
	        distanceStr=parser.parseFromDistance(distanceInt);
			cli.showCalculatedDistance(distanceStr);
			cli.showContinueMsg();
			answer=userInput.next();
			if(answer.equals("yes")){
				CalcFlow();
			}else if(answer.equals("no")){
			cli.showExitMsg();
			System.exit(0);
			}
			break;
		case 0:
			cli.showExitQuestionMsg();
			answer=userInput.next();
			if(answer.equals("no")){
				CalcFlow();
			}else if(answer.equals("yes")){
			cli.showExitMsg();
			System.exit(0);
			}
			break;
		default: 
			cli.showErrorMsg();
			CalcFlow();
			break;	
		}
		userInput.close();
	}
	
}
