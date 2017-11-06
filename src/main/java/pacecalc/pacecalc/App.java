package pacecalc.pacecalc;

public class App

{
	//test push into master
	public static void main(String[] args) {
		PaceCalcController pcController = new PaceCalcController();
		CLIuserInterface cli = new CLIuserInterface();
		PaceCalc pacecalc = new PaceCalc();
		pcController.CalcFlow(pacecalc,cli);

	}
}
