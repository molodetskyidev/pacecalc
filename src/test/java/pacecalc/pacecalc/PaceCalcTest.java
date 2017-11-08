package pacecalc.pacecalc;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class PaceCalcTest {

	@Test
	public void testSetGet() {

		// check default constructor

		PaceCalc mycalc = new PaceCalc();

		// set and get for distance

		mycalc.setDistance(2000);
		int distance = mycalc.getDistance();
		Assert.assertEquals("Wrong distance! ", 2000, distance);

		// set and get for time

		mycalc.setTime(3600);
		int time = mycalc.getTime();
		Assert.assertEquals("Wrong time! ", 3600, time);

		// set and get for pace

		mycalc.setPace(360);
		int pace = mycalc.getPace();
		Assert.assertEquals("Wrong pace! ", 360, pace);

		// set and get for speed

		mycalc.setSpeed(10.0);
		double speed = mycalc.getSpeed();
		Assert.assertEquals("Wrong speed! ", 10.0, speed);

		// check constructor PaceCalc(int pace, int distance, int time, double
		// speed)
		PaceCalc mycalcSecondConst = new PaceCalc(276, 30034, 42781, 12.7);

		// check distance which is set by constructor

		distance = mycalcSecondConst.getDistance();
		Assert.assertEquals("Wrong distance! ", 30034, distance);

		// check time which is set by constructor

		time = mycalcSecondConst.getTime();
		Assert.assertEquals("Wrong time! ", 42781, time);

		// check time which is set by constructor

		pace = mycalcSecondConst.getPace();
		Assert.assertEquals("Wrong pace! ", 276, pace);

		// check speed which is set by constructor

		speed = mycalcSecondConst.getSpeed();
		Assert.assertEquals("Wrong speed! ", 12.7, speed);

	}

	@Test
	public void testCalcPace() {

		PaceCalc mycalc = new PaceCalc();
		int pace;

		// simple usual distance and time
		mycalc.setDistance(10000);
		mycalc.setTime(3600);
		pace = mycalc.calcPace();
		Assert.assertEquals("Test simple usual distance and time Wrong pace! ", 360, pace);
		// small distance and big time
		mycalc.setDistance(10);
		mycalc.setTime(3600);
		pace = mycalc.calcPace();
		Assert.assertEquals("Test distance small, long time Wrong pace! ", 360000, pace);
		// halfmarathon distance and 1 hr time
		mycalc.setDistance(21097);
		mycalc.setTime(3600);
		pace = mycalc.calcPace();
		Assert.assertEquals("Test halfmarathon by 1 hour Wrong pace! ", 170, pace);
		mycalc.setDistance(21097);
		mycalc.setTime(1);
		// small time and big distance
		pace = mycalc.calcPace();
		Assert.assertEquals("Test halfmarathon by 1 hour Wrong pace! ", 0, pace);

	}

	@Test
	public void testCalcDistance() {

		PaceCalc mycalc = new PaceCalc();
		int distance;

		// simple usual pace and time
		mycalc.setTime(3600);
		mycalc.setPace(360);
		distance = mycalc.calcDistance();
		Assert.assertEquals("Test simple usual pace and time Wrong distance! ", 10000, distance);

		// small pace and big time
		mycalc.setTime(3600);
		mycalc.setPace(10);
		distance = mycalc.calcDistance();
		Assert.assertEquals("Test pace small, long time Wrong distance! ", 360000, distance);

		// halfmarathon pace and 1:30 hr time
		mycalc.setTime(5401);
		mycalc.setPace(256);
		distance = mycalc.calcDistance();
		Assert.assertEquals("Test halfmarathon pace by 1:30 hour Wrong distance! ", 21097, distance);
		// small time and big pace
		mycalc.setTime(10);
		mycalc.setPace(3599);
		distance = mycalc.calcDistance();
		Assert.assertEquals("Test small time and big pace Wrong distance! ", 2, distance);

	}

	@Test
	public void testCalcTime() {

		PaceCalc mycalc = new PaceCalc();
		int time;

		// simple usual pace and distance
		mycalc.setPace(360);
		mycalc.setDistance(10000);

		time = mycalc.calcTime();
		Assert.assertEquals("Test simple usual distance and time Wrong time! ", 3600, time);

		// small pace and big distance
		mycalc.setPace(10);
		mycalc.setDistance(42195);
		time = mycalc.calcTime();
		Assert.assertEquals("Test distance small, long time Wrong time! ", 421, time);

		// halfmarathon distance and 5min/km pace
		mycalc.setPace(300);
		mycalc.setDistance(21097);
		time = mycalc.calcTime();
		Assert.assertEquals("Test halfmarathon distance and 5min/km pace Wrong time! ", 6329, time);

		// small distance and big pace
		mycalc.setPace(36000);
		mycalc.setDistance(10);
		time = mycalc.calcTime();
		Assert.assertEquals("Test halfmarathon by 1 hour Wrong time! ", 360, time);

	}

	@Test
	public void testCalcSpeed() {

		PaceCalc mycalc = new PaceCalc();
		double speed;

		// simple usual pace and time

		speed = mycalc.calcSpeed(360);
		Assert.assertEquals("Test simple usual pace Wrong speed! ", 10.0, speed);

		// small pace and big time

		speed = mycalc.calcSpeed(10);
		Assert.assertEquals("Test distance small pace Wrong speed! ", 360.0, speed);

		// halfmarathon 5min/km pace

		speed = mycalc.calcSpeed(300);
		Assert.assertEquals("Test halfmarathon  5min/km pace Wrong speed! ", 12.0, speed);

		// big pace

		speed = mycalc.calcSpeed(36000);
		Assert.assertEquals("Test halfmarathon by 1 hour Wrong speed! ", 0.1, speed);

	}
}
