package pacecalc.pacecalc;

import org.testng.annotations.Test;
import org.testng.asserts.*;

import junit.framework.Assert;

public class PaceCalcTest {
  @Test
  public void test() {
	  PaceCalc mycalc =new PaceCalc();
	  mycalc.setDistance(2000);
	  int distance = mycalc.getDistance();
	  Assert.assertEquals("Wrong distance! ", 2000, distance);
	  mycalc.setTime(3600);
	  int time = mycalc.getTime();
	  Assert.assertEquals("Wrong time! ", 3600, time);
	  mycalc.setPace(360);
	  int pace =mycalc.getPace();
	  Assert.assertEquals("Wrong pace! ", 360, pace);
      mycalc.setSpeed(5.34);
	  double speed=mycalc.getSpeed();	  
	  Assert.assertEquals("Wrong speed! ", 5.34, speed);
	  
  }
}
