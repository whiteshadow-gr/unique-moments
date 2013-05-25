package gr.um.uniquemoments.test;

import gr.um.eortologio.FindEventsController;
import gr.um.uniquemoments.ActivityDailyEvents;
import android.test.InstrumentationTestCase;

public class FindEventsControllerTest extends InstrumentationTestCase 
{

	ActivityDailyEvents actDaily;
	
	public FindEventsControllerTest() 
	{
		super();
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		actDaily = new ActivityDailyEvents();
	}
	
	public void testGetImportantNames()
	{
		String actual = FindEventsController.getImportantNames(actDaily);
		
		String expected = "1";
		
		assertEquals(expected, actual);
	}

}
