package gr.um.uniquemoments;

import gr.um.database.ControllerCalendar;
import gr.um.entities.Event;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityCalendar extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_calendar);
		ControllerCalendar cal = new ControllerCalendar();
		/*
		 * Enarksh callendar mh ylopoihshmo
		 */
		cal.showingCalendar();
		/*
		 * Callendar Event test
		 */
		Event testEvent = new Event("Giorgos", "13/13/13","0303","Perigrafh");
		cal.addEvent(testEvent);
		cal.deleteEvent(testEvent);
		cal.editEvent(testEvent);
		cal.calendarStarted();
		cal.getDetails();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calendar, menu);
		return true;
	}

}