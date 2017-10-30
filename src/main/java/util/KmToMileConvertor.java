package util;
import java.math.RoundingMode;
public class KmToMileConvertor {
	
	public String convertKmToMile(int distanceKm){
		String distanceMile;
		double distanceMileDouble;
		distanceMileDouble=Math.floor(((double)(distanceKm)/1000)*621.4)/1000.0;
		distanceMile=Double.toString(distanceMileDouble);
		return distanceMile;
	}
	
	public int convertMileToKm(String distanceMile){
		int distanceKm;
		distanceKm=(int)Math.ceil(Double.parseDouble(distanceMile)*1609.0);
		return distanceKm;
	}

	public String convertSpeedKmhToMpH(double speedKm){
		String speedMpH;
		speedMpH=Double.toString(Math.ceil(speedKm*621.4)/1000.0);
		
		return speedMpH;
	}
	
	public double convertSpeedMpHtoKmh(String speedMpH){
		
		double speedKm;
		speedKm=Math.ceil(Double.parseDouble(speedMpH)*160.9)/100.0;
		return speedKm;
	}
}
