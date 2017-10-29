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
  public void testParseFunctions(){
	  PaceCalc mycalc =new PaceCalc();
     
//***** distance parsing *****

//only kilometers
     
	  mycalc.setDistance(2000);
	  int distance = mycalc.getDistance();
	  Assert.assertEquals("Wrong distance! ", 2000, distance);
	  String parseDistance=mycalc.parseFromDistance(distance);
	  Assert.assertEquals("Test for only kilometers: Wrong parse distance! ", "2.0", parseDistance);
	  
	       //kilometers with meters
	  
	  mycalc.setDistance(13430);
	  distance = mycalc.getDistance();
	  parseDistance=mycalc.parseFromDistance(distance);
	  Assert.assertEquals("Test for kilometers with meters: Wrong parse distance! ", "13.430", parseDistance);
	  
	       //only meters
	  
	  mycalc.setDistance(31);
	  distance = mycalc.getDistance();
	  parseDistance=mycalc.parseFromDistance(distance);
	  Assert.assertEquals("Test for only meters: Wrong parse distance! ", "0.031", parseDistance);
	  
	  //only 1 meter
	  
	  mycalc.setDistance(1);
	  distance = mycalc.getDistance();
	  parseDistance=mycalc.parseFromDistance(distance);
	  Assert.assertEquals("Test for 1 meter: Wrong parse distance! ", "0.001", parseDistance);
	  
	  //zero value
	  
	  mycalc.setDistance(0);
	  distance = mycalc.getDistance();
	  parseDistance=mycalc.parseFromDistance(distance);
	  Assert.assertEquals("Test for zero distance: Wrong parse distance! ", "0.0", parseDistance);
	  
	  
	  
	  //***** time parsing *****
	  
	  // only hours
	  
	  mycalc.setTime(3600);
	  int time = mycalc.getTime();
	  Assert.assertEquals("Wrong time! ", 3600, time);
	  String parseTime=mycalc.parseFromTime(time);
	  Assert.assertEquals("Test for only hours: Wrong parse time! ", "01:00:00", parseTime);
	  
	  //hours:minutes:seconds
	  
	  mycalc.setTime(3663);
	  time = mycalc.getTime();
	  parseTime=mycalc.parseFromTime(time);
	  Assert.assertEquals("Test for hours:minutes:seconds: Wrong parse time! ", "01:01:03", parseTime);
	  
	  // only minutes
	  
	  mycalc.setTime(60);
	  time = mycalc.getTime();
	  parseTime=mycalc.parseFromTime(time);
	  Assert.assertEquals("Test for only minutes: Wrong parse time! ", "00:01:00", parseTime);
	  
	  //only seconds
	  
	  mycalc.setTime(4);
	  time = mycalc.getTime();
	  parseTime=mycalc.parseFromTime(time);
	  Assert.assertEquals("Test for only seconds: Wrong parse time! ", "00:00:04", parseTime);
	  
	  //none time
	  
	  mycalc.setTime(0);
	  time = mycalc.getTime();
	  parseTime=mycalc.parseFromTime(time);
	  Assert.assertEquals("Test for only seconds: Wrong parse time! ", "00:00:00", parseTime);
	  
	  
	  
	  //***** pace parsing ****
	  
	  // only minutes
	  
	  mycalc.setPace(360);
	  int pace =mycalc.getPace();
	  Assert.assertEquals("Wrong pace! ", 360, pace);
	  String parsePace=mycalc.parseFromPace(pace);
	  Assert.assertEquals("Test for only minutes: Wrong parse pace! ", "06:00", parsePace);
	  
	  // minutes and seconds
	  
	  mycalc.setPace(382);
	  pace =mycalc.getPace();
	  parsePace=mycalc.parseFromPace(pace);
	  Assert.assertEquals("Test for minutes and seconds: Wrong parse pace! ", "06:22", parsePace);
	  
	  // only seconds
	  
	  mycalc.setPace(9);
	  pace =mycalc.getPace();
	  parsePace=mycalc.parseFromPace(pace);
	  Assert.assertEquals("Test for only seconds: Wrong parse pace! ", "00:09", parsePace);
	  
  // none pace
	  
	  mycalc.setPace(0);
	  pace =mycalc.getPace();
	  parsePace=mycalc.parseFromPace(pace);
	  Assert.assertEquals("Test for only seconds: Wrong parse pace! ", "00:00", parsePace);
	  
	  
  // very big pace
	  
	  mycalc.setPace(360000);
	  pace =mycalc.getPace();
	  parsePace=mycalc.parseFromPace(pace);
	  Assert.assertEquals("Test for very bit pace: Wrong parse pace! ", "100:00:00", parsePace);
	  
  //***** speed parsing *****	  
	  
      // only km
	  
	  mycalc.setSpeed(10.0);
	  double speed=mycalc.getSpeed();	  
	  Assert.assertEquals("Wrong speed! ", 10.0, speed);
	  String parseSpeed=mycalc.parseFromSpeed(speed);
	  Assert.assertEquals("Test for only km: Wrong parse speed! ", "10.0", parseSpeed);
	  
	// km.m
	  
		  mycalc.setSpeed(10.05);
		  speed=mycalc.getSpeed();	 
		  parseSpeed=mycalc.parseFromSpeed(speed);
		  Assert.assertEquals("Test for km.m: Wrong parse speed! ", "10.05", parseSpeed);
	
   // only m  
		
		  mycalc.setSpeed(0.05);
		  speed=mycalc.getSpeed();	  
		  parseSpeed=mycalc.parseFromSpeed(speed);
		  Assert.assertEquals("Test for only m: Wrong parse speed! ", "0.05", parseSpeed);
		  
   // none speed  
			
		  mycalc.setSpeed(0.0);
		  speed=mycalc.getSpeed();	  
		  parseSpeed=mycalc.parseFromSpeed(speed);
		  Assert.assertEquals("Test for none speed: Wrong parse speed! ", "0.0", parseSpeed);
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
