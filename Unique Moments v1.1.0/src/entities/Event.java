package entities;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class Event 
{
	private int ID;
	private String Name;
	private String Date;
	private String Time;
	private String Description;
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//constructors
	public Event()
	{
		this.ID = 0;
		this.Name = "";
		this.Date = "";
		this.Time = "";
		this.Description = "";
	}
	
	public Event(String myName, String myDate, String myTime ,String myDescription)
	{
		this.Name = myName;
		this.Date = myDate;
		this.Time = myTime;
		this.Description = myDescription;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//get functions
	public int getID()
	{
		return this.ID;
	}
	
	public String getName()
	{
		return this.Name;
	}
	
	public String getDate()
	{
		return this.Date;
	}
	
	public String getTime()
	{
		return this.Time;
	}
	
	public String getDescription()
	{
		return this.Description;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//set functions
	public void setID(int myID)
	{
		this.ID = myID;
	}
	
	public void setName (String myName)
	{
		this.Name = myName;
	}
	
	public void setDateTime (String myDate)
	{
		this.Date = myDate;
	}
	
	public void setTime(String myTime)
	{
		this.Time = myTime;
	}
	
	public void setDescription (String myDescription)
	{
		this.Description = myDescription;
	}
}