package pacecalc.pacecalc;
import util.KmToMileConvertor;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class KmToMileConvertorTest {
	
  @Test
  public void convertKMtoMileTest() {
	  int distanceKm;
	  String distanceMile;
	  KmToMileConvertor convertor =new KmToMileConvertor();
	  
	  //usual distance
	  
	  distanceKm=10000;
	  distanceMile=convertor.convertKmToMile(distanceKm);
	  Assert.assertEquals("Test converting usual distance km to mile", "6.214", distanceMile);
	  
	  //small distance
	  distanceKm=10;
	  distanceMile=convertor.convertKmToMile(distanceKm);
	  Assert.assertEquals("Test converting usual distance km to mile", "0.006", distanceMile);
	  
	  //big distance
	  distanceKm=10000000;
	  distanceMile=convertor.convertKmToMile(distanceKm);
	  Assert.assertEquals("Test converting usual distance km to mile", "6214.0", distanceMile);
	  
  }
  
  @Test
  public void convertMileToKmTest() {
	  int distanceKm;
	  String distanceMile;
	  KmToMileConvertor convertor =new KmToMileConvertor(); 
	  
	  // usual distance 
	  
	  distanceMile="6.214";
	  distanceKm=convertor.convertMileToKm(distanceMile);
	  Assert.assertEquals("Test converting usual distance mile to km", 9999, distanceKm);
	  
	//small distance
	  
	  distanceMile="0.006";
	  distanceKm=convertor.convertMileToKm(distanceMile);
	  Assert.assertEquals("Test converting usual distance mile to km", 10, distanceKm);
	  
   //big distance
	//TODO should think about precise, in this particular case I've lost 1674 m - almost 1 mile
	  
	  distanceMile="6214.0";
	  distanceKm=convertor.convertMileToKm(distanceMile);
	  Assert.assertEquals("Test converting usual distance mile to km", 9998326, distanceKm);
	  
  }
  
  @Test
  
  public void convertSpeedKmToMileTest() {
	  double speedKmH;
	  String speedMpH;
	  KmToMileConvertor convertor =new KmToMileConvertor(); 
	  
	  //usual speed
	  
	  speedKmH=10.0;
	  speedMpH=convertor.convertSpeedKmhToMpH(speedKmH);
	  Assert.assertEquals("Test converting usual speed kmh to mph", "6.214", speedMpH);
	
	  //small speed
	  
	  speedKmH=0.01;
	  speedMpH=convertor.convertSpeedKmhToMpH(speedKmH);
	  Assert.assertEquals("Test converting small speed kmh to mph", "0.007", speedMpH);
	  
	//big speed
		//TODO should think about precise, in this particular case I've lost 1674 m - almost 1 mile
		  
	      speedKmH=10000.0;
	      speedMpH=convertor.convertSpeedKmhToMpH(speedKmH);
		  Assert.assertEquals("Test converting big speed mile to km", "6214.0", speedMpH);
}
  
@Test
  
  public void convertSpeedMphToKmH() {
	  double speedKmH;
	  String speedMpH;
	  KmToMileConvertor convertor =new KmToMileConvertor(); 
	  
	  //usual speed
	  speedMpH="6.214";
	  
	  speedKmH=convertor.convertSpeedMpHtoKmh(speedMpH);
	  Assert.assertEquals("Test converting usual speed mph to kmh", 10.0, speedKmH);
	
	  //small speed
	  
	  speedMpH="0.007";
	  speedKmH=convertor.convertSpeedMpHtoKmh(speedMpH);
	  Assert.assertEquals("Test converting small speed mph to kmh", 0.02, speedKmH);
	 
	//big speed
	
		  
	  speedMpH="6214.0";
	  speedKmH=convertor.convertSpeedMpHtoKmh(speedMpH);
	  Assert.assertEquals("Test converting big speed mph to kmh", 9998.33, speedKmH);
}
}