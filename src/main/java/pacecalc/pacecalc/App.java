package pacecalc.pacecalc;


public class App 

{
    public static void main( String[] args )
    {
    	String lineseparator=System.getProperty("line.separator");
    	String entryMsg ="************* Welcome to Pace Calculator! *************"+lineseparator+lineseparator+"Please select what you would like to do:"+lineseparator +
    			"* If you would like to calculate pace based on time and distance enter 1;"+lineseparator +
    			"* If you would like to time based on pace and distance enter 2;"+lineseparator +
    			"* If you would like to distance based on time and pace enter 3;"+lineseparator +
    			"* If you would like to exit enter 0;"+lineseparator +lineseparator +
    			"Enter your choice here:";
    	
    	
        System.out.println(entryMsg);
        
    }
}
