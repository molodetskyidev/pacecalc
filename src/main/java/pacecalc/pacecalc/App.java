package pacecalc.pacecalc;

public class App

{
	public static void main(String[] args) {
		// test commit and push
		try {
			if (args[0].equals("-cli")) {
				PaceCalcController pcController = new PaceCalcController();
				CLIuserInterface cli = new CLIuserInterface();
				PaceCalc pacecalc = new PaceCalc();
				pcController.CalcFlow(pacecalc, cli);
			}

			else {
				PaceCalcController pcController = new PaceCalcController();
				PaceCalcUI ui = new PaceCalcUI();
				PaceCalc pacecalc = new PaceCalc();
				pcController.CalcFlow(pacecalc, ui);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			PaceCalcController pcController = new PaceCalcController();
			PaceCalcUI ui = new PaceCalcUI();
			PaceCalc pacecalc = new PaceCalc();
			pcController.CalcFlow(pacecalc, ui);
		}

	}
}
