package pacecalc.pacecalc;

import org.testng.annotations.*;
import org.testng.asserts.*;

import junit.framework.Assert;

public class PaceCalcTest {
	
  
  @Test
  public void testSetGet() {
	  
	  // check default constructor
	  
	  PaceCalc mycalc =new PaceCalc();
	 
	  // set and get for distance
	  
	  mycalc.setDistance(2000);
	  int distance = mycalc.getDistance();
	  Assert.assertEquals("Wrong distance! ", 2000, distance);
	
	  // set and get for time
	  
	  mycalc.setTime(3600);
	  int time = mycalc.getTime();
	  Assert.assertEquals("Wrong time! ", 3600, time);
	 
	  //set and get for pace
	  
	  mycalc.setPace(360);
	  int pace =mycalc.getPace();
	  Assert.assertEquals("Wrong pace! ", 360, pace);
	 
	 // set and get for speed
	  
     
	  mycalc.setSpeed(10.0);
	  double speed=mycalc.getSpeed();	  
	  Assert.assertEquals("Wrong speed! ", 10.0, speed);
	  
	  //check constructor PaceCalc(int pace, int distance, int time, double speed)
	  PaceCalc mycalcSecondConst =new PaceCalc(276,30034,42781,12.7);
	  
	  //check distance which is set by constructor
	  
	  distance = mycalcSecondConst.getDistance();
	  Assert.assertEquals("Wrong distance! ", 30034, distance);
	  
	  //check time which is set by constructor
	  
	  time = mycalcSecondConst.getTime();
	  Assert.assertEquals("Wrong time! ", 42781, time);
	  
	//check time which is set by constructor
	  
	  pace =mycalcSecondConst.getPace();
	  Assert.assertEquals("Wrong pace! ", 276, pace);
	  
	//check speed which is set by constructor
	  
	  speed=mycalcSecondConst.getSpeed();	  
	  Assert.assertEquals("Wrong speed! ", 12.7, speed);
	  
  }
  
  
  @Test
  public void testCalcPace(){
	
	  PaceCalc mycalc =new PaceCalc();
	  int pace;
	  
	  //simple usual distance and time
	  pace=mycalc.calcPace(10000, 3600);
	  Assert.assertEquals("Test simple usual distance and time Wrong pace! ", 360 , pace);
	  //small distance and big time
	   pace=mycalc.calcPace(10, 3600);
	  Assert.assertEquals("Test distance small, long time Wrong pace! ", 360000 , pace);
	  //halfmarathon distance and 1 hr time
	  pace=mycalc.calcPace(21097, 3600);
	  Assert.assertEquals("Test halfmarathon by 1 hour Wrong pace! ", 170 , pace);
	  //small time and big distance
	  pace=mycalc.calcPace(21097, 1);
	  Assert.assertEquals("Test halfmarathon by 1 hour Wrong pace! ", 0 , pace);
	  
	  
  }
}
