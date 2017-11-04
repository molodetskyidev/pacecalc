package pacecalc.pacecalc;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import junit.framework.Assert;
import util.Events;

public class EventsTest {
	
  @Test
  public void returnDistanceTest() {
	  Events event = new Events();
	  int eventDistance;
	  eventDistance=event.returnDistance("Marathon");
	  Assert.assertEquals("Test marathon distance return. Wrong value!", 42195, eventDistance);
	  
	  eventDistance=event.returnDistance("Halfmarathon");
	  Assert.assertEquals("Test marathon distance return. Wrong value!", 21097, eventDistance);
	  
	  eventDistance=event.returnDistance("10k");
	  Assert.assertEquals("Test marathon distance return. Wrong value!", 10000, eventDistance);
  }
  
}
