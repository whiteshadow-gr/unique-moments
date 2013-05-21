package gr.um.calendar;

import gr.um.entities.Event;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface InterfaceCalendar 
{
	public boolean deleteEvent(Event myEvent);
	public boolean editEvent(Event myEvent);
	public boolean appStarted();
	public boolean showingCalendar();
	public boolean addEvent(Event myEvent);
	public boolean calendarStarted();
	public boolean getDetails();
	//public boolean isColourfoul(date);
	//public string getNames(date);
	//public string getType(date, Contact);
	//public Vector <Event> searchEvent(String myDate); ekremei dokimastikh ylopoihsh
	//public int getPosition(int_metablhth);
}
