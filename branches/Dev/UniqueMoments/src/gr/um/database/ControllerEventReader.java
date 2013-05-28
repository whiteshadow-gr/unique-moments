package gr.um.database;

import gr.um.interfaces.ICelebrationEventReader;

import java.util.ArrayList;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ControllerEventReader 
{
	private static ArrayList<String> importantNames = null; 
	private ICelebrationEventReader reader;

	/**
	 * This function compares the names of the Eortologio RSS to the names of the user's Contacts
	 * and returns an ArrayList containing all the Contacts that have their name day today	
	 */
	/**
	 * ControllerEventReader() constructor with no parameters.
	 */
	public ControllerEventReader()
	{

	}
	
	/**
	 * ControllerEventReader(ICelebrationEventReader reader) constructor with one parameter.	
	 * @param reader
	 */
	public ControllerEventReader(ICelebrationEventReader reader)
	{
		this.reader = reader;
	}
	
	/**
	 * getHowManyCelebrate() this function returns the number of people celebrating today
	 * @return importantNames.size() returns an int with the number of people celebrating
	 */
	public int getHowManyCelebrate()
	{ 
		if (importantNames == null) 
		{
			this.getNamesThatCelebrate();
		}
		 return importantNames.size();
	}
	
	/**
	 * getNamesThatCelebrate() This function compares the names of the Eortologio RSS to the names of the user's Contacts and 
	 * @return returns an ArrayList containing all the Contacts that have their name day today	
	 */
	public ArrayList<String> getNamesThatCelebrate()
	{
		if (importantNames == null) 
		{
			importantNames = reader.getRSSNames();
		}
		return importantNames;
	}
	
	/**
	 * getimportantNames() this function returns the importantNames
	 * @return an ArrayList<String> containing the importantNames
	 */
	public ArrayList<String> getImportantNames()
	{
			return importantNames;
	}	
}