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
}
