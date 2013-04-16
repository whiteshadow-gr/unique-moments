package com.example.uniquemoments;

import java.sql.Date;

import android.R.bool;

//needs to import Event Class file

interface I_Calendar
{
	public bool showCalendar();				//Prints the Calendar at the default GUI
	
	public bool addEvent(event myEvent);		//Adds an event in the calendar
	
	public bool removeEvent(event myEvent);		//Deletes an event from the calendar
	
	public bool editEvent(event myEvent);		//Changes specific attributes of an event
												//in the calendar
												
	public event[] getDailyEvents();		//Returns an array of objects of the "event"
												//class. The events are of the current date
												
	public event[] fetchEvents(Date myDate);	//Returns an array of objects of the "event"
												//class. The events are of the specified date
}