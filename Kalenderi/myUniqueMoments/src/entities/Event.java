package entities;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class Event 
{
	public int ID;
	public String Name;
	public String Date;
	public String Time;
	public String Description;
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//constructors
	public Event()
	{
		ID = 0;
		Name = "";
		Date = "";
		Time = "";
		Description = "";
	}
	
	public Event(String myName, String myDate, String myTime ,String myDescription)
	{
		Name = myName;
		Date = myDate;
		Time = myTime;
		Description = myDescription;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//get functions
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getDate()
	{
		return Date;
	}
	
	public String getTime()
	{
		return Time;
	}
	
	public String getDescription()
	{
		return Description;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//set functions
	public void setID(int myID)
	{
		ID = myID;
	}
	
	public void setName (String myName)
	{
		Name = myName;
	}
	
	public void setDateTime (String myDate)
	{
		Date = myDate;
	}
	
	public void setTime(String myTime)
	{
		Time = myTime;
	}
	
	public void setDescription (String myDescription)
	{
		Description = myDescription;
	}
}