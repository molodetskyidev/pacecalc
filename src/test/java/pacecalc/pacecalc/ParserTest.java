package pacecalc.pacecalc;

import org.testng.annotations.Test;

import junit.framework.Assert;
import util.Parser;

public class ParserTest {
	@Test
	public void testParseFunctions() {
		PaceCalc mycalc = new PaceCalc();
		Parser parser = new Parser();

		// ***** distance parsing *****

		// only kilometers

		mycalc.setDistance(2000);
		int distance = mycalc.getDistance();
		Assert.assertEquals("Wrong distance! ", 2000, distance);
		String parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals("Test for only kilometers: Wrong parse distance! ", "2.0", parseDistance);

		// kilometers with meters

		mycalc.setDistance(13430);
		distance = mycalc.getDistance();
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals("Test for kilometers with meters: Wrong parse distance! ", "13.430", parseDistance);

		// only meters

		mycalc.setDistance(31);
		distance = mycalc.getDistance();
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals("Test for only meters: Wrong parse distance! ", "0.031", parseDistance);

		// only 1 meter

		mycalc.setDistance(1);
		distance = mycalc.getDistance();
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals("Test for 1 meter: Wrong parse distance! ", "0.001", parseDistance);

		// zero value

		mycalc.setDistance(0);
		distance = mycalc.getDistance();
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals("Test for zero distance: Wrong parse distance! ", "0.0", parseDistance);

		// ***** time parsing *****

		// only hours

		mycalc.setTime(3600);
		int time = mycalc.getTime();
		Assert.assertEquals("Wrong time! ", 3600, time);
		String parseTime = parser.parseFromTime(time);
		Assert.assertEquals("Test for only hours: Wrong parse time! ", "01:00:00", parseTime);

		// hours:minutes:seconds

		mycalc.setTime(3663);
		time = mycalc.getTime();
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals("Test for hours:minutes:seconds: Wrong parse time! ", "01:01:03", parseTime);

		// only minutes

		mycalc.setTime(60);
		time = mycalc.getTime();
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals("Test for only minutes: Wrong parse time! ", "00:01:00", parseTime);

		// only seconds

		mycalc.setTime(4);
		time = mycalc.getTime();
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals("Test for only seconds: Wrong parse time! ", "00:00:04", parseTime);

		// none time

		mycalc.setTime(0);
		time = mycalc.getTime();
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals("Test for only seconds: Wrong parse time! ", "00:00:00", parseTime);

		// ***** pace parsing ****

		// only minutes

		mycalc.setPace(360);
		int pace = mycalc.getPace();
		Assert.assertEquals("Wrong pace! ", 360, pace);
		String parsePace = parser.parseFromPace(pace);
		Assert.assertEquals("Test for only minutes: Wrong parse pace! ", "06:00", parsePace);

		// minutes and seconds

		mycalc.setPace(382);
		pace = mycalc.getPace();
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals("Test for minutes and seconds: Wrong parse pace! ", "06:22", parsePace);

		// only seconds

		mycalc.setPace(9);
		pace = mycalc.getPace();
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals("Test for only seconds: Wrong parse pace! ", "00:09", parsePace);

		// none pace

		mycalc.setPace(0);
		pace = mycalc.getPace();
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals("Test for only seconds: Wrong parse pace! ", "00:00", parsePace);

		// very big pace

		mycalc.setPace(360000);
		pace = mycalc.getPace();
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals("Test for very bit pace: Wrong parse pace! ", "100:00:00", parsePace);

		//

		// ***** speed parsing *****

		// only km

		mycalc.setSpeed(10.0);
		double speed = mycalc.getSpeed();
		Assert.assertEquals("Wrong speed! ", 10.0, speed);
		String parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals("Test for only km: Wrong parse speed! ", "10.0", parseSpeed);

		// km.m

		mycalc.setSpeed(10.05);
		speed = mycalc.getSpeed();
		parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals("Test for km.m: Wrong parse speed! ", "10.05", parseSpeed);

		// only m

		mycalc.setSpeed(0.05);
		speed = mycalc.getSpeed();
		parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals("Test for only m: Wrong parse speed! ", "0.05", parseSpeed);

		// none speed

		mycalc.setSpeed(0.0);
		speed = mycalc.getSpeed();
		parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals("Test for none speed: Wrong parse speed! ", "0.0", parseSpeed);
	}

	@Test
	public void testTimeParsingStrins() {
		/*
		 * *********** verify time parser
		 */

		Parser parser = new Parser();
		// only hours
		int parseTime = parser.timeStringToInt("03:00:00");
		Assert.assertEquals(10800, parseTime);
		// hours and minutes
		parseTime = parser.timeStringToInt("03:23:00");
		Assert.assertEquals(12180, parseTime);
		// hours and minutes and seconds
		parseTime = parser.timeStringToInt("03:23:45");
		Assert.assertEquals(12225, parseTime);
		// only seconds
		parseTime = parser.timeStringToInt("00:00:45");
		Assert.assertEquals(45, parseTime);
		// only minutes
		parseTime = parser.timeStringToInt("00:23:00");
		Assert.assertEquals(1380, parseTime);
		// minutes and seconds
		parseTime = parser.timeStringToInt("00:23:04");
		Assert.assertEquals(1384, parseTime);
		// hours and seconds
		parseTime = parser.timeStringToInt("03:00:04");
		Assert.assertEquals(10804, parseTime);
		// zero time
		parseTime = parser.timeStringToInt("00:00:00");
		Assert.assertEquals(-1, parseTime);

		// wrong formatting
		parseTime = parser.timeStringToInt("00-00-00");
		Assert.assertEquals(-1, parseTime);

		// non-integer value
		parseTime = parser.timeStringToInt("fl:jdlfksj:00");
		Assert.assertEquals(-1, parseTime);

		// value >60
		parseTime = parser.paceStringToInt("61:102:76");
		Assert.assertEquals(-1, parseTime);

		// negative value
		parseTime = parser.paceStringToInt("-23:-34:-45");
		Assert.assertEquals(-1, parseTime);

		// more values than expected

		parseTime = parser.paceStringToInt("23:34:45:34");
		Assert.assertEquals(-1, parseTime);

	}

	@Test
	public void testPaceParsingStrins() {
		/*
		 * *********** verify pace parser
		 */

		Parser parser = new Parser();

		// minutes and seconds
		int parseTime = parser.paceStringToInt("05:45");
		Assert.assertEquals(345, parseTime);
		// only seconds
		parseTime = parser.paceStringToInt("00:45");
		Assert.assertEquals(45, parseTime);
		// only minutes
		parseTime = parser.paceStringToInt("05:00");
		Assert.assertEquals(300, parseTime);

		// zero time
		parseTime = parser.paceStringToInt("00:00");
		Assert.assertEquals(-1, parseTime);

		// wrong formatting
		parseTime = parser.paceStringToInt("00-00");
		Assert.assertEquals(-1, parseTime);

		// non-integer value
		parseTime = parser.paceStringToInt("fl:jdlfksj");
		Assert.assertEquals(-1, parseTime);

		// value >60
		parseTime = parser.paceStringToInt("61:102");
		Assert.assertEquals(-1, parseTime);

		// negative value
		parseTime = parser.paceStringToInt("-23:-34");
		Assert.assertEquals(-1, parseTime);

		// more values than expected

		parseTime = parser.paceStringToInt("23:34:45");
		Assert.assertEquals(-1, parseTime);

	}

	@Test
	public void testDistanceParsingStrins() {
		/*
		 * *********** verify pace parser
		 */

		Parser parser = new Parser();
		// usual value
		int distance = parser.distanceStringToInt("10000");
		Assert.assertEquals(10000, distance);
		// big value
		distance = parser.distanceStringToInt("1000000");
		Assert.assertEquals(1000000, distance);
		// small value
		distance = parser.distanceStringToInt("1");
		Assert.assertEquals(1, distance);

		// zero value
		distance = parser.distanceStringToInt("0");
		Assert.assertEquals(-1, distance);

		// non-integer value
		distance = parser.distanceStringToInt("marathon");
		Assert.assertEquals(-1, distance);

		// negative value
		distance = parser.distanceStringToInt("-22");
		Assert.assertEquals(-1, distance);

		// double value
		distance = parser.distanceStringToInt("42.195");
		Assert.assertEquals(-1, distance);

		// integer with spaces
		distance = parser.distanceStringToInt("10 000");
		Assert.assertEquals(-1, distance);
	}
}
