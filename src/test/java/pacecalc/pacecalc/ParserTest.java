package pacecalc.pacecalc;

import org.testng.annotations.Test;

import junit.framework.Assert;
import util.Parser;

public class ParserTest {
	@Test
	  public void testParseFunctions(){
		  PaceCalc mycalc =new PaceCalc();
		  Parser parser=new Parser();
	     
	//***** distance parsing *****

	//only kilometers
	     
		  mycalc.setDistance(2000);
		  int distance = mycalc.getDistance();
		  Assert.assertEquals("Wrong distance! ", 2000, distance);
		  String parseDistance=parser.parseFromDistance(distance);
		  Assert.assertEquals("Test for only kilometers: Wrong parse distance! ", "2.0", parseDistance);
		  
		       //kilometers with meters
		  
		  mycalc.setDistance(13430);
		  distance = mycalc.getDistance();
		  parseDistance=parser.parseFromDistance(distance);
		  Assert.assertEquals("Test for kilometers with meters: Wrong parse distance! ", "13.430", parseDistance);
		  
		       //only meters
		  
		  mycalc.setDistance(31);
		  distance = mycalc.getDistance();
		  parseDistance=parser.parseFromDistance(distance);
		  Assert.assertEquals("Test for only meters: Wrong parse distance! ", "0.031", parseDistance);
		  
		  //only 1 meter
		  
		  mycalc.setDistance(1);
		  distance = mycalc.getDistance();
		  parseDistance=parser.parseFromDistance(distance);
		  Assert.assertEquals("Test for 1 meter: Wrong parse distance! ", "0.001", parseDistance);
		  
		  //zero value
		  
		  mycalc.setDistance(0);
		  distance = mycalc.getDistance();
		  parseDistance=parser.parseFromDistance(distance);
		  Assert.assertEquals("Test for zero distance: Wrong parse distance! ", "0.0", parseDistance);
		  
		  
		  
		  //***** time parsing *****
		  
		  // only hours
		  
		  mycalc.setTime(3600);
		  int time = mycalc.getTime();
		  Assert.assertEquals("Wrong time! ", 3600, time);
		  String parseTime=parser.parseFromTime(time);
		  Assert.assertEquals("Test for only hours: Wrong parse time! ", "01:00:00", parseTime);
		  
		  //hours:minutes:seconds
		  
		  mycalc.setTime(3663);
		  time = mycalc.getTime();
		  parseTime=parser.parseFromTime(time);
		  Assert.assertEquals("Test for hours:minutes:seconds: Wrong parse time! ", "01:01:03", parseTime);
		  
		  // only minutes
		  
		  mycalc.setTime(60);
		  time = mycalc.getTime();
		  parseTime=parser.parseFromTime(time);
		  Assert.assertEquals("Test for only minutes: Wrong parse time! ", "00:01:00", parseTime);
		  
		  //only seconds
		  
		  mycalc.setTime(4);
		  time = mycalc.getTime();
		  parseTime=parser.parseFromTime(time);
		  Assert.assertEquals("Test for only seconds: Wrong parse time! ", "00:00:04", parseTime);
		  
		  //none time
		  
		  mycalc.setTime(0);
		  time = mycalc.getTime();
		  parseTime=parser.parseFromTime(time);
		  Assert.assertEquals("Test for only seconds: Wrong parse time! ", "00:00:00", parseTime);
		  
		  
		  
		  //***** pace parsing ****
		  
		  // only minutes
		  
		  mycalc.setPace(360);
		  int pace =mycalc.getPace();
		  Assert.assertEquals("Wrong pace! ", 360, pace);
		  String parsePace=parser.parseFromPace(pace);
		  Assert.assertEquals("Test for only minutes: Wrong parse pace! ", "06:00", parsePace);
		  
		  // minutes and seconds
		  
		  mycalc.setPace(382);
		  pace =mycalc.getPace();
		  parsePace=parser.parseFromPace(pace);
		  Assert.assertEquals("Test for minutes and seconds: Wrong parse pace! ", "06:22", parsePace);
		  
		  // only seconds
		  
		  mycalc.setPace(9);
		  pace =mycalc.getPace();
		  parsePace=parser.parseFromPace(pace);
		  Assert.assertEquals("Test for only seconds: Wrong parse pace! ", "00:09", parsePace);
		  
	  // none pace
		  
		  mycalc.setPace(0);
		  pace =mycalc.getPace();
		  parsePace=parser.parseFromPace(pace);
		  Assert.assertEquals("Test for only seconds: Wrong parse pace! ", "00:00", parsePace);
		  
		  
	  // very big pace
		  
		  mycalc.setPace(360000);
		  pace =mycalc.getPace();
		  parsePace=parser.parseFromPace(pace);
		  Assert.assertEquals("Test for very bit pace: Wrong parse pace! ", "100:00:00", parsePace);
		  
	  //***** speed parsing *****	  
		  
	      // only km
		  
		  mycalc.setSpeed(10.0);
		  double speed=mycalc.getSpeed();	  
		  Assert.assertEquals("Wrong speed! ", 10.0, speed);
		  String parseSpeed=parser.parseFromSpeed(speed);
		  Assert.assertEquals("Test for only km: Wrong parse speed! ", "10.0", parseSpeed);
		  
		// km.m
		  
			  mycalc.setSpeed(10.05);
			  speed=mycalc.getSpeed();	 
			  parseSpeed=parser.parseFromSpeed(speed);
			  Assert.assertEquals("Test for km.m: Wrong parse speed! ", "10.05", parseSpeed);
		
	   // only m  
			
			  mycalc.setSpeed(0.05);
			  speed=mycalc.getSpeed();	  
			  parseSpeed=parser.parseFromSpeed(speed);
			  Assert.assertEquals("Test for only m: Wrong parse speed! ", "0.05", parseSpeed);
			  
	   // none speed  
				
			  mycalc.setSpeed(0.0);
			  speed=mycalc.getSpeed();	  
			  parseSpeed=parser.parseFromSpeed(speed);
			  Assert.assertEquals("Test for none speed: Wrong parse speed! ", "0.0", parseSpeed);
	  }
}