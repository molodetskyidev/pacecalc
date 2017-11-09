package pacecalc.pacecalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.Parser;

public class PaceCalcController {

	private PaceCalc pacecalc;
	private CLIuserInterface cli;
	private PaceCalcUI ui;

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

		Parser parser = new Parser();
		try {
			int userSelection = userInput.nextInt();

			switch (userSelection) {
			case 1:
				cli.showCalculatePaceMsg();
				cli.showEnterTimeMsg();
				timeStr = userInput.next();
				timeInt = parser.timeStringToInt(timeStr);
				while (timeInt <= 0) {
					cli.showErrorMsg();
					cli.showEnterTimeMsg();
					timeStr = userInput.next();
					timeInt = parser.timeStringToInt(timeStr);
				}

				cli.showEnterDistanceMsg();
				distanceStr = userInput.next();
				distanceInt = parser.distanceStringToInt(distanceStr);
				while (distanceInt < 0) {
					cli.showErrorMsg();
					cli.showEnterDistanceMsg();
					distanceStr = userInput.next();
					distanceInt = parser.distanceStringToInt(distanceStr);
				}
				pacecalc.setDistance(distanceInt);
				pacecalc.setTime(timeInt);
				paceInt = pacecalc.calcPace();
				paceStr = parser.parseFromPace(paceInt);
				cli.showCalculatedPace(paceStr);
				cli.showContinueMsg();
				answer = userInput.next();
				while (!answer.equals("yes") && !answer.equals("no")) {
					cli.showErrorMsg();
					cli.showContinueMsg();
					answer = userInput.next();
				}
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
				while (distanceInt < 0) {
					cli.showErrorMsg();
					cli.showEnterDistanceMsg();
					distanceStr = userInput.next();
					distanceInt = parser.distanceStringToInt(distanceStr);
				}
				cli.showEnterPaceMsg();
				paceStr = userInput.next();
				paceInt = parser.paceStringToInt(paceStr);
				while (paceInt < 0) {
					cli.showErrorMsg();
					cli.showEnterPaceMsg();
					paceStr = userInput.next();
					paceInt = parser.paceStringToInt(paceStr);
				}
				pacecalc.setPace(paceInt);
				pacecalc.setDistance(distanceInt);
				timeInt = pacecalc.calcTime();
				timeStr = parser.parseFromTime(timeInt);
				cli.showCalculatedTime(timeStr);
				cli.showContinueMsg();
				answer = userInput.next();
				while (!answer.equals("yes") && !answer.equals("no")) {
					cli.showErrorMsg();
					cli.showContinueMsg();
					answer = userInput.next();
				}
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
				while (paceInt < 0) {
					cli.showErrorMsg();
					cli.showEnterPaceMsg();
					paceStr = userInput.next();
					paceInt = parser.paceStringToInt(paceStr);
				}

				pacecalc.setPace(paceInt);
				cli.showEnterTimeMsg();
				timeStr = userInput.next();
				timeInt = parser.timeStringToInt(timeStr);
				while (timeInt < 0) {
					cli.showErrorMsg();
					cli.showEnterTimeMsg();
					timeStr = userInput.next();
					timeInt = parser.timeStringToInt(timeStr);
				}
				pacecalc.setTime(timeInt);
				distanceInt = pacecalc.calcDistance();
				distanceStr = parser.parseFromDistance(distanceInt);
				cli.showCalculatedDistance(distanceStr);
				cli.showContinueMsg();
				answer = userInput.next();
				while (!answer.equals("yes") && !answer.equals("no")) {
					cli.showErrorMsg();
					cli.showContinueMsg();
					answer = userInput.next();
				}
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

				while (!answer.equals("yes") && !answer.equals("no")) {
					cli.showErrorMsg();
					cli.showExitQuestionMsg();
					answer = userInput.next();
				}
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
		} catch (NumberFormatException e) {
			cli.showErrorMsg();
			CalcFlow(pacecalc, cli);
		} catch (InputMismatchException e) {
			cli.showErrorMsg();
			CalcFlow(pacecalc, cli);
		}
		userInput.close();
	}

	public void CalcFlow(PaceCalc pacecalc, PaceCalcUI ui) {

		this.ui = ui;
		this.pacecalc = pacecalc;

		this.ui.addCalcListener(new Calculate());
		this.ui.addExitListener(new Exit());
	}

	class Calculate implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int timeInt;
			int distanceInt;
			int paceInt;
			String timeStr;
			String distanceStr;
			String paceStr;
			Parser parser = new Parser();
			try {
				switch (ui.getCalcSelection()) {
				case 1:
					timeStr = ui.getTime();
					distanceStr = ui.getDistance();
					timeInt = parser.timeStringToInt(timeStr);
					distanceInt = parser.distanceStringToInt(distanceStr);
					if (timeInt < 0 || distanceInt < 0) {
						ui.showErrorMessage();
					} else {
						pacecalc.setDistance(distanceInt);
						pacecalc.setTime(timeInt);
						paceInt = pacecalc.calcPace();
						paceStr = parser.parseFromPace(paceInt);
						ui.setPace(paceStr);
					}
					break;
				case 2:
					paceStr = ui.getPace();
					distanceStr = ui.getDistance();
					paceInt = parser.paceStringToInt(paceStr);
					distanceInt = parser.distanceStringToInt(distanceStr);
					if (paceInt < 0 || distanceInt < 0) {
						ui.showErrorMessage();
					} else {
						pacecalc.setDistance(distanceInt);
						pacecalc.setPace(paceInt);
						timeInt = pacecalc.calcTime();
						timeStr = parser.parseFromTime(timeInt);
						ui.setTime(timeStr);
					}
					break;
				case 3:
					paceStr = ui.getPace();
					timeStr = ui.getTime();
					paceInt = parser.paceStringToInt(paceStr);
					timeInt = parser.timeStringToInt(timeStr);
					if (paceInt < 0 || timeInt < 0) {
						ui.showErrorMessage();
					} else {
						pacecalc.setTime(timeInt);
						pacecalc.setPace(paceInt);
						distanceInt = pacecalc.calcDistance();
						distanceStr = parser.parseFromDistance(distanceInt);
						ui.setDistance(distanceStr);

					}
					break;
				}
			} catch (Exception error) {
				ui.showErrorMessage();
			}

		}

	}

	class Exit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int userExit = ui.showExitMessage();

			if (userExit == 0) {
				System.exit(0);
			}

		}

	}

}
