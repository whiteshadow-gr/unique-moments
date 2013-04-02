package com.example.myuniquemoments;

import entities.Event;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ActivityCalendar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		/*
		 * Enarksh callendar mh ylopoihshmo
		 */
		showingCalendar();
		/*
		 * Callendar Event test
		 */
		Event testObject=new Event("Giorgos", "13/13/13","0303","Perigrafh");
		addEvent(testObject);
		deleteEvent(testObject);
		editEvent(testObject);
		calendarStarted();
		getDetails();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calendar, menu);
		return true;
	}
	/*
	 * Enarksh callendar mh ylopoihshmo
	 */
	boolean showingCalendar()
	{
		return false;
	}
	/*
	 * Prosthhkh Event test
	 */
	boolean addEvent(Event myEvent)
	{
		return false;
	}
	/*
	 * delete event mh ylopoihshmo
	 */
	boolean deleteEvent(Event myEvent)
	{
		return false;
	}
	/*
	 * edit event mh ylopoihshmo
	 */
	boolean editEvent(Event myEvent)
	{
		return false;
	}
	boolean calendarStarted(){
		return false;
	}
	boolean getDetails(){
		return false;
	}
	/*<Event> searchEvent(String myDate)
	{
		Event testObject2=new Event("Nikos", "14/14/14","0404","PerigrafhPerigrafh"); 
		return testObject2;
	}*/
}