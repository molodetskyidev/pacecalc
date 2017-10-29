package pacecalc.pacecalc;



import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 

{  
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	@BeforeTest
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@AfterTest
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	} 
	@Test

    
    public void testApp()
    
    {
		App newapp=new App();
		newapp.main(null);
      assertEquals(outContent.toString(),"Hello World!");
    }
}
