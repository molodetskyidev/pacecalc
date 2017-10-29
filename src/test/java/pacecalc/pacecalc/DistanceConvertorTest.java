package pacecalc.pacecalc;
import util.KmToMileConvertor;
//import util.Parser;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DistanceConvertorTest {
	
  @Test
  public void convertKMtoMileTest() {
	  int distanceKm;
	  String distanceMile;
	  KmToMileConvertor convertor =new KmToMileConvertor();
	  distanceKm=10000;
	  distanceMile=convertor.convertKmToMile(distanceKm);
	  Assert.assertEquals("Test converting usual distance to mile", "6.214", distanceMile);
  }
  
  @Test
  public void convertMileToKmTest() {
	  int distanceKm;
	  String distanceMile;
	  distanceMile="6.214";
	  KmToMileConvertor convertor =new KmToMileConvertor(); 
	  distanceKm=convertor.convertMileToKm(distanceMile);
	  Assert.assertEquals("Test converting usual distance to mile", 9999, distanceKm);
  }
}
