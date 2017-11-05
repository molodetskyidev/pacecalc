package pacecalc.pacecalc;

public class App

{
	public static void main(String[] args) {
		PaceCalcController pcController=new PaceCalcController();
		PaceCalc pacecalc=new PaceCalc();
		pcController.CalcFlow(pacecalc);

	}
}
