package gr.um.controllers;

import gr.um.interfaces.ICelebrationEventReader;

import java.util.ArrayList;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ControllerFindEvents 
{
	private static ArrayList<String> importantNames = null; 
	private ICelebrationEventReader reader;

	/*
	 * This function compares the names of the Eortologio RSS to the names of the user's Contacts
	 * and returns an ArrayList containing all the Contacts that have their name day today	
	 */
	public ControllerFindEvents()
	{

	}
	
	
	public ControllerFindEvents(ICelebrationEventReader reader)
	{
		this.reader = reader;
	}
	
	public int getHowManyCelebrate()
	{ 
		if (importantNames == null) 
		{
			this.getNamesThatCelebrate();
		}
		 return importantNames.size();
	}
	
	public ArrayList<String> getNamesThatCelebrate()
	{
		if (importantNames == null) 
		{
			importantNames = reader.getRSSNames();
		}
		return importantNames;
	}	
	
	public ArrayList<String> getimportantNames()
	{
			return importantNames;
	}	
}
