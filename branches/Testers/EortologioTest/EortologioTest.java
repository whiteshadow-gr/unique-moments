/**
 * 
 */
package eortologio;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefanos
 *
 */
public class EortologioTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {			
	}

	@Test
	public void test() {
		String actvalue=null;  //Initializes the actual values
		String expvalue=null;  //Initializes the expected values
		
		//----Counts the days between 19th of March 2013 and today----//
		Calendar date;  
		date.set(2013,Calendar.MARCH,19);  
		  int daysBetween = 1;  
		  while (date.before(Calendar.getInstance())) {  
		    date.add(Calendar.DAY_OF_MONTH, 1);  
		    daysBetween++; 
		}
		  
		//----- Gaining access on "eortes" text file---- //
		FileInputStream fs= new FileInputStream("eortes.txt");  
		BufferedReader br = new BufferedReader(new InputStreamReader(fs)); 
		
		// ---- Accessing the line that the expected feast for today is saved---///
		for(int i = 0; i < daysBetween; ++i) 
		br.readLine();
		expvalue= br.readLine(); //saves the value into the expected value variable
		actvalue=rssreader.parse(); //saving the actual value into the equivalent variable
		
		assertEquals (actvalue,expvalue);
	}

}
