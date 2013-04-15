package controllers;

import entities.Event;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ControllerCalendar implements InterfaceCalendar 
{

	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Calendar#deleteEvent(entities.Event)
	 * 
	 * This method is called whenever deleting an event is needed
	 * 
	 * Arguments:
	 * Event myEvent = an object of the entities.Event class containing
	 * 				   all the data needed for this method to function 
	 */
	@Override
	public boolean deleteEvent(Event myEvent) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/*
	 * This method is called whenever editing the information related to a 
	 * specific event is needed
	 * 
	 * Arguments:
	 * Event myEvent = an object of the entities.Event class containing
	 * 				   all the data needed for this method to function.
	 * 				   the myEvent.setName() method must be used before
	 * 				   calling this method
	 * 
	 *  It returns true if editing is successful or false otherwise
	 */
	@Override
	public boolean editEvent(Event myEvent) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Calendar#appStarted()
	 * 
	 * This method returns true if the application started normally or false otherwise
	 */
	@Override
	public boolean appStarted() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Calendar#showingCalendar()
	 * 
	 * This method returns true if the calendar is projected successfully to the
	 * default output or false otherwise
	 */
	@Override
	public boolean showingCalendar() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Calendar#addEvent(entities.Event)
	 * 
	 * This method is called whenever adding an event to the database is needed
	 * 
	 * Arguments:
	 * Event myEvent = an object of the Event entity class containing the essential data needed
	 * 				   for this method to function
	 * 
	 * Returns true if insertion is successful or false otherwise
	 */
	@Override
	public boolean addEvent(Event myEvent) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Calendar#calendarStarted()
	 * 
	 * This method returns true if the Calendar process started normally or false otherwise
	 */
	@Override
	public boolean calendarStarted() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDetails() 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
