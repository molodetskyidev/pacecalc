package pacecalc.pacecalc;
import util.DistanceConvertor;
//import util.Parser;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DistanceConvertorTest {
	
  @Test
  public void convertKMtoMileTest() {
	  int distanceKm;
	  String distanceMile;
	  DistanceConvertor convertor =new DistanceConvertor();
	  distanceKm=10000;
	  distanceMile=convertor.convertKmToMile(distanceKm);
	  Assert.assertEquals("Test converting usual distance to mile", "6.214", distanceMile);
  }
  
  @Test
  public void convertMileToKmTest() {
	  int distanceKm;
	  String distanceMile;
	  distanceMile="6.214";
	  DistanceConvertor convertor =new DistanceConvertor(); 
	  distanceKm=convertor.convertMileToKm(distanceMile);
	  Assert.assertEquals("Test converting usual distance to mile", 9999, distanceKm);
  }
}
