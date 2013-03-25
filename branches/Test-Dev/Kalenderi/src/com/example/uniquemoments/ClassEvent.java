package com.example.uniquemoments;


class event
{
	private String name;
	private String dateTime;
	private String description;
	
	//constructor
	public event()
	{
		name = "";
		dateTime = "";
		description = "";
	}
	
	//constructor
	public event(String myName, String myDateTime, String myDescription)
	{
		name = myName;
		dateTime = myDateTime;
		description = myDescription;
	}
	
	
	//get functions
	public String getName()
	{
		return name;
	}
	
	public String getDateTime()
	{
		return dateTime;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	
	//set functions
	public void setName (String myName)
	{
		name = myName;
	}
	
	public void setDateTime (String myDateTime)
	{
		dateTime = myDateTime;
	}
	
	public void setDescription (String myDescription)
	{
		description = myDescription;
	}
}