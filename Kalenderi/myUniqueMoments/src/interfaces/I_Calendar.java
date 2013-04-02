package interfaces;

import java.util.Vector;

import entities.Event;

public interface I_Calendar 
{
	public abstract boolean deleteEvent(Event myEvent);
	public abstract boolean editEvent(Event myEvent);
	//public abstract Vector <Event> searchEvent(String myDate); ekremei dokimastikh ylopoihsh
	public abstract boolean appStarted();
	public abstract boolean showingCalendar();
	public abstract boolean addEvent(Event myEvent);
	public abstract boolean calendarStarted();
	//public abstract int getPosition(int_metablhth);
	//public abstract boolean isColourfoul(date);
	public abstract boolean getDetails();
	//public abstract string getNames(date);
	//public abstract string getType(date, Contact);
}
